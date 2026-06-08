class Solution {
    Node compute(Node head) {
        // code here
         if(head.next == null) 
            return head;

        Node tp = compute(head.next);

        if(tp.data > head.data)
            return tp;

        head.next = tp;

        return head;
    }
}