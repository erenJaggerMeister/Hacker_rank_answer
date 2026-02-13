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

        // binaryTree.printPreOrder(binaryTree.getRoot());
        binaryTree.printHeightOfTree();
    }
}

class Tree{
    public Node root;
    public int heightTree;
    public int maxHeightTree;

    public Tree(){
        root = null;
        this.heightTree = 0;
        this.maxHeightTree = 0;
    }

    //====INSERT====
    public void insert(int value){
        root = insertRec(root, value,this.heightTree);
        this.heightTree = 0;
    }

    private Node insertRec(Node root, int value, int heightTree){
        if(root == null && this.heightTree==0){
            return new Node(value,0);
        } else if(root == null && this.heightTree!=0){
            return new Node(value, this.heightTree);
        }

        //1 2 5 3 6 4 8 7 9
        this.heightTree++;
        if(this.heightTree>this.maxHeightTree){
            this.maxHeightTree = this.heightTree;
        }

        if(value < root.value){
            root.left = insertRec(root.left, value, this.heightTree);
        } else {
            root.right = insertRec(root.right, value, this.heightTree);
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
        System.out.println(root.value+" & level height tree: "+root.levelHeight);
        printPreOrder(root.right);
    }

    public void printHeightOfTree(){
        System.out.println(maxHeightTree);
    }

    public Node getRoot(){
        return this.root;
    }
}

class Node{
    public int value;
    public Node left, right;
    public int levelHeight;

    public Node(int value,int heightLevel){
        this.value = value;
        this.left = null;
        this.right = null;
        this.levelHeight = heightLevel;
    }
}