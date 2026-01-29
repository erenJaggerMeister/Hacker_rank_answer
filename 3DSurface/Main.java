import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int hTotal = sc.nextInt();
        int wTotal = sc.nextInt();
        List<List<Integer>> boardGame = new ArrayList<>();
        for(int i=0;i<hTotal;i++){
            List<Integer> numberCubes = new ArrayList<>();
            for(int j=0;j<wTotal;j++){
                numberCubes.add(sc.nextInt());
            }
            boardGame.add(numberCubes);
        }
        // System.out.println("Print board: ");
        // printBoard(boardGame);
        int total = surfaceArea(boardGame);
        System.out.println(total);
    }

    public static int surfaceArea(List<List<Integer>> A){
        List<List<SurfaceBoard>> surfaceBoard = new ArrayList<>();
        int totalBaris = A.size();
        int totalKolom = A.get(0).size();
        //hitung papan 
        if(totalBaris==1&&totalKolom==1){ //untuk board 1x1
            // System.out.println("Papan solo 1 x 1");
            List<SurfaceBoard> soloBoard = new ArrayList<>();
            SurfaceBoard soloResult = soloBoard(A, 0, 0);
            soloResult.countTotalNumberSide();
            soloBoard.add(soloResult);
            surfaceBoard.add(soloBoard);
        }
        if(totalBaris==1&&totalKolom>1){//board horizontal
            // System.out.println("Papan horizontal");
            List<SurfaceBoard> horizontalBoard = new ArrayList<>();
            for(int column = 0 ; column < A.get(0).size() ; column++){
                if(column==0){
                    SurfaceBoard leftestSurface = horizontalLeft(A, 0, column);
                    leftestSurface.countTotalNumberSide();
                    horizontalBoard.add(leftestSurface);
                }
                if(column==A.get(0).size()-1){
                    SurfaceBoard leftestSurface = horizontalRight(A, 0, column);
                    leftestSurface.countTotalNumberSide();
                    horizontalBoard.add(leftestSurface);
                }
                if(column>0 && column<A.get(0).size()-1){
                    SurfaceBoard leftestSurface = horizontalMiddle(A, 0, column);
                    leftestSurface.countTotalNumberSide();
                    horizontalBoard.add(leftestSurface);
                }
            }
            surfaceBoard.add(horizontalBoard);
        }
        if(totalBaris>1&&totalKolom==1){
            // System.out.println("Papan vertikal");
            
            for(int row = 0; row<A.size();row++){
                List<SurfaceBoard> vertikalBoards = new ArrayList<>();
                // System.out.println(" papan vertikal, baris = "+row+" | kolom = 0");
                if(row==0){
                    SurfaceBoard mostUpSurface = vertikalUp(A, row, 0);
                    mostUpSurface.countTotalNumberSide();
                    vertikalBoards.add(mostUpSurface);
                }
                if(row==A.size()-1){
                    SurfaceBoard mostBottomSurface = vertikalBottom(A, row, 0);
                    mostBottomSurface.countTotalNumberSide();
                    vertikalBoards.add(mostBottomSurface);
                }
                if(row>0 && row<A.size()-1){
                    SurfaceBoard middlevertikalSurface = vertikalMiddle(A, row, 0);
                    middlevertikalSurface.countTotalNumberSide();
                    vertikalBoards.add(middlevertikalSurface);
                }
                surfaceBoard.add(vertikalBoards);
            }
            
        }
        if(totalBaris>1 && totalKolom>1){ // papan 2 dimensi
            // System.out.println("Papan board 2 dimensi");
            surfaceBoard = arrayBoardTwoDimension(A);
        }
        //==============================================================================================
        //print board surface
        // System.out.println("Print board surface");
        // for(int row=0;row<A.size();row++){
        //     for(int col=0;col<A.get(row).size();col++){
        //         // System.out.println("Print board surface, baris = "+row+" | kolom = "+col);
        //         System.out.print(surfaceBoard.get(row).get(col).toString());
        //     }
        //     System.out.println();
        // }
        //print total number side
        // System.out.println("Print total number per board surface");
        // for(int row=0;row<A.size();row++){
        //     for(int col=0;col<A.get(row).size();col++){
        //         System.out.print(surfaceBoard.get(row).get(col).getTotalSumNumberSideSurface()+" ");
        //     }
        //     System.out.println();
        // }
        //count total 
        int sumTotalNumberSideSurface = 0;
        // System.out.println("Count total number side surface");
        for(int row=0;row<A.size();row++){
            for(int col=0;col<A.get(row).size();col++){
                sumTotalNumberSideSurface += surfaceBoard.get(row).get(col).getTotalSumNumberSideSurface();
            }
        }
        // System.out.println("Result count total number = "+sumTotalNumberSideSurface);
        return sumTotalNumberSideSurface;
    }

    //===============================================================================================

    //loop jika board array 2x2, 2x3,3x3,3x2, etc
    private static List<List<SurfaceBoard>> arrayBoardTwoDimension(List<List<Integer>> A){
        List<List<SurfaceBoard>> surfaceBoard = new ArrayList<>();

        //hitung papan 
        for(int row=0;row<A.size();row++){
            List<SurfaceBoard> listNumberOfSurface = new ArrayList<>();
            for(int column=0;column<A.get(row).size();column++){
                //paling atas & paling kiri?
                if(row==0&&column==0){
                    SurfaceBoard atasPojokKiri = AtasPojokKiri(A, row, column);
                    atasPojokKiri.countTotalNumberSide();
                    listNumberOfSurface.add(atasPojokKiri);
                }
                //paling atas && tengah?
                if(row==0&&(column>0&&column<A.get(row).size()-1)){
                    SurfaceBoard atasTengah = AtasTengah(A, row, column);
                    atasTengah.countTotalNumberSide();
                    listNumberOfSurface.add(atasTengah);
                }
                //paling atas && paling kanan?
                if(row==0&&(column==A.get(row).size()-1)){
                    SurfaceBoard atasPojokKanan = AtasKanan(A, row, column);
                    atasPojokKanan.countTotalNumberSide();
                    listNumberOfSurface.add(atasPojokKanan);
                }
                //=======================================================================================
                //middle row && paling kiri?
                if((row>0&&row<A.size()-1) && (column==0)){
                    SurfaceBoard MidRowLeftCol = MidPalingLeft(A, row, column);
                    MidRowLeftCol.countTotalNumberSide();
                    listNumberOfSurface.add(MidRowLeftCol);
                }
                //middle row && tengah col
                if((row>0 && row<A.size()-1) && (column>0 && column<A.get(row).size()-1)){
                    SurfaceBoard midRowMidCol = MidUntukTengah(A, row, column);
                    midRowMidCol.countTotalNumberSide();
                    listNumberOfSurface.add(midRowMidCol);
                }
                //middle row && paling kanan?
                if((row>0 && row<A.size()-1) && (column==A.get(row).size()-1)){
                    SurfaceBoard midRowRightCol = MidPalingRight(A, row, column);
                    midRowRightCol.countTotalNumberSide();
                    listNumberOfSurface.add(midRowRightCol);
                }
                //=======================================================================================
                //paling bawah && paling kiri
                if(row==A.size()-1 && column==0){
                    SurfaceBoard bottomLeft = BottomLeft(A, row, column);
                    bottomLeft.countTotalNumberSide();
                    listNumberOfSurface.add(bottomLeft);
                }
                //paling bawah && middle
                if(row==A.size()-1 && (column>0 && column<A.get(row).size()-1)){
                    SurfaceBoard bottomMiddle = BottomMiddle(A, row, column);
                    bottomMiddle.countTotalNumberSide();
                    listNumberOfSurface.add(bottomMiddle);
                }
                //paling bawah && paling kanan
                if(row==A.size()-1 && column==A.get(row).size()-1){
                    SurfaceBoard bottomRight = BottomRight(A, row, column);
                    bottomRight.countTotalNumberSide();
                    listNumberOfSurface.add(bottomRight);
                }
            }
            surfaceBoard.add(listNumberOfSurface);
        }
        return surfaceBoard;
    }

    //===============================================================================================
    //untuk board yang besarannya 1x1
    private static SurfaceBoard soloBoard(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        cube.setFront(A.get(row).get(col));
        //back
        cube.setBack(A.get(row).get(col));
        //left
        cube.setLeft(A.get(row).get(col));
        //right
        cube.setRight(A.get(row).get(col));
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    //===============================================================================================
    //untuk board yang linear ke atas-bawah/vertikal, misalnya 2x1, 3x1, 4x1, 5x1
    private static SurfaceBoard vertikalUp(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        cube.setFront(A.get(row).get(col));
        //back
        if(A.get(row).get(col)>A.get(row+1).get(col)){
            cube.setBack(A.get(row).get(col)-A.get(row+1).get(col));
        } else {
            cube.setBack(0);
        }
        //left
        cube.setLeft(A.get(row).get(col));
        //right
        cube.setRight(A.get(row).get(col));
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard vertikalMiddle(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        if(A.get(row).get(col)>A.get(row-1).get(col)){
            cube.setFront(A.get(row).get(col)-A.get(row-1).get(col));
        } else {
            cube.setFront(0);
        }
        //back
        if(A.get(row).get(col)>A.get(row+1).get(col)){
            cube.setBack(A.get(row).get(col)-A.get(row+1).get(col));
        } else {
            cube.setBack(0);
        }
        //left
        cube.setLeft(A.get(row).get(col));
        //right
        cube.setRight(A.get(row).get(col));
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard vertikalBottom(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        if(A.get(row).get(col)>A.get(row-1).get(col)){
            cube.setFront(A.get(row).get(col)-A.get(row-1).get(col));
        } else {
            cube.setFront(0);
        }
        //back
        cube.setBack(A.get(row).get(col));
        //left
        cube.setLeft(A.get(row).get(col));
        //right
        cube.setRight(A.get(row).get(col));
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    //===============================================================================================
    //untuk board yang linear ke samping/horizontal, misalnya 1x2, 1x3, 1x4, 1x5, 1x6, etc
    private static SurfaceBoard horizontalLeft(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        cube.setFront(A.get(row).get(col));
        //back
        cube.setBack(A.get(row).get(col));
        //left
        cube.setLeft(A.get(row).get(col));
        //right
        if(A.get(row).get(col)>A.get(row).get(col+1)){
            cube.setRight(A.get(row).get(col)-A.get(row).get(col+1));
        } else {
            cube.setRight(0);
        }
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard horizontalMiddle(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        cube.setFront(A.get(row).get(col));
        //back
        cube.setBack(A.get(row).get(col));
        //left
        if(A.get(row).get(col)>A.get(row).get(col-1)){
            cube.setLeft(A.get(row).get(col)-A.get(row).get(col-1));
        } else {
            cube.setLeft(0);
        }
        //right
        if(A.get(row).get(col)>A.get(row).get(col+1)){
            cube.setRight(A.get(row).get(col)-A.get(row).get(col+1));
        } else {
            cube.setRight(0);
        }
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard horizontalRight(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        cube.setFront(A.get(row).get(col));
        //back
        cube.setBack(A.get(row).get(col));
        //left
        if(A.get(row).get(col)>A.get(row).get(col-1)){
            cube.setLeft(A.get(row).get(col)-A.get(row).get(col-1));
        } else {
            cube.setLeft(0);
        }
        //right
        cube.setRight(A.get(row).get(col));
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    //===============================================================================================
    //untuk board yang benar benar array 2D , misalnya 2x2, 3x3,4x4
    private static SurfaceBoard BottomRight(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        if(A.get(row).get(col)>A.get(row-1).get(col)){
            cube.setFront(A.get(row).get(col)-A.get(row-1).get(col));
        } else {
            cube.setFront(0);
        }
        //back
        cube.setBack(A.get(row).get(col));
        //left
        if(A.get(row).get(col)>A.get(row).get(col-1)){
            cube.setLeft(A.get(row).get(col)-A.get(row).get(col-1));
        } else {
            cube.setLeft(0);
        }
        //right
        cube.setRight(A.get(row).get(col));
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard BottomMiddle(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        if(A.get(row).get(col)>A.get(row-1).get(col)){
            cube.setFront(A.get(row).get(col)-A.get(row-1).get(col));
        } else {
            cube.setFront(0);
        }
        //back
        cube.setBack(A.get(row).get(col));
        //left
        if(A.get(row).get(col)>A.get(row).get(col-1)){
            cube.setLeft(A.get(row).get(col)-A.get(row).get(col-1));
        } else {
            cube.setLeft(0);
        }
        //right
        if(A.get(row).get(col)>A.get(row).get(col+1)){
            cube.setRight(A.get(row).get(col)-A.get(row).get(col+1));
        } else {
            cube.setRight(0);
        }
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard BottomLeft(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        if(A.get(row).get(col)>A.get(row-1).get(col)){
            cube.setFront(A.get(row).get(col)-A.get(row-1).get(col));
        } else {
            cube.setFront(0);
        }
        //back
        cube.setBack(A.get(row).get(col));
        //left
        cube.setLeft(A.get(row).get(col));
        //right
        if(A.get(row).get(col)>A.get(row).get(col+1)){
            cube.setRight(A.get(row).get(col)-A.get(row).get(col+1));
        }
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard MidPalingRight(List<List<Integer>> A,int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        if(A.get(row).get(col)>A.get(row-1).get(col)){
            cube.setFront(A.get(row).get(col)-A.get(row-1).get(col));
        } else {
            cube.setFront(0);
        }
        //back
        if(A.get(row).get(col)>A.get(row+1).get(col)){
            cube.setBack(A.get(row).get(col)-A.get(row+1).get(col));
        } else {
            cube.setBack(0);
        }
        //left
        if(A.get(row).get(col)>A.get(row).get(col-1)){
            cube.setLeft(A.get(row).get(col)-A.get(row).get(col-1));
        } else {
            cube.setLeft(0);
        }
        //right
        cube.setRight(A.get(row).get(col));
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard MidUntukTengah(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        if(A.get(row).get(col)>A.get(row-1).get(col)){
            cube.setFront(A.get(row).get(col)-A.get(row-1).get(col));
        } else {
            cube.setFront(0);
        }
        //back
        if(A.get(row).get(col)>A.get(row+1).get(col)){
            cube.setBack(A.get(row).get(col)-A.get(row+1).get(col));
        } else {
            cube.setBack(0);
        }
        //left
        if(A.get(row).get(col)>A.get(row).get(col-1)){
            cube.setLeft(A.get(row).get(col)-A.get(row).get(col-1));
        } else {
            cube.setLeft(0);
        }
        //right
        if(A.get(row).get(col)>A.get(row).get(col+1)){
            cube.setRight(A.get(row).get(col)-A.get(row).get(col+1));
        }
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard MidPalingLeft(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        if(A.get(row).get(col)>A.get(row-1).get(col)){
            cube.setFront(A.get(row).get(col)-A.get(row-1).get(col));
        } else {
            cube.setFront(0);
        }
        //back
        if(A.get(row).get(col)>A.get(row+1).get(col)){
            cube.setBack(A.get(row).get(col)-A.get(row+1).get(col));
        }else{
            cube.setBack(0);
        }
        //left
        cube.setLeft(A.get(row).get(col));
        //right
        if(A.get(row).get(col)>A.get(row).get(col+1)){
            cube.setRight(A.get(row).get(col)-A.get(row).get(col+1));
        } else {
            cube.setRight(0);
        }
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard AtasKanan(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        cube.setFront(A.get(row).get(col));
        //back
        if(A.get(row).get(col)>A.get(row+1).get(col)){
            cube.setBack(A.get(row).get(col)-A.get(row+1).get(col));
        } else {
            cube.setBack(0);
        }
        //left
        if(A.get(row).get(col)>A.get(row).get(col-1)){
            cube.setLeft(A.get(row).get(col)-A.get(row).get(col-1));
        } else {
            cube.setLeft(0);
        }
        //right
        cube.setRight(A.get(row).get(col));
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard AtasTengah(List<List<Integer>> A,int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        cube.setFront(A.get(row).get(col));
        //back
        if(A.get(row).get(col)>A.get(row+1).get(col)){
            cube.setBack(A.get(row).get(col)-A.get(row+1).get(col));
        } else {
            cube.setBack(0);
        }
        //left
        if(A.get(row).get(col)>A.get(row).get(col-1)){
            cube.setLeft(A.get(row).get(col)-A.get(row).get(col-1));
        } else {
            cube.setLeft(0);
        }
        //right
        if(A.get(row).get(col)>A.get(row).get(col+1)){
            cube.setRight(A.get(row).get(col)-A.get(row).get(col+1));
        } else {
            cube.setRight(0);
        }
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static SurfaceBoard AtasPojokKiri(List<List<Integer>> A, int row, int col){
        SurfaceBoard cube = new SurfaceBoard();
        //front
        cube.setFront(A.get(row).get(col));
        //back
        if(A.get(row).get(col)>A.get(row+1).get(col)){
            cube.setBack(A.get(row).get(col)-A.get(row+1).get(col));
        } else {
            cube.setBack(0);
        }
        //left
        cube.setLeft(A.get(row).get(col));
        //right
        if(A.get(row).get(col)>A.get(row).get(col+1)){
            cube.setRight(A.get(row).get(col)-A.get(row).get(col+1));
        } else {
            cube.setRight(0);
        }
        //up
        cube.setUp(1);
        //bottom
        cube.setBottom(1);
        return cube;
    }

    private static void printBoard(List<List<Integer>> boardGame){
        for(int i=0;i<boardGame.size();i++){
            for(int j=0;j<boardGame.get(i).size();j++){
                System.out.printf("%d ", boardGame.get(i).get(j));
            }
            System.out.println();
        }
    }
}

class SurfaceBoard{
    int front;
    int back;
    int left;
    int right;
    int up;
    int bottom;
    int totalNumberSide;

    public SurfaceBoard(){}

    public SurfaceBoard(int front, int back, int left, int right, int up, int bottom, int totalNumberSide){
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        this.up = up;
        this.bottom = bottom;
        this.totalNumberSide = totalNumberSide;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getTotalNumberSide() {
        return totalNumberSide;
    }

    public void setTotalNumberSide(int totalNumberSide) {
        this.totalNumberSide = totalNumberSide;
    }

    public String toString(){
        return "{"+this.front+","+this.back+","+this.left+","+this.right+","+this.up+","+this.bottom+"}";
    }

    public void countTotalNumberSide(){
        this.totalNumberSide = this.front+this.back+this.left+this.right+this.up+this.bottom;
    }

    public int getTotalSumNumberSideSurface(){
        return this.totalNumberSide;
    }
}