class Solution {
	public int maxPathSum(int[] a, int[] b) {
		int sm1 = 0, sm2 = 0, n = a.length, m = b.length, i = 0, j = 0, r = 0;
		while (i<n && j<m) {
			if (a[i]<b[j])sm1 += a[i++];
			else if (a[i]>b[j])sm2 += b[j++];
			else {
				r += Math.max(sm1, sm2)+a[i];
				sm1 = 0; sm2 = 0;
				i++; j++;
			}
		}
		while (i<n)sm1 += a[i++];
		while (j<m)sm2 += b[j++];
		return r + Math.max(sm1, sm2);
	}
}