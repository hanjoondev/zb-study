package programmers;

import java.util.*;

public class P42892 {
    static int traverseIdx = 0;
    static int ans[][];

    class Node {
        int x, y, val;
        Node left;
        Node right;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public void insert(Node parent, Node child) {
            if (parent.x > child.x)
                if (parent.left == null)
                    parent.left = child;
                else
                    parent.left.insert(parent.left, child);
            else
                if (parent.right == null)
                    parent.right = child;
                else
                    parent.right.insert(parent.right, child);
        }

        public void traversePreorder(Node root) {
            if (root != null) {
                ans[0][traverseIdx++] = root.val;
                traversePreorder(root.left);
                traversePreorder(root.right);
            }
        }

        public void traversePostorder(Node root) {
            if (root != null) {
                traversePostorder(root.left);
                traversePostorder(root.right);
                ans[1][traverseIdx++] = root.val;
            }
        }
    }

    public int[][] solution(int[][] nodeInfo) {
        Node[] nodes = new Node[nodeInfo.length];
        for (int i = 0; i < nodeInfo.length; i++)
            nodes[i] = new Node(nodeInfo[i][0], nodeInfo[i][1], i + 1);
        Arrays.sort(nodes, (a, b) -> a.y == b.y ? a.x - b.x : b.y - a.y);
        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++)
            root.insert(root, nodes[i]);
        ans = new int[2][nodeInfo.length];
        traverseIdx = 0;
        root.traversePreorder(root);
        traverseIdx = 0;
        root.traversePostorder(root);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P42892().solution(new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } }));
    }
}
