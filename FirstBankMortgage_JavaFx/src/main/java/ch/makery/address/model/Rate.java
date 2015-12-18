package ch.makery.address.model;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import domain.RateDomainModel;

public class Rate extends RateDomainModel {
	
	public static double getPayment(int creditScore, int houseLoan, int term)
	{
		
		double interestrate = RateDAL.getRate(creditScore);
		double I = interestrate/((100)*12);
		int months  = term*12;
		double monthlypayRate = (-1)*FinanceLib.pmt(I,months,houseLoan,0,false);
			
		return monthlypayRate;
	}
}
