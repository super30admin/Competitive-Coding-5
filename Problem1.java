//Beautiful Arrangement
//Time Compplexity - O(n!) for n operations
//Space Complexity - O(n) 
//Run code succssfully on Leetcode - Yes


class Solution {
    public int countArrangement(int n) {
        Set<Integer> numbers = new HashSet<>(); //Creating set for 1-n numbers
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        return countArrangements(n, numbers, new HashSet<>());
    }

    private int countArrangements(int x, Set<Integer> numbers, Set<Integer> current) {
        //Base case
        if (x == 0) {
            return 1;
        }

        int count = 0;
        Set<Integer> numbersCopy = new HashSet<>(numbers);

        for (int num : numbersCopy) {
            //checking divisibility condition
            if (num % x == 0 || x % num == 0) {
                current.add(num);
                numbers.remove(num);
                count += countArrangements(x - 1, numbers, current);
                current.remove(num);
                numbers.add(num);
            }
        }
        return count;
    }
}

