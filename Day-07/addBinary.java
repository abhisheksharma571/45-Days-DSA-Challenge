//Given two binary strings a and b, return their sum as a binary string.

class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder st = new StringBuilder();
        
        while (m >= 0 || n >= 0) {
            int sum = carry;
            if (m >= 0) {
                sum += a.charAt(m) - '0';
                m--;
            }
            if (n >= 0) {
                sum += b.charAt(n) - '0';
                n--;
            }
            st.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            st.append(carry);
        }
        return st.reverse().toString();
    }
}