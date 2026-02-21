#https://leetcode.com/problems/palindrome-number/
#Given an integer x, return true if x is a palindrome, and false otherwise.
def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        stri = str(x) 
        return stri == stri[::-1]
