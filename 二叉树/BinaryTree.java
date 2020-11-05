//孩子表示法
class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

public class BinaryTree {

    //创建一棵树
    public Node creatTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    /*前序遍历*/
    public void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.val + "");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /*中序遍历*/
    public void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    /*后序遍历*/
    public void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }

    /*遍历思想 求节点个数*/
    public static int size = 0;

    public void getSize1(Node root) {
        if (root == null) return;
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    /*子问题思想 求节点个数*/
    public int getSize2(Node root) {
        if (root == null) return 0;
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    /*遍历思想 求叶子节点数*/
    public static int leafSize = 0;

    public void getLeafSize1(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    /*子问题思想 求叶子结点个数*/
    public int getLeafSize2(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    /*子问题思路 求第k层结点个数*/
    int getLevelSize(Node root, int k) {
        if (root == null) return 0;
        if (k == 1) {
            return 1;
        }
        return getLevelSize(root.left, k - 1) + getLevelSize(root.right, k - 1);
    }

    /*获得二叉树的高度*/
    int getHight(Node root) {
        int hight = 0;
        if (root == null) return 0;
        if (root.left != null || root.right != null) {
            hight++;
        }
        return 1;
    }

    /**/
    Node find(Node root,int val) {
        if (root == null) return null;
        if(root.val == val) {
            return root;
        }
        find(root.left,val);
        find(root.right,val);
        return null;
    }
}
