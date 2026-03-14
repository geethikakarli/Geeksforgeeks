class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<Node> q = new LinkedList<>();
        Queue<Integer> hd = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        q.add(root);
        hd.add(0);

        while(!q.isEmpty()){
            Node cur = q.poll();
            int h = hd.poll();

            if(!map.containsKey(h))
                map.put(h, cur.data);

            if(cur.left != null){
                q.add(cur.left);
                hd.add(h-1);
            }
            if(cur.right != null){
                q.add(cur.right);
                hd.add(h+1);
            }
        }

        for(int v : map.values())
            res.add(v);

        return res;
    }
}