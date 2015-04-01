package com.algo;

import java.util.PriorityQueue;

public class MedianMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int LARGEST_INTEGER= 10000;
		int[] allMedians = new int[10000];
		int medianCount =0; 
		String FILE_ADDRESS ="G:/assignment6/task2data.txt";
		
		PriorityQueue<Integer> aQLow= new PriorityQueue<Integer>(); // support extract Max
		
		PriorityQueue<Integer> aQHigh = new PriorityQueue<Integer>();// support extract MIN
		
		In aFile = new In(FILE_ADDRESS);
		
		while(! aFile.isEmpty()){
			
			int incomingInt =  aFile.readInt();
		
		
			if(aQLow.size() ==0) aQLow.add(LARGEST_INTEGER- incomingInt);
			
			
			if (incomingInt< LARGEST_INTEGER- aQLow.peek()){
				
				aQLow.add(LARGEST_INTEGER- incomingInt);
			}
			else if( incomingInt > LARGEST_INTEGER- aQLow.peek()){
				
				aQHigh.add(incomingInt);
			}
		
			// now if un-balance priority queues then work them out to be equal
			if (Math.abs(aQLow.size() - aQHigh.size()) ==2 ){
				
				if(aQLow.size()> aQHigh.size()){
					int balancingNumber =  LARGEST_INTEGER- aQLow.remove();
					
					aQHigh.add(balancingNumber);
					
				}
				else
				{
					int balancingNumber = aQHigh.remove();
					aQLow.add(LARGEST_INTEGER-balancingNumber );
					
				}
				
				
				
			}
			if(aQLow.size()== aQHigh.size()){
				int aMedian = LARGEST_INTEGER-  aQLow.peek();
				allMedians[medianCount++]= aMedian;
				
			}
			else if(aQLow.size()< aQHigh.size()){
				int aMedian =  aQHigh.peek();
				allMedians[medianCount++]= aMedian;
				
			}
			else if(aQLow.size()> aQHigh.size()){
				int aMedian = LARGEST_INTEGER-  aQLow.peek();
				allMedians[medianCount++]= aMedian;
				
			}
			
			
			
			
		}
		System.out.println("Done Reading");
		
		int sum= 0; 
		
		for(int i=0 ; i < allMedians.length; i++){
			
			sum = sum+ allMedians[i];
			//System.out.println(allMedians[i]);
			
		}
		System.out.println(sum % 10000);
		
	/*	PriorityQueue<Integer> aQ = new PriorityQueue<Integer>();
//		
		aQ.add(1000-100);
		aQ.add(1000-15);
		aQ.add(1000-500);*/

////		
/*	while(!aQLow.isEmpty()){
			
			System.out.println(10000- aQLow.remove());
////			
		}*/

	}

}
