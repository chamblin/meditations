/*

	Meditation 002 - The Binary Insertion Sort
	
*/

import java.util.ArrayList;

public class BinaryInsertionSort{
	
	public BinaryInsertionSort(int[] items){
		this.items = items;
		this.sortedItems = new ArrayList<Integer>();
	}
	
	public int[] sortedItems(){
		this.sortItems();
		return this.sortedItemsAsArray();
	}
	
	private void sortItems(){
		for(int i : this.items){
			this.sortedItems.add(this.insertionIndex(i), i);
		}
	}
	
	private int insertionIndex(int value){
		int minIndex = 0;
		int maxIndex = this.sortedItems.size();
		int currentPivot = 0;
		int currentPivotValue = 0;
		
		while(minIndex != maxIndex){
			currentPivot = this.pivot(minIndex, maxIndex);
			currentPivotValue = this.sortedItems.get(currentPivot);
			
			if((currentPivotValue < value) && (minIndex != currentPivot)){
				minIndex = currentPivot;
			}
			else{
				maxIndex = currentPivot;
			}
		}
		
		if((currentPivotValue >= value) || (this.sortedItems.isEmpty())){
			return currentPivot;
		}
		else{
			return currentPivot + 1;
		}
	}
	
	private int pivot(int minIndex, int maxIndex){
		return ((maxIndex + minIndex) / 2);
	}
	
	private int[] sortedItemsAsArray(){
		int[] ret = new int[this.sortedItems.size()];

		for(int i = 0; i < this.sortedItems.size(); i++){
			ret[i] = this.sortedItems.get(i).intValue();
		}
		return ret;
	}
	
	public static void main(String[] argv){
		int[] input = {1,4,3,2,5,6,13,-5,0,0,0,1,5,6,1,1000};
		BinaryInsertionSort sorter = new BinaryInsertionSort(input);
		for(Integer i : sorter.sortedItems()){
			System.out.print(String.format("%d ", i));
		}
		System.out.println("");
	}
	
	private int[] items;
	private ArrayList<Integer> sortedItems;
}