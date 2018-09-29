package data_structure;

public class Sort {
	public void insertSorting(int [] arr) {
		int size = arr.length;
		
		for(int i=1 ; i<size ; i++) {
			int temp = arr[i];
			int j = 0;
			
			for(j=i-1 ; j>=0 && temp < arr[j] ; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
	}
	
	public void bubbleSorting(int [] arr) {
		int swapped = 1;
		for(int i=arr.length-1 ; i>0 && swapped==1; i--) {
			swapped = 0;
			for(int j=0 ; j<i-1 ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped=1;
				}
			}
		}
	}
	
	public void selectSorting(int [] arr) {
		int size = arr.length;
		
		for(int i=0 ; i<size-1 ; i++) {
			int min = i;
			
			for(int j=i+1; j<size ; j++) {
				if(arr[min] > arr[j]) min = j;
			}
			
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public void quickSorting(int [] arr2, int low, int high) {
		if(low < high) {
			int pivot = parition(arr2, low, high);
			quickSorting(arr2, low, pivot-1);
			quickSorting(arr2, pivot+1, high);
		}
	}

	public int parition(int [] arr2, int left, int right) {
		int lo = left;
		int hi = right;

		int pivot = arr2[left];

		while(left < right) {
			while((arr2[left] <= pivot) && left<hi) left++;
			while((arr2[right] > pivot) && lo<right) right--;

			if(left < right) {
				int temp = arr2[right];
				arr2[right] = arr2[left];
				arr2[left] = temp;
			}
		}

		arr2[lo] = arr2[right];
		arr2[right] = pivot;

		return right;
	}
	
	public void mergeSorting(int [] arr, int [] temp, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSorting(arr, temp, left, mid);
			mergeSorting(arr, temp, mid+1, right);
			merge(arr, temp, left, mid, right);
		}
	}
	
	public void merge(int [] arr, int [] temp, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int t = left;
		
		while(i <= mid && j<= right) {
			if(arr[i] <= arr[j]) temp[t] = arr[i++];
			else temp[t] = arr[j++];
			t++;
		}
		
		if(i <= mid) {
			for(int p = i ; p <= mid ; p++, t++) {
				temp[t] = arr[p];
			}
		} else {
			for(int p = j ; p <= right ; p++, t++) {
				temp[t] = arr[p];
			}
		}
		
		for(int p=left ; p<=right ; p++) arr[p] = temp[p];
	}
	
}
