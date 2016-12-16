package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	static double getRate(int GivenCreditScore) 
	{
		double rt = 0.0;

		ArrayList<RateDomainModel> rate = RateDAL.getAllRates();

		for (RateDomainModel c : rate) {
			if (GivenCreditScore == c.getiMinCreditScore()) {
				rt = c.getdInterestRate();
			} else if (rate.contains(GivenCreditScore)) {
				continue;
			} else {
				break;
			}
		}
	if (rt==0){
		throw new RateException(rt);
	}

		return rt;
	}
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
