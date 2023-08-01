class Solution {
    int count;
    ArrayList<Integer> arr;

    public int countArrangement(int n) {
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        helper(arr, set);
        return count;

    }

    public void helper(ArrayList<Integer> arr, HashSet<Integer> set) {
        // base
        if (set.size() == arr.size()) {
            count++;
            return;
        }

        // logic
        for (int i = 0; i < arr.size(); i++) {
            if (set != null && set.contains(arr.get(i)))
                continue;
            if (arr.get(i) % (set.size() + 1) == 0 || (set.size() + 1) % arr.get(i) == 0) {

                set.add(arr.get(i));
                helper(arr, set);
                set.remove(arr.get(i));

            }

        }
    }
}