class Solution {

    public int dominantPairs(int[] arr) {

        int n = arr.length;

        int half = n / 2;

        Arrays.sort(arr, half, n);

        int count =0;

        for (int i = 0; i < half; i++) {

            int left = half;

            int right = n;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (5L * arr[mid] <= arr[i]) {

                    left = mid + 1;

                } else {

                    right = mid;

                }

            }



            count += left - half;

        }



        return count;

    }

}