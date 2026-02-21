#https://leetcode.com/problems/longest-palindromic-substring/
'''
Given a string s, return the longest palindromic substring in s.
'''

def longestPalindrome(self, s):
        longest = ""
        #Find palindromes
        for leftcursor in range(len(s)):
            for rightcursor in range(leftcursor, len(s)):
                substr = s[leftcursor:rightcursor+1]
                if (substr == substr[::-1]) and (len(substr) > len(longest)):
                    longest = substr
        return longest
