//https://leetcode.com/problems/length-of-last-word/

//Given a string s consisting of words and spaces, return the length of the last word in the string. A word is a maximal substring consisting of non-space characters only.

public int lengthOfLastWord(String s) {
        String[] list = s.split(" ");
        return list[list.length-1].length();
    }
