//Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder st = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Adjust to zero-based index
            int remainder = columnNumber % 26;
            char charToAdd = (char) (remainder + 'A');
            st.append(charToAdd);
            columnNumber /= 26;
        }
        
        return st.reverse().toString();
    }
}