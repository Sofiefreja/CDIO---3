package test;

import static org.junit.Assert.*;

import org.junit.Test;
import game.Cup;
import game.FakeCup;

public class TestCup {
	@Test
	public void TC3(){
		//Tests the methods getEquals, getD1 and getD2.
		FakeCup cup = new FakeCup(5,5);
		
		//tests all the methods with expected outcome.
		assertEquals(cup.roll(), 10);
		assertEquals(cup.getSum(),10);
		assertEquals(cup.getD1(),5);
		assertEquals(cup.getD2(),5);
		assertTrue(cup.getEquals());
	}
	@Test
	public void TC4() {

		/*
		 * Uses mean values to determine if the cup throws values within some threshholds of the expected mean value.
		 */
		Cup cup = new Cup();
		int n=100000;//define number of rolls
		boolean test=false; //initializes the boolean test value.
		double lowerThreshold=6.95;//define lower threshold for an acceptable mean
		double upperThreshold=7.05;//define upper threshold for an acceptable mean
		double sum=0.0;
		double mean=0.0;
		int[]arr=new int[n];
		for(int i=0;i<n;i++){//rolling n times
			cup.roll();
			if(cup.getSum()>12 || cup.getSum()<2){ // if the value of the combined dices are not between 2 and 12, the test fails.
				fail("Not yet implemented");
			}
			arr[i]=cup.getSum();
		} 	
		for(double a : arr){ //summing the values
			sum+=a;
		}
		mean=sum/(double)arr.length;//calculating mean
		if(mean>lowerThreshold &&mean<upperThreshold){//true if mean is within the threshold boundaries
			test=true;
		}
		assertTrue(test);//asserts the boolean value of "test"
	}
	
	

}
