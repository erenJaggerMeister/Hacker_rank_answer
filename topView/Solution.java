package topView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int totalNodeForInput = sc.nextInt();
        Tree tree = new Tree();

        for(int i=0 ; i<totalNodeForInput ; i++){
            int inputNode = sc.nextInt();
            tree.insert(inputNode);
        }

        // tree.printPreOrder(tree.getRoot());
        tree.printAllListValueThatCanBeSeenFromTop();
    }
}

class Tree{
    private Node root;
    private int heightTree;
    private int maxHeightTree;
    private int levelHorizontalPosition;
    private List<Integer> listValueThatCanBeSeenFromTop;

    public Tree(){
        root = null;
        this.heightTree = 0;
        this.maxHeightTree = 0;
        this.levelHorizontalPosition = 1;
        this.listValueThatCanBeSeenFromTop = new ArrayList<>();
    }

    //====INSERT====
    public void insert(int value){
        root = insertRec(root, value,this.heightTree, this.levelHorizontalPosition);
        this.heightTree = 0;
    }

    private Node insertRec(Node root, int value, int heightTree,int levelHorizontalPosition){
        if(root == null && this.heightTree==0){
            Node finalInsert = new Node(value,0,levelHorizontalPosition);
            // System.out.println("Horizontal position = "+finalInsert.getHorizontalValuePosition());
            if(finalInsert.isCanBeViewedFromTop()){
                this.listValueThatCanBeSeenFromTop.add(finalInsert.getValue());
            }
            return finalInsert;
        } else if(root == null && this.heightTree!=0){
            Node finalInsert = new Node(value, this.heightTree,levelHorizontalPosition);
            // System.out.println("Horizontal position = "+finalInsert.getHorizontalValuePosition());
            if(finalInsert.isCanBeViewedFromTop()){
                this.listValueThatCanBeSeenFromTop.add(finalInsert.getValue());
            }
            return finalInsert;
        }

        //1 2 5 3 6 4 8 7 9
        this.heightTree++;
        if(this.heightTree>this.maxHeightTree){
            this.maxHeightTree = this.heightTree;
        }

        //postion horizontal
        this.levelHorizontalPosition = root.getHorizontalValuePosition() * 2;

        if(value < root.getValue()){
            root.setLeft(insertRec(root.getLeft(), value, this.heightTree, this.levelHorizontalPosition-1));
        } else {
            root.setRight(insertRec(root.getRight(), value, this.heightTree, this.levelHorizontalPosition));
        }

        return root;
    }

    //====PRINT====
    public void printPreOrder(Node root){
        if(root==null){
            return;
        }
        // System.out.print(root.getValue()+" ");
        printPreOrder(root.getLeft());
        System.out.print(root.getValue()+" ");
        printPreOrder(root.getRight());
    }

    public void printHeightOfTree(){
        System.out.println(maxHeightTree);
    }

    public void printAllListValueThatCanBeSeenFromTop(){
        // System.out.println("\n Print all list value that can be seen from top");
        for(int o : this.listValueThatCanBeSeenFromTop){
            System.out.print(o+" ");
        }
        System.out.println();
    }

    public Node getRoot(){
        return this.root;
    }
}

class Node{
    private int value;
    private Node left, right;
    private int levelHeight;
    private int horizontalValuePosition;
    private boolean canBeViewedFromTop;

    public Node(int value,int heightLevel, int horizontalValue){
        this.value = value;
        this.left = null;
        this.right = null;
        this.levelHeight = heightLevel;
        this.horizontalValuePosition = horizontalValue;

        //check if can be viewed from top
        if(Math.pow(2, levelHeight)==horizontalValuePosition || horizontalValuePosition==1){
            this.canBeViewedFromTop = true;
        } else {
            this.canBeViewedFromTop = false;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLevelHeight() {
        return levelHeight;
    }

    public void setLevelHeight(int levelHeight) {
        this.levelHeight = levelHeight;
    }

    public int getHorizontalValuePosition() {
        return horizontalValuePosition;
    }

    public void setHorizontalValuePosition(int horizontalValuePosition) {
        this.horizontalValuePosition = horizontalValuePosition;
    }

    public boolean isCanBeViewedFromTop() {
        return canBeViewedFromTop;
    }

    public void setCanBeViewedFromTop(boolean canBeViewedFromTop) {
        this.canBeViewedFromTop = canBeViewedFromTop;
    }
}