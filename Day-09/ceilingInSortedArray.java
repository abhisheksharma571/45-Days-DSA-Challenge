//Given a sorted array and a value x, the ceiling of x is the smallest element in an array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume that the array is sorted in non-decreasing order. Write efficient functions to find the floor and ceiling of x. 


class ceilingInSortedArray {
	static int ceilSearch(int arr[], int low, int high, int x){
		if (arr.length == 0) {
			return -1;
		}
		while (low <= high) {
			int mid = low + (high - low) / 2; 

			if (x == arr[mid]) {
				return mid;
			}
			if (x < arr[mid]) {
				high = mid - 1;
			}

			else {
				low = mid + 1;
			}
		}
		return low;
	}
	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = arr.length;
		int x = 8;
		int index = ceilSearch(arr, 0, n - 1, x);
		if (index == -1)
			System.out.println("Ceiling of " + x + " doesn't exist in array");
		else
			System.out.println("ceiling of " + x + " is " + arr[index]);
	}
}
