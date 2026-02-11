import java.util.*;

public class PostOrderTraversal {
    static Node root;
    static Scanner sc = new Scanner(System.in);

    public PostOrderTraversal(){
        root = null;
    }

    public static void main(String[] args) {
        //System.out.println("Tree postorder traversal");
        int totalNodes = sc.nextInt();
        for(int i=0 ; i<totalNodes ; i++){
            int number = sc.nextInt();
            insert(number);
        }
        postOrder(root);
    }

    //====INSERT====
    public static void insert(int key){
        root = insertRec(root, key);
    }

    private static Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.value){
            root.left = insertRec(root.left, key);
        } else if(key > root.value){
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    //====PRINT post order traversal====
    public static void postOrder(Node root){
        if(root == null){
            return;
        }

        postOrder(root.left);

        postOrder(root.right);

        System.out.print(root.value+" ");
    }
}

class Node{
    public int value;
    public Node left;
    public Node right;

    Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}