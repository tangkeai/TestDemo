import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-11-05
 * Time: 10:41
 */
class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {

    public Node createTree() {
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
    // 前序遍历
    void preOrderTraversal(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    void inOrderTraversal(Node root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root){
        if(root == null)return;
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    int getSize2(Node root){
        if(root == null) return 0;
        return getSize2(root.left)+getSize2(root.right)+1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if(root == null) return ;
        if(root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k){
        if(root == null) return 0;
        if(k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1)
                +getKLevelSize(root.right,k-1);
    }

    // 获取二叉树的高度
    int getHeight(Node root){
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ?
                leftHeight+1 : rightHeight+1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, char val) {
        if(root == null) {
            return null;
        }
        //1、根     return
        if(root.val == val) {
            return root;
        }
        //2、左     return
        Node ret1 = find(root.left,val);
        if(ret1 != null) {
            return ret1;
        }
        //3、右边   return
        Node ret2 = find(root.right,val);
        if(ret2 != null) {
            return ret2;
        }
        return null;
    }

    public boolean isSameTree(Node p, Node q) {
        if(p == null && q != null || p != null && q == null) {
            return false;
        }

        if(p == null && q == null) {
            return true;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }

    public boolean isSubtree(Node s, Node t) {
        if(s == null || t == null) return false;

        if(isSameTree(s,t)) return true;

        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;

        return false;
    }
    public boolean isSymmetricChild(Node leftTree,Node rightTree) {
        if(leftTree == null && rightTree != null || leftTree != null
                && rightTree == null) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        if(leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right) &&
                isSymmetricChild(leftTree.right,rightTree.left);
    }
    public boolean isSymmetric(Node root) {
        if(root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }

    // 层序遍历
    void levelOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public List<List<Character>> levelOrder(Node root) {
        List<List<Character>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        //queue:保证顺序
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //rowList:每一行的数据
            List<Character> rowList = new ArrayList<>();
            int count = queue.size();//1
            while (count != 0) {//2->1
                Node cur = queue.poll();
                if(cur != null) {
                    rowList.add(cur.val);
                    if(cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                count--;//0
            }
            ret.add(rowList);
        }
        return ret;
    }

}
