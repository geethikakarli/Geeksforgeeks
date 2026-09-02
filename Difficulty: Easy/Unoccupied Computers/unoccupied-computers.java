class Solution {
    public int solve(int n, String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        int count = 0;


        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                map.remove(ch);
            }
            else{
                if(map.size() < n){
                    if(!set.contains(ch)){
                        map.put(ch, 0);
                    }

                }
                else{

                    if(!set.contains(ch)){
                        count++;
                    }

                    set.add(ch);

                }
            }

        }

        return count;
    }
}