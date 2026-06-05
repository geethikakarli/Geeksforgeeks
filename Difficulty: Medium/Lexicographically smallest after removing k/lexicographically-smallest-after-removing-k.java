class Solution {
    static String lexicographicallySmallest(String S, int k) {
        // code here
        int l = S.length();
        if(power(l)) k/=2;
        else k*=2;
        
        if(k>=l) return "-1";
        Stack<Character> s = new Stack<>();
        
        for(char c : S.toCharArray()){
            while(k>0 && !s.isEmpty() && c-'a'<s.peek()-'a'){
                s.pop();
                k--;
            }
            s.push(c);
        }
        while(k>0){
            k--;
            s.pop();
        }
        StringBuilder ans = new StringBuilder();
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        return ans.reverse().toString();
    }
    static boolean power(int l){
        for(int i=1;i<=l;i*=2){
            if(i==l) return true;
        }
        return false;
    }
}

