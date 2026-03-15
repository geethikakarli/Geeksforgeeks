class Solution {
    static class Pair{
        Node node;
        int hd;
        Pair(Node n,int h){
            node=n;
            hd=h;
        }
    }
    
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            map.putIfAbsent(p.hd,new ArrayList<>());
            map.get(p.hd).add(p.node.data);
            
            if(p.node.left!=null)
                q.add(new Pair(p.node.left,p.hd-1));
            
            if(p.node.right!=null)
                q.add(new Pair(p.node.right,p.hd+1));
        }
        
        for(ArrayList<Integer> list: map.values())
            res.add(list);
        
        return res;
    }
}