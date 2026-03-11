class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] > arr[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1 : mid - st.peek();
                int right = i - mid;
                sum += (long) arr[mid] * left * right;
            }
            st.push(i);
        }
        return (int) sum;
    }
}