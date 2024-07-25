//Given an array arr[] of size N, use Radix Sort Algorithm to sort arr[] in ascending order.

class Solution {
    static int findMax(int[] arr){
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > mx){
                mx = arr[i];
            }
        }
        return mx;
    }
    
    static void countSort(int[] arr, int place){     //this will maintain stability
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for(int i=0;i<arr.length;i++){       //make frequency array
            count[(arr[i]/place)%10]++;
        }
        //make prefix sum array of count array
        for(int i=1;i<count.length;i++){
            count[i] += count[i-1];
        }
        //find the index of each element in the original array and put it in output array
        for(int i=n-1;i>=0;i--){
            int idx = count[(arr[i]/place)%10] - 1;
            output[idx] = arr[i];
            count[(arr[i]/place)%10]--;
        }
        //copy all elements of output to arr
        for(int i=0;i<n;i++){
            arr[i] = output[i];
        }
    }
    
    static void radixSort(int arr[], int n) 
    { 
        int max = findMax(arr);       //get maximum element
        //apply counting sort to sort elements based on place value
        for(int place=1;max/place>0;place*=10){
            countSort(arr,place);
        }
    } 
}