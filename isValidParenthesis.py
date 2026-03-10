#https://leetcode.com/problems/valid-parentheses/
'''
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 
'''

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        open = ['(', '{','[']
        close = [')', '}', ']']
        opened = False
        
        stack = []
        for c in s:
            if not opened and c in open:
                stack.append(c)
                opened = True
            elif opened and c == close[open.index(stack[-1])]:
                stack.pop()
                opened = (stack and stack[-1] in open) 
            elif opened and c in open:
                stack.append(c)
            else:
                return False
        return len(stack) == 0
        
