// User function Template for Java
class Solution {
    static ArrayList<Integer> getTable(int n) {
        ArrayList<Integer> table = new ArrayList<>();
        for (int i =1; i<=10;++i) {
             table.add(i*n);
        }
        return table;
    }
}