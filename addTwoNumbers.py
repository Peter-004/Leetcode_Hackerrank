https://leetcode.com/problems/add-two-numbers/

'''
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self,  l1, l2 ):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        result = ListNode()
        current = result
        carry = 0
                
        l1Ptr = l1
        l2Ptr = l2
        while l1Ptr or l2Ptr: 
                #Instead of adding then splitting the number into a list, we will do our addition in place and handle the carry as we go
                sum = 0
                if l1Ptr:
                        sum += l1Ptr.val
                        l1Ptr = l1Ptr.next
                if l2Ptr:
                        sum += l2Ptr.val
                        l2Ptr = l2Ptr.next
                sum += carry
                carry = sum // 10
                current.next = ListNode(sum % 10)
                current = current.next
                
        if carry > 0:
                current.next = ListNode(carry)
                current = current.next 
        return result.next #skips the dummy head node
