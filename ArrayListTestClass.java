/*
Chao Lin
linc0@sewanee.edu
Project 2
CS 257
This class is the test class for GenericArrayList.java
*/

import java.io.*;
import java.util.Scanner;


public class ArrayListTestClass{
	
	public static void main(String[] args){
		String word;
		GenericArrayList<String> dictionary = new GenericArrayList<String>();
		Scanner sc = new Scanner(System.in);
      	 	try {
  		    File f = new File(args[0]);
  		    Scanner reader = new Scanner(f);
  		    int length = reader.nextInt();
  		    for(int i=0; i<length; i++){
  		 	dictionary.add(reader.next());
  		    } 
		} catch (FileNotFoundException ex) {
     		    System.out.println("cannot locate the file.");
		} catch (NullPointerException ex) {
    		    System.out.println("failed to connect Scanner to the file");
    	        }

      	        while(true){
		    System.out.print("Word to search for: " );
		    word = sc.nextLine();
			
		    int result = dictionary.contains(word);
			
		    if(result!=-1){
			System.out.println("word exists, it is at index "+ result);
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
	}
}
