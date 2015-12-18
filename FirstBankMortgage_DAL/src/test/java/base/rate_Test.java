package base;

import base.RateDAL;
import static org.junit.Assert.*;
import domain.RateDomainModel;
import util.HibernateUtil;
import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class rate_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	//@AfterClass
	//public static void tearDownAfterClass() throws Exception {
	//}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//double testrate = RateDAL.getRate(600);
		//System.out.println(testrate);
		//assertTrue(testrate == 5);
		
		//double testrate2 = RateDAL.getRate(650);
		//System.out.println(testrate2);
		//assertTrue(testrate2 == 4.5);
		
		double testrate3 = RateDAL.getRate(700);
		System.out.println(testrate3);
		assertTrue(testrate3 == 4);
	}
	

}
