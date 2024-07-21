// Given two strings S and P. Find the smallest window in the string S consisting of all the characters(including duplicates) of the string P.  Return "-1" in case there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index.
// Note : All characters are in Lowercase alphabets. 

import java.util.HashMap;

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        if (s == null || p == null || s.length() < p.length()) {
            return "-1";
        }

        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> windowCount = new HashMap<>();

        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int matched = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (pCount.containsKey(c) && windowCount.get(c).intValue() <= pCount.get(c).intValue()) {
                matched++;
            }

            while (matched == p.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (pCount.containsKey(leftChar) && windowCount.get(leftChar).intValue() < pCount.get(leftChar).intValue()) {
                    matched--;
                }
                left++;
            }
            right++;
        }

        return start == -1 ? "-1" : s.substring(start, start + minLen);
    }
}