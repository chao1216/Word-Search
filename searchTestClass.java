/*
Chao Lin
linc0@sewanee.edu
Project 2
CS 257
This class is the test class for Searches.java
*/

import java.io.*;
import java.util.Scanner;

public class searchTestClass extends Searches{
		
 	public static void main (String[] args) {
 		String word;
		String[] arr;
		Scanner sc = new Scanner(System.in);
       		try {
  		    File f = new File(args[0]);
  		    Scanner reader = new Scanner(f);
  		    int length = reader.nextInt();
  		    arr= new String[length];

  	            for(int i=0; i<length; i++){
			arr[i]= reader.next();
		    }
		    while(true){
			System.out.print("Word to search for: " );
			word = sc.nextLine();

			int result = intlinearSearch(arr, word);
			boolean result1 = boolinearSearch(arr,word);
			boolean result2 = binarySearch(arr, word);
			
			if(result!=-1&&result2!=false){
				System.out.println("linearSearch says " + result1 + ", word exists, found at index " + result);
				System.out.println("binarySearch says " + result2 + ", therefore, the word exists ");
				break;
			}
			else{
				System.out.println("word not found, would you like to search for another word? (y/n) ");
				word = sc.nextLine();
				if(word.equals("n")){
					break;
				}
			}
		}
		} catch (FileNotFoundException ex) {
     		 System.out.println("cannot locate the file.");
		} catch (NullPointerException ex) {
    		 System.out.println("failed to connect Scanner to the file");
    		}	
	}
}
