import java.util.*;

public class Sorters
{


    /* 
     * Sorts an array of integers using the selection sort algorithm (moving each element to its proper place). 
     * 
     * @param  list an array of integers to sort. Pre: array out of order, Post: array in order
     */
 
    public static void selectionSort(int[] list) 
    {
		for (int i = 0; i < list.length - 1; i++) 
		{
			// find index of smallest element
			int smallest = i;
			for (int j = i + 1; j < list.length; j++) 	
			{
				if (list[j] < list[smallest]) 
				{
					smallest = j;
				}
			}
			// swap smallest to front
			swap(list, i, smallest);
  		}
    }
	 /**
	 * swaps two elements of an array
	 */
	 public static void swap(int[] list, int i, int j)
	 {
	 	int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	 }
    
     /* 
     * Sorts an array of integers using the insertion sort algorithm (moving each element to its proper place). 
     *  More efficient than Bubble Sort.
     *  Modified from SPlutard, http://www.dreamincode.net/code/snippet516.htm
     * 
     * @param  list an array of integers to sort. Pre: array out of order, Post: array in order
     */
 
    public static void insertionSort(int[] list) 
	 {
	 	int firstOutOfOrder, location, temp;
   
		//Starts at second term, goes until the end of the array.
		for( firstOutOfOrder = 1; firstOutOfOrder < list.length; firstOutOfOrder++)
		{ 
			if ( list[firstOutOfOrder] < list[firstOutOfOrder - 1] )
			{ 
				// If the two are out of order, 
				// we move the element to its rightful place.
	   		temp = list[firstOutOfOrder];
				location = firstOutOfOrder;
				do 
				{ 
					// Keep moving down the array until we find exactly 
					// where it's supposed to go.
	        		list[location] = list[location-1];
	           	location--;
				}
				while (location > 0 && list[location-1] > temp);
					list[location] = temp;
			}
		}
    }

    

    /* 
     * Sorts an array of integers using the merge sort algorithm. This version copies the array to two smaller sub arrays. 
     * 
     * @param  list an array of integers to sort. Pre: array out of order, Post: array in order
     */
	public static void mergeSort(int[] list)
	{
		// base case list.length == 0 – just falls through. 
		if ( list.length > 1 ) 
		{
			// Split the arrays
			int size1 = list.length / 2;
			int size2 = list.length - size1;
			int[] half1 = new int[size1];
			int[] half2 = new int[size2];
			for( int i = 0; i < size1; i++ ) 
			{
				half1[i] = list[i];
			}
			for( int i = 0; i < size2; i++ ) 
			{
				half2[i] = list[i + size1];
			}
			// recursively sort the two smaller arrays
			mergeSort(half1);
			mergeSort(half2);
	 		
			// merge the sorted halves into a sorted whole
			merge(list, half1, half2);
		}
	}
	public static void merge(int[] result, int[] list1, int[] list2) 
	{
		int i1 = 0;
		int i2 = 0;
		for ( int i = 0; i < result.length; i++ ) 
	   {
	   	if( i2 >= list2.length || ( i1 < list1.length && list1[i1] <= list2[i2] ) ) 
	      {
			  	result[i] = list1[i1];
	         i1++;
	      } 
			else 
	      {
	        	result[i] = list2[i2];
				i2++;
	      }
		}
	} 
} 


