//Given a string s, return true if the s can be palindrome after deleting at most one character from it.

class Solution {
    public boolean validPalindrome(String s) {
        return canBePalindrome(s, 0, s.length() - 1, false);
    }

    private boolean canBePalindrome(String s, int left, int right, boolean deleted) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (deleted) {
                    return false; // Already deleted one character, now mismatch
                }
                // Try deleting either character and check both scenarios
                return canBePalindrome(s, left + 1, right, true) || canBePalindrome(s, left, right - 1, true);
            }
        }
        return true;
    }
}
