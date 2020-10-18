import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root != null) {
            Deque<Node> deque = new ArrayDeque<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Node first = deque.poll();
                    if (first != null) {
                        if (i < size - 1) {
                            first.next = deque.peekFirst();
                        }
                        if (first.left != null) {
                            deque.add(first.left);
                        }
                        if (first.right != null) {
                            deque.add(first.right);
                        }
                    }
                }
            }
        }
        return root;
    }
}
