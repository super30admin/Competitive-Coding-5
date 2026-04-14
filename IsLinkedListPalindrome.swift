//
//  IsLinkedListPalindrome.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/3/26.
//

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
 //first take the middle of the linked list
//partition in 2 lists.
//reverse the 2nd linked list
//check if each character is same and the length is same

class DetectPalindromicLinkedListNode {
    
    /*
     Time complexity -> O(n) + O(n) + O(n) = O()
     space complexity -> O(1)
     */
    func isPalindrome(_ head: ListNode?) -> Bool {
        if (head == nil || head?.next == nil) {
            return true
        }
        var slow = head
        var fast = head
        while(fast?.next != nil && fast?.next?.next != nil) {
            fast = fast?.next?.next
            slow = slow?.next
        }

        var newLL = slow?.next
        //reverse newLL
        var current = newLL
        var prev: ListNode?
        while(current != nil) {
            var temp = current?.next
            current?.next = prev
            prev = current
            current = temp
        }

        //prev is the reversed linked list
        fast = prev
        slow?.next = nil
        slow = head
        
        while (fast != nil && fast?.val == slow?.val) {
            slow = slow?.next
            fast = fast?.next
        }
        if (fast != nil) {
            return false
        }
        return true
    }
}
