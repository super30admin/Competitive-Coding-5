# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        
        node = head = ListNode(-1)
        carry = 0
        
        while l1 or l2 or carry:
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0
            
            addition = x+y+carry
            carry = addition // 10
            result = addition % 10
            node.next = ListNode(result)
            node = node.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            
        return head.next
            
        
        