class Solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
       ArrayList<Integer> list=new ArrayList<Integer> ();
       
       double d= (b*b)-(4*a*c);
       if(d<0){
           list.add(-1);
       }
       else{
           
           int x = (int)Math.floor((-1*b+Math.sqrt(d))/(2*a));
           int y = (int)Math.floor((-1*b-Math.sqrt(d))/(2*a));
           
            list.add((Math.max(x,y)));
           list.add((Math.min(x,y)));
       }
        
            return list;
        
    }
    
      
}