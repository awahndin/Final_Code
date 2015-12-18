package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.UUID;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;


public class MortgageController {
	
	@FXML
	private Label incomeLabel = new Label();
	@FXML
	private Label expensesLabel = new Label();
	@FXML
	private Label creditscoreLabel = new Label();
	@FXML
	private Label termLabel = new Label();
	@FXML
	private Label housepriceLabel = new Label();
	@FXML
	private Label lblmortgagePayment = new Label();
	@FXML
	private Label altPaymentLabel = new Label();
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtExpense;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private ComboBox<String> cmbTerm;
	@FXML
	private Button goButton;
	
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    
    @FXML
    private void initialize() {

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void Mortgagecalculation() {
    	lblmortgagePayment.setVisible(false);
    	Double income = Double.parseDouble(this.txtIncome.getText());
    	Double monthlyExpense = Double.parseDouble(this.txtExpense.getText());
    	int creditScore = Integer.parseInt(this.txtCreditScore.getText());
    	Double costOfHouse = Double.parseDouble(this.txtHouseCost.getText());
    	Double term = Double.parseDouble(this.cmbTerm.getValue().toString());
    	Double interestRate = RateDAL.getRate(creditScore);
    	
    	
    
    	int houseLoan = 0;
		int years = 0;
		double housepayment = ch.makery.address.model.Rate.getPayment(creditScore, houseLoan, years);
    	
    	if(housepayment <= income * 0.36 && housepayment <= (income + (monthlyExpense * 2)) * 0.28) {
    		DecimalFormat deciValue = new DecimalFormat("#.##");
    		String Mortgage = deciValue.format(housepayment);
    		
    		this.lblmortgagePayment.setText("This house is to much!");
    		lblmortgagePayment.setVisible(true);
    		this.lblmortgagePayment.setText("You should pay" + Mortgage + "a month");
    	} else {
    		this.lblmortgagePayment.setText("House Cost Too High");
    		System.out.println("mortgage = " + housepayment);
    		System.out.println("income * 0.36 = " + income * 0.36);
    		System.out.println("(Income + Expenses) * 18% = " + (income + (monthlyExpense * 2)) * 0.18);
    	}
 
   }
   
}