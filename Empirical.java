//Andrew Liu
//Programming Assignment 13
//Times sorting methods
//Empirical
//Version 1.0
//4/29/2013
import java.util.*;
public class Empirical
{
/**
* SELECTIONSORT is the costant used for selectionSort
*/
	private static final int SELECTIONSORT = 1;
/**
* INSERTIONSORT is the costant used for insertionSort
*/
	private static final int INSERTIONSORT = 2;
/**
* MERGESORT is the costant used for mergeSort
*/
	private static final int MERGESORT = 3;
/**
* ARRAYSORT is the costant used for arraySort
*/
	private static final int ARRAYSORT = 4;
/**
* INCREASING is the costant used for an increasing seed array
*/
	private static final int INCREASING = 1;
/**
* DECREASING is the costant used for a decreasing seed array
*/
	private static final int DECREASING = -1;
/**
* RANDOM is the costant used for a RANDOM seed array
*/
	private static final int RANDOM = 0;
/**
* ARRAYSIZE is the costant used to determine seed array size
*/
	private static final int ARRAYSIZE = 50000;
/**
* main method which prints out headers and times
*/
	public static void main(String[] args)
	{
		int[] list1 = createSeedArray(INCREASING);//creates an increasing seed array
		System.out.printf("  %13s %-8d%-8d%-8d%-8d%-8d\n", "Increasing", 1000, 5000, 10000, 20000, 50000);//prints header
		printTimes(list1,SELECTIONSORT);//prints times
		printTimes(list1,INSERTIONSORT);
		printTimes(list1,MERGESORT);
		printTimes(list1,ARRAYSORT);
		System.out.println();		
		int[] list2 = createSeedArray(DECREASING);//creates a decreasing seed array
		System.out.printf("  %13s %-8d%-8d%-8d%-8d%-8d\n", "Decreasing", 1000, 5000, 10000, 20000, 50000);
		printTimes(list2,SELECTIONSORT);
		printTimes(list2,INSERTIONSORT);
		printTimes(list2,MERGESORT);
		printTimes(list2,ARRAYSORT);
		System.out.println();
		int[] list3 = createSeedArray(RANDOM);//creates a random seed array
		System.out.printf("  %13s %-8d%-8d%-8d%-8d%-8d\n", "Random", 1000, 5000, 10000, 20000, 50000);
		printTimes(list3,SELECTIONSORT);
		printTimes(list3,INSERTIONSORT);
		printTimes(list3,MERGESORT);
		printTimes(list3,ARRAYSORT);
	}
/**
* createSeedArray creates the array from which all the others are copied
* @param int sortType is the kind of seed array produced
* @return int[] seedArray is the copied array
*/
	private static int[] createSeedArray(int sortType)
	{
		int[] seedArray = new int[ARRAYSIZE];
		if(sortType == INCREASING)//creates an increasing array
		{
			for(int ii = 0; ii < ARRAYSIZE; ii++)
			{
				seedArray[ii] = ii;
			}
		}
		if(sortType == DECREASING)//creates a decreasing array
		{
			for(int ii = 0; ii < ARRAYSIZE; ii++)
			{
				seedArray[ii] = ARRAYSIZE - ii - 1;
			}
		}
		if(sortType == RANDOM)//creates a random array
		{
			Random r = new Random();
			for(int ii = 0; ii < ARRAYSIZE; ii++)
			{
				seedArray[ii] = r.nextInt(ARRAYSIZE-1);
			}
		}
		return seedArray;
	}
/**
* getTime gets the time for each sorting method
* @param int[] list is the list of integers
* @param int sortingMethod is the sorting method tested
* @return long time returns the time taken
*/
	private static long getTime(int[] list, int sortingMethod)
	{
		long time = 0;
		if( sortingMethod == SELECTIONSORT )//for selection sort
		{
			System.gc();
			long beginTime = System.currentTimeMillis();//times the sorting
			Sorters.selectionSort(list);
			long endTime = System.currentTimeMillis();
			time = endTime - beginTime;
		}
		if( sortingMethod == INSERTIONSORT )//for insertion sort
		{
			System.gc();
			long beginTime = System.currentTimeMillis();
			Sorters.insertionSort(list);
			long endTime = System.currentTimeMillis();
			time = endTime - beginTime;
		}
		if( sortingMethod == MERGESORT )//for merge sort
		{
			System.gc();
			long beginTime = System.currentTimeMillis();
			Sorters.mergeSort(list);
			long endTime = System.currentTimeMillis();
			time = endTime - beginTime;
		}
		if( sortingMethod == ARRAYSORT )//for Arrays.sort()
		{
			System.gc();
			long beginTime = System.currentTimeMillis();
			Arrays.sort(list);
			long endTime = System.currentTimeMillis();
			time = endTime - beginTime;
		}
		return time;
	}
/**
* printTimes prints the times of the tests
* @param int[] seedArray is the seed array given
* @param int sorter is the type of sorting used
*/
	private static void printTimes(int[] seedArray, int sorter)
	{
		int size = 1000;//for size 1000
		int[] array1 = Arrays.copyOf(seedArray, size);//copies array
		long time1 = getTime(array1, sorter);
		size = 5000;//for size 5000
		int[] array2 = Arrays.copyOf(seedArray, size);
		long time2 = getTime(array2, sorter);
		size = 10000;//for size 10000
		int[] array3 = Arrays.copyOf(seedArray, size);
		long time3 = getTime(array3, sorter);
		size = 20000;//for size 20000
		int[] array4 = Arrays.copyOf(seedArray, size);
		long time4 = getTime(array4, sorter);
		size = 50000;//for size 50000
		int[] array5 = Arrays.copyOf(seedArray, size);
		long time5 = getTime(array5, sorter);
		String type = "";
		if(sorter == 1)
		{
			type = "selectionSort";
		}
		else if(sorter == 2)
		{
			type = "insertionSort";
		}
		else if(sorter == 3)
		{
			type = "mergeSort";
		}
		else if(sorter == 4)
		{
			type = "Arrays.sort";
		}
		System.out.printf("  %13s %-8d%-8d%-8d%-8d%-8d\n", type, time1, time2, time3, time4, time5);//prints out times
	}
}