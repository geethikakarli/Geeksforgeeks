class Solution{
    ArrayList<Integer>arr = new ArrayList<>();
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        Vsum(root);
        return arr;
    }
    public void VsumR(Node root,int hd,TreeMap<Integer,Integer>map)
    {
        if(root == null)return;
        VsumR(root.left,hd-1,map);
        //previous vertical sum (psum) if there is alredy a key at same vertical line 
        //than it assigns the previous encountered value to psum 
        //and then this value is finally updated later.
        int psum = (map.get(hd)==null)?0:map.get(hd);
        map.put(hd,psum+root.data);
        VsumR(root.right,hd+1,map);
    }
    public void Vsum(Node root)
    {
        TreeMap<Integer,Integer>map = new TreeMap<>();
        VsumR(root,0,map);
        for(Map.Entry<Integer,Integer>entry :map.entrySet())
        arr.add(entry.getValue());
    }
}
