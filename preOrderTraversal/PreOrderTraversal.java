package preOrderTraversal;

import java.util.Scanner;

public class PreOrderTraversal {
    static Node root;
    static Scanner sc = new Scanner(System.in);

    public PreOrderTraversal(){
        root = null;
    }

    public static void main(String[] args) {
        int totalNode = sc.nextInt();
        for(int i=0;i<totalNode;i++){
            int iptNode = sc.nextInt();
            insert(iptNode);
        }
        //print node
        printPreOrderTraversal(root);
    }

    //====INSERT====
    public static void insert(int key){
        root = insertRec(root, key);
    }

    private static Node insertRec(Node root, int key){
        if(root==null){
            root = new Node(key);
            return root;
        }

        if(key < root.value){
            root.left = insertRec(root.left, key);
        } else if (key > root.value){
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    //====PRINT====
    public static void printPreOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.value+" ");//pre order
        printPreOrderTraversal(root.left);
        // System.out.print(root.value+" ");//in order
        printPreOrderTraversal(root.right);
        // System.out.print(root.value+" ");//post order
    }
}

class Node{
    public int value;
    Node left, right;

    Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}