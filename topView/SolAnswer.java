package topView;

import java.util.*;

public class SolAnswer {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Tree tree = new Tree();
        int howManyNodes = sc.nextInt();
        for(int i=0 ; i<howManyNodes ; i++){
            int inputNode = sc.nextInt();
            tree.insert(inputNode);
        }

        // tree.printTree(tree.getRoot());
        // System.out.println();
        // tree.printForEachNode(tree.getRoot());
        // System.out.println("Node that can be viewed from top: ");
        tree.printNodeFromTopView();
    }
}

class Tree{
    private Node root;
    private int horizontalDistance;
    private List<Integer> nodeThatCanBeSeenFromTop;
    private HashMap<Integer, Integer> mapHorizontalDistAndValNode;

    public Tree(){
        this.root = null;
        this.horizontalDistance = 0;
        this.nodeThatCanBeSeenFromTop = new ArrayList<>();
        this.mapHorizontalDistAndValNode = new HashMap<>();
    }

    public void insert (int value){
        this.root = insertRec(this.root, value, this.horizontalDistance);
        this.horizontalDistance = 0;
    }

    private Node insertRec(Node root, int value, int horizontalDistance){
        if(root==null){
            //cek apakah node dengan value sekarang ada di di map?
            boolean cekIfCanBeSeenFromTop = false;
            if(!(this.mapHorizontalDistAndValNode.containsKey(horizontalDistance))){
                this.mapHorizontalDistAndValNode.put(horizontalDistance, value);
                this.nodeThatCanBeSeenFromTop.add(value);
                cekIfCanBeSeenFromTop = true;
            } else {
                cekIfCanBeSeenFromTop = false;
            }
            Node finalInsert = new Node(value, horizontalDistance, cekIfCanBeSeenFromTop);
            return finalInsert;
        }

        // System.out.print("Root: "+root.getValue()+" & input value: "+value);

        if(value < root.getValue()){
            this.horizontalDistance = this.horizontalDistance - 1;
            // System.out.println(" & horizontal distance: "+this.horizontalDistance);
            root.setLeft(insertRec(root.getLeft(), value, this.horizontalDistance));
        } else {
            this.horizontalDistance = this.horizontalDistance + 1;
            // System.out.println(" & horizontal distance: "+this.horizontalDistance);
            root.setRight(insertRec(root.getRight(), value, this.horizontalDistance));
        }

        return root;
    }

    //====PRINT==== as pre-order
    public void printTree(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.getValue()+" ");
        printTree(root.getLeft());
        // System.out.print(root.getValue()+" ");
        printTree(root.getRight());
    }

    public void printForEachNode(Node root){
        if(root==null){
            return;
        }
        root.printNode();
        printForEachNode(root.getLeft());
        printForEachNode(root.getRight());
    }

    public void printNodeFromTopView(){
        for(int o : this.nodeThatCanBeSeenFromTop){
            System.out.print(o+" ");
        }
    }

    public Node getRoot(){
        return this.root;
    }
}

class Node{
    private Node left, right;
    private int value, horizontalDistance;
    private boolean canBeSeenFromTop;

    public Node(int value, int horizontalDistance, boolean canBeSeenFromTop){
        this.value = value;
        this.left = null;
        this.right = null;
        this.horizontalDistance = horizontalDistance;
        this.canBeSeenFromTop = canBeSeenFromTop;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHorizontalDistance() {
        return horizontalDistance;
    }

    public void setHorizontalDistance(int horizontalDistance) {
        this.horizontalDistance = horizontalDistance;
    }

    public boolean isCanBeSeenFromTop() {
        return canBeSeenFromTop;
    }

    public void setCanBeSeenFromTop(boolean canBeSeenFromTop) {
        this.canBeSeenFromTop = canBeSeenFromTop;
    }

    public void printNode(){
        System.out.println("Print node value: "+this.value+" & node horizontal distance: "+this.horizontalDistance+" & is can be seen? "+this.canBeSeenFromTop);
    }
}