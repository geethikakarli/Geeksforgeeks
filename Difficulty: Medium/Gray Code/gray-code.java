class Solution {
    public ArrayList<String> graycode(int n) {  
        ArrayList<String> res = new ArrayList<>();
        
        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1);

            String binary = Integer.toBinaryString(gray);

            while (binary.length() < n) {
                binary = "0" + binary;
            }

            res.add(binary);
        }

        return res;
    }
}