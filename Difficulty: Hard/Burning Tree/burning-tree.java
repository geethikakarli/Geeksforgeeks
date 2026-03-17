class Solution {
    public static int minTime(Node root, int target) {
        Map<Node, Node> parent = new HashMap<>();
        Node targetNode = buildParent(root, parent, target);

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    burned = true;
                    visited.add(curr.left);
                    q.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    burned = true;
                    visited.add(curr.right);
                    q.add(curr.right);
                }

                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    burned = true;
                    visited.add(parent.get(curr));
                    q.add(parent.get(curr));
                }
            }

            if (burned) time++;
        }

        return time;
    }

    private static Node buildParent(Node root, Map<Node, Node> parent, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data == target) targetNode = curr;

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        return targetNode;
    }
}