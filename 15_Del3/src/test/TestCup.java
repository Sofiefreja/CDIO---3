package test;

import static org.junit.Assert.*;

import org.junit.Test;
import game.Cup;

public class TestCup {
	
	@Test
	public void test() {
		Cup cup = new Cup();
		System.out.println(cup.roll());
		/*
		 * Uses mean values to determine if the cup throws values within some threshholds of the expected mean value.
		 */
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
