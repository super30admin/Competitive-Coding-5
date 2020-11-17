// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if root not nil put root in q
till q is not empty loop in size of q
set max as min value
if in for loop pop element from q and if its value is more than current max then set it in max
if left and right child of element exist push into q
append to res and return
*/
package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func largestValues(root *TreeNode) []int {
	res := []int{}
	if root == nil {
		return res
	}
	q := []*TreeNode{root}
	for len(q) > 0 {
		size := len(q)
		max := -2147483648
		for x:=0;x<size;x++{
			ele := q[0]
			q = q[1:]
			if max < ele.Val {
				max = ele.Val
			}
			if ele.Left != nil {
				q=append(q, ele.Left)
			}
			if ele.Right != nil {
				q=append(q, ele.Right)
			}
		}
		res=append(res, max)
	}
	return res
}

func MainLargestInTreeRow() {
	root := &TreeNode{Val: 1, Left: &TreeNode{Val: 3, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 3}}, Right: &TreeNode{Val: 2, Right: &TreeNode{Val: 9}}}
	fmt.Println(largestValues(root)) //expected [1,3,9]
}