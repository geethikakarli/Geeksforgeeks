class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            char maxChar = arr[i];
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= maxChar) {
                    maxChar = arr[j];
                    maxIndex = j;
                }
            }

            if (maxChar > arr[i]) {
                char temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
                break;
            }
        }

        return new String(arr);
    }
}