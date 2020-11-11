/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-11-05
 * Time: 10:40
 */


public class TestDemo {

    public static int fib(int n) {
        if(n == 1 || n == 2) return 1;

        return fib(n-1)+fib(n-2);
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createTree();
        System.out.println();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println(binaryTree.getLeafSize2(root));
        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println("=============================");
        System.out.println(binaryTree.getKLevelSize(root,3));
        System.out.println("=================================");
        System.out.println(binaryTree.getHeight(root));
        System.out.println("========================");
        Node ret = binaryTree.find(root,'K');
        if(ret == null) {
            System.out.println("没有这个节点");
        }else {
            System.out.println(ret.val);
        }
        binaryTree.levelOrderTraversal(root);
        System.out.println();
    }
}
