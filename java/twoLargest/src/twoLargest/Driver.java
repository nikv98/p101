package twoLargest;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		int[] array = new int[4];
		Random r = new Random();
		for(int n = 0; n < array.length; n++){
			array[n] = r.nextInt(10)+1;
		}
		
		int largest = array[0];
		int second = array[1];
		
		for(int i = 1; i < array.length; i++){
			if(array[i] > largest){
				second = largest;
				largest = array[i];
			}else if(array[i] > second){
				second = array[i];
			}
		}
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
		System.out.println("largest: " + largest);
		System.out.println("second: " + second);
	}

}
