package doc;

public class Sort {

	public static void main(String[] args) {
		int [] arr = {2, 3, 2, 5 ,9, 4, 3, 1 , 5 ,15};
		//int [] arr = {1, 2, 5 ,9, 4, 3,15};
		//insertSort(arr);
		//quickSort(arr, 0, arr.length-1);
		//coutingSort(arr);
		arr =   radixSort(arr);
		print(arr);
	}

	public static void print(int [] a) {
		for(int k : a) {
			System.out.print(k + " ");
		}
	}


	public static void selectSort(int [] array) {
		for(int i=0 ; i<array.length ; i++) {
			int min = i;
			for(int j=i+1 ; j< array.length-1 ; j++){
				if(array[min] > array[j]) {
					min = j;
				}
			}
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}

	public static void bubbleSort(int [] array) {
		for(int i=array.length-2; i>=0 ; i--) {
			for(int j=0 ; j<=i ; j++) {
				if(array[j] > array[j+1]){
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void insertSort(int [] array) {
		for(int i=1; i< array.length; i++) {
			int temp = array[i];
			int j = i;

			while(j>=1 && array[j-1] > temp) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
		}
	}

	public static void quickSort(int [] array, int low, int high) {
		if(low < high) {
			int pivot = pivot(array, low, high);
			quickSort(array, low, pivot-1);
			quickSort(array, pivot+1, high);
		}

	}

	public static int pivot(int [] array, int low, int high) {
		int pivot_item = array[low];
		int left = low, right = high;

		while(left < right) {
			while(array[left] <= pivot_item) left++;
			while(array[right] > pivot_item) right--;

			if(left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}

		array[low] = array[right];
		array[right] = pivot_item;

		return right;
	}

	public static void coutingSort(int [] array) {
		/*
		 * 1. 배열의 최대값을 구하고 그 최대값+1 만큼의 새로운 버킷을 만든다.
		 * 2. 각 인덱스는 전달된 배열의 숫자 카운팅을 입력하면 된다. 예를 들어 arr = { 1 , 4 , 2, 9 , 3 ,1} 이면 최대값이 9이므로 보다 1이 큰 사이즈의 배열 생성
		 * 3. 1 이므로 새로운 배열의 첫번째 인덱스를 1 증가, 4이므로 4번째 인덱스 1증가, 쭈주주주 하게되면 새로운 배열은
		 * 4. 0 - 0, 1 - 2, 2 - 1, 3 - 1, 4 - 1, 5~8 - 0 , 9 - 1 의 카운트를 갖게 되면 해당 숫자만큼 출력을 하면 됨, 1 1 2 3 4 9 가 정렬된 상태가 
		 */
		int max = 0;
		for(int i=0 ; i<array.length ; i++) {
			if(max < array[i]) max = array[i];
		}

		int [] bucket = new int[max+1];
		int [] sortedArray = new int[array.length];

		for(int i=0 ; i<bucket.length ; i++) bucket[i] = 0;
		for(int value : array) bucket[value]++;

		/*		for(int i=0 ; i<bucket.length ; i++) {
			System.out.print(bucket[i] + " ");
		}
		System.out.println();*/

		for (int i = 1; i < bucket.length; i++) bucket[i] += bucket[i - 1]; // 누적해서 더하기 인덱스화를 위해


		/*for(int i=0 ; i<bucket.length ; i++) {
			System.out.print(bucket[i] + " ");
		}
		System.out.println();*/

		for(int i= array.length-1; i>=0 ; i--) {
			System.out.println(array[i] + " " + bucket[array[i]]);
			sortedArray[--bucket[array[i]]] = array[i];
		}

		/*		for(int i=0 ; i<sortedArray.length ; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		System.out.println();*/

	}

	public static int [] radixSort(int [] array) {
		for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
			int[] tmp = new int[array.length];
			int j = 0;
			for (int i = 0; i < array.length; i++) {
				boolean move = array[i] << shift >= 0;
				if (shift == 0 ? !move : move) {
					tmp[j] = array[i];
					j++;
				} else {
					array[i - j] = array[i];
				}
			}
			for (int i = j; i < tmp.length; i++) {
				tmp[i] = array[i - j];
			}
			array = tmp;
		}
		return array;
	}

}
