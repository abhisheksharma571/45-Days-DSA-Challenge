// You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
// Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.

// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).


class Solution {
    public static long findPages(int n, int[] books, int students) {
        if(n < students) return -1;
        //range will max of array and sum of array
        int start = Integer.MIN_VALUE;  // for finding max element
        int end = 0; //sum of array
        for(int i=0;i<n;i++){
            if(books[i] > start){
                start = books[i];
            }
            end = end + books[i];
        }
        int res = -1;
        while(start <= end){
            //max pages that can be allocated to single student
            int mid = start + (end - start)/2;
            //if allocation is possible, then minimize the no of pages
            if(isAllocationPossible(books, mid, students)){
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
    public static boolean isAllocationPossible(int books[], int maxPages, int students){
        int currentStudent = 1;
        int pages = 0;
        for(int i=0;i<books.length;i++){
            pages += books[i];
            //if pages exceed maxPages
            if(pages > maxPages){
                //allocate to next student
                currentStudent++;
                pages = books[i];
            }
            if(currentStudent > students){
                return false;
            }
        }
        return true;
    }
};