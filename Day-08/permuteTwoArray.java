//Given two arrays of equal size n and an integer k. The task is to permute both arrays such that sum of their corresponding element is greater than or equal to k i.e a[i] + b[i] >= k. The task is to print “Yes” if any such permutation exists, otherwise print “No”.

import java.util.*;

class permuteTwoArray {
static boolean isPossible(Integer a[], int b[], int n, int k) {
    Arrays.sort(a, Collections.reverseOrder());
    Arrays.sort(b);
    for (int i = 0; i < n; i++)
    if (a[i] + b[i] < k)
        return false;
    return true;
}

// Driver code
public static void main(String[] args) {
    Integer a[] = {2, 1, 3};
    int b[] = {7, 8, 9};
    int k = 10;
    int n = a.length;

    if (isPossible(a, b, n, k))
    System.out.print("Yes");
    else
    System.out.print("No");
    }
}