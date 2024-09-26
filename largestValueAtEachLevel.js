// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Any problem you faced while coding this : no

// BFS Approach
var largestValues = function (root) {
  let que = [root];
  const resultsArr = [];
  if (root === null) return resultsArr;

  while (que.length) {
    let len = que.length;
    let compareArr = [];

    while (len--) {
      root = que.shift();
      if (root.left !== null) {
        que.push(root.left);
      }
      if (root.right !== null) {
        que.push(root.right);
      }
      compareArr.push(root.val);
    }
    let greatestVal = Math.max(...compareArr);
    resultsArr.push(greatestVal);
  }
  return resultsArr;
};
