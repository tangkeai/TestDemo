
public class BinarySearchTree {
    //内部类
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static Node root = null;

    /**
     * 在搜索树上找key的值，找到返回key所在的结点，没有找到则返回null
     * @param key
     * @return
     */
   public static Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (cur.val == key) {
                return cur;
            } else if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    /**
     * 插入
     * 忽略插入相同的数据（返回false）
     * 插入的位置都在叶子结点
     * @param key
     * @return
     */
    public static boolean insert(int key) {
        if (root == null) {
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(key == cur.val) {
                return false;
            }else if (key > cur.val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        Node node = new Node(key);
        if (key < parent.val) {
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    /**
     * 删除指定元素
     * 1.要删除节点的左子树为空(3种情况)
     * 2.要删除节点的右子树为空(3种情况)
     * 3.要删除节点左右子树都不为空 替代法 在删除节点的左子树找最小值替代要删除的元素(3种情况)
     *   1)tp.right = cur  tp.right = target.right
     *   2)tp.left = cur   tp.left = targrt.right
     * @param key 传入要删除的数
     * @return 返回节点
     */
    public static Node delete(int key) {
        Node cur = root;
        Node parent = null;
        //遍历数组找到要删除的结点
        while (root != null) {
            if (cur.val == key) {
                return remove(parent,cur);
            }else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        return null;
    }

    public static Node remove(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
                //return root;
            }else if (cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
                //return root;
            }else if (cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node targetparent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetparent = target;
                target = target.left;
            }
            cur.val = target.val;
            //删除被替换的元素
            if(target == targetparent.left) {
                targetparent.left = target.right;
            }else {
                targetparent.right = target.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] array = {15,23,19,67,4,19,10};
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
        insert(24);
        inorder(root);
        System.out.println("===============");
        preorder(root);
        System.out.println("===============");
        try {
            delete(20);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有此节点！");
        }
        inorder(root);
        System.out.println("===============");
        preorder(root);
        try {
            System.out.println(search(27).val);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有这个节点！");
        }
        System.out.println("=============");
    }
}



