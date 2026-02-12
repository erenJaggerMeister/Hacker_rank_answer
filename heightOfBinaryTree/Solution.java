package heightOfBinaryTree;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Tree binaryTree = new Tree();
        int totalNode = sc.nextInt();
        for(int i = 0 ; i < totalNode ; i++){
            int iptValue = sc.nextInt();
            if(binaryTree.root==null){}
            binaryTree.insert(iptValue);
        }

        binaryTree.printPreOrder(binaryTree.getRoot());
    }
}

class Tree{
    public Node root;

    public Tree(){
        root = null;
    }

    //====INSERT====
    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value){
        if(root == null){
            return new Node(value);
        }

        if(value < root.value){
            root.left = insertRec(root.left, value);
        } else {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    //====PRINT====
    public void printPreOrder(Node root){
        if(root==null){
            return;
        }
        // System.out.print(root.value+" ");
        printPreOrder(root.left);
        System.out.print(root.value+" ");
        printPreOrder(root.right);
    }

    public Node getRoot(){
        return this.root;
    }
}

class Node{
    public int value;
    public Node left, right;

    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}