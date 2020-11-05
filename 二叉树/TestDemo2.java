

public class TestDemo2 {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.creatTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);
        System.out.println(binaryTree.getSize2(root));
        System.out.println();
        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println(binaryTree.getLeafSize2(root));
        System.out.println();
        System.out.println(binaryTree.getLevelSize(root, 3));
        System.out.println();
        System.out.println(binaryTree.find(root, 'C'));

    }
}
