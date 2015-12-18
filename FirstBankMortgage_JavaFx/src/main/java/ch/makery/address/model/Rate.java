package ch.makery.address.model;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import domain.RateDomainModel;

public class Rate extends RateDomainModel {
	
	public static double getPayment(int creditScore, int houseLoan, int years)
	{
		
		double interestrate = RateDAL.getRate(creditScore);
		double I = interestrate/1200;
		int months  = years*12;
		double monthlypay = (-1)*FinanceLib.pmt(I,months,houseLoan,0,false);
			
		return monthlypay;
	}
}