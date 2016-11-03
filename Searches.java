/*
Chao Lin
linc0@sewanee.edu
Project 2
CS 257
*/

public class Searches{

	/**
	*intlinearSearch - Search an array for specific target
	* @param data, t 
	* 	data is the array of a type, t is the target
	* @precondition 
	*	array data != null. 
	* @return 
	*	index of target if found. -1 otherwise.
	*/
	public static <T> int intlinearSearch(T[] data, T t) {

		for(int i=0; i<data.length; i++) {
			if(data[i].equals(t)) {
				return i;
			} 
		}
		return -1;
	}

	/**
	*boolinearSearch - Search an array for specific target
	* @param data, t 
	* 	data is the array of a type, t is the target
	* @precondition 
	*	array data != null. 
	* @return 
	*	true if target is found, false otherwise.
	*/
	public static <T> boolean boolinearSearch(T[] data, T t) {

		for(int i=0; i<data.length; i++) {
			if(data[i].equals(t)) {
				return true;
			} 
		}
		return false;
	}

	/**
	*binarySearch - Search an array for a specific target
	*@param data,t
	* 	data is the array of a type, t is the target
	*@precondition 
	* 	array data != null
	*@return 
	*	true if target is found, false otherwise
	**/
	public static <T extends Comparable> boolean binarySearch(T[] data, T target){
		int low=0, high=data.length-1;

		while(low<=high){
			int mid = low+(high-low)/2;
			if(data[mid].compareTo(target)==0){
				return true;
			} else if(data[mid].compareTo(target)<0){
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return false;
	}
	
}
