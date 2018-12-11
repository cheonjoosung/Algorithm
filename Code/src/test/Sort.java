package test;

public class Sort {
	public void print(int [] arr) {
		for(int val : arr) 
			System.out.print(val + " ");
		System.out.println();
	}
	
	//삽입정렬
	public void insertSort() {
		int [] arr = { 15, 1, 1, 3, 8, 5, 4};
		
		int j = 0;
		for(int i=1 ; i<arr.length ; i++) {
			int temp = arr[i];
			
			for(j=i-1 ; j>=0 && temp<arr[j] ; j--)
				arr[j+1] = arr[j];
			
			arr[j+1] = temp;
		}
		
		print(arr);
	}
	
	//버블정렬
	public void bubbleSort() {
		int [] arr = { 15, 1, 1, 3, 8, 5, 4};
		
		int swapped = 1;
		for(int i=arr.length-1 ; i>=0 && swapped==1; i--) {
			swapped = 0;
			for(int j=0 ; j<i ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = 1;
				}
			}
		}
		
		print(arr);
	}
	
	//선택정렬
	public void selectSort() {
		int [] arr = { 15, 1, 1, 3, 8, 5, 4};
		
		for(int i=0 ; i<arr.length ; i++) {
			int min = i;
			
			for(int j=i+1; j<arr.length ; j++) {
				if(arr[min] > arr[j]) min = j;
			}
			
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
		print(arr);
	}
	
	//합병정렬
	public void mergeSort(int [] arr, int [] temp, int left, int right) {
		if(left < right) {
			int mid = (left+right) / 2;
			mergeSort(arr, temp, left, mid);
			mergeSort(arr, temp, mid+1, right);
			merge(arr, temp, left, mid, right);
		}
	}
	
	public void merge(int [] arr, int [] temp, int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int t = left;
		
		while(i<=mid && j<=right) {
			if(arr[i] <= arr[j]) temp[t++] = arr[i++];
			else temp[t++] = arr[j++];
		}
		
		if(i<=mid) {
			for(int p=i ; p<=mid ; p++) temp[t++] = arr[p];
		} else {
			for(int p=j ; p<=right ; p++) temp[t++] = arr[p];
		}
		
		//정렬된 것을 원래의 배열에 복사
		for(int p=left ; p<=right ; p++) arr[p] = temp[p];
	}
	
	//퀵정렬
	public void quickSort(int [] arr, int left, int right) {
		if(left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
	public int partition(int [] arr, int left ,int right) {
		int lo = left;
		int hi = right;
		
		int pivot = arr[left];
		
		while(left < right) {
			while((arr[left] <= pivot) && left<hi) left++;
			while((arr[right] > pivot) && right>lo) right--;
			
			if(left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		
		arr[lo] = arr[right];
		arr[right] = pivot;
		
		return right;
	}
}
