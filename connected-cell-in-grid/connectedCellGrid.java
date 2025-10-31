import java.util.*;

public class connectedCellGrid {
    static Scanner sc = new Scanner(System.in);
    static List<List<cellFilled>> matrixQuest;
    public static void main(String[] args) {
        int rows = sc.nextInt();
        int column = sc.nextInt();
        List<List<Integer>> matrixProblem = initMatrixProblem(rows);
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                int inputConnected = sc.nextInt();
                List<Integer> colMatrix = matrixProblem.get(i);
                colMatrix.add(inputConnected);
                matrixProblem.set(i, colMatrix);
            }
        }
        //print matrix
        printMatrix(matrixProblem);
        int totalRegion = connectedCell(matrixProblem);
        System.out.println("Total biggest region = "+totalRegion);
    }

    private static <T> List<List<T>> initMatrixProblem(int rows){
        try{
            List<List<T>> matrixInit = new ArrayList<>();
            for(int i=0;i<rows;i++){
                matrixInit.add(new ArrayList<>());
            }
            return matrixInit;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static <T> void printMatrix(List<List<T>> matrix){
        try{
            int rows = matrix.size();
            int col = matrix.get(0).size();
            for(int i=0;i<rows;i++){
                for(int j=0;j<col;j++){
                    System.out.print(matrix.get(i).get(j)+ " ");
                }
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * TODO
     * @param matrix
     * @return
     */
    public static int connectedCell(List<List<Integer>> matrix){
        matrixQuest = initMatrixProblem(matrix.size());
        initCellFilled(matrixQuest, matrix);
        countAdjacentCell(matrixQuest);
        printTotalTetangga(matrixQuest);
        return countBiggestRegion(matrixQuest);
    }

    private static void printTotalTetangga(List<List<cellFilled>> matrixQuest){
        int row = matrixQuest.size();
        int col = matrixQuest.get(0).size();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrixQuest.get(i).get(j).getTotalConnectedCell()+" ");
            }
            System.out.println();
        }
    }

    private static void initCellFilled(List<List<cellFilled>> matrixQuest,List<List<Integer>> matrix){
        int row = matrix.size();
        int col = matrix.get(0).size();

        System.out.println("Total connected neighboor");
        for(int i=0; i<row ; i++){
            List<cellFilled> filledList = new ArrayList<>();
            for(int j=0 ; j<col ; j++){
                cellFilled fill = new cellFilled(matrix.get(i).get(j));
                filledList.add(fill);
            }
            matrixQuest.set(i, filledList);
        }
    }

    private static void countAdjacentCell(List<List<cellFilled>> matrixQuest){
        int row = matrixQuest.size();
        int col = matrixQuest.get(0).size();
        for(int i=0;i<row;i++){
            List<cellFilled> currentListCell = matrixQuest.get(i);
            for(int j=0;j<col;j++){
                int total = 0;

                if(currentListCell.get(j).getSymbolFilled() == 1){
                    //up-left
                    if(i==0 && j==0) total = up_left(matrixQuest, i, j);

                    //up-middle
                    if(i==0 && (j!=0 && j!=col-1)) total = up_middle(matrixQuest, i, j);

                    //up-right
                    if(i==0 && j==col-1) total = up_right(matrixQuest, i, j);

                    //middle-left
                    if((i!=0 && i!= row-1) && j==0) total = middle_left(matrixQuest, i, j);

                    //middle-middle
                    if((i!=0 && i!= row-1) && (j!=0 && j!=col-1)) total = middle_middle(matrixQuest, i, j);

                    //middle-right
                    if((i!=0 && i!= row-1) && j==col-1) total = middle_right(matrixQuest, i, j);

                    //down-left
                    if(i==row-1 && j==0) total = down_left(matrixQuest, i, j);

                    //down-middle
                    if(i==row-1 && (j!=0 && j!=col-1)) total = down_middle(matrixQuest, i, j);

                    //down-right
                    if(i==row-1 && j==col-1) total = down_right(matrixQuest, i, j);
                }

                //print total
                System.out.println("Matrix untuk ["+i+"]["+j+"] , total adjacent = "+total);

                cellFilled currentCell = currentListCell.get(j);
                currentCell.setTotalConnectedCell(total);

                currentListCell.set(j, currentCell);
            }
            matrixQuest.set(i, currentListCell);
        }
    }

    //TODO: UP
    private static int up_left(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col+1).getSymbolFilled() != 1) total++;
        return total;
    }

    //TODO: UP
    private static int up_middle(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col+1).getSymbolFilled() != 1) total++;
        return total;
    }
    
    //TODO: UP
    private static int up_right(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col-1).getSymbolFilled() != 1) total++;
        return total;
    }

    //TODO: DOWN
    private static int down_left(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col+1).getSymbolFilled() != 1) total++;
        return total;
    }

    //TODO: DOWN
    private static int down_middle(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col+1).getSymbolFilled() != 1) total++;
        return total;
    }

    //TODO: DOWN
    private static int down_right(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col-1).getSymbolFilled() != 1) total++;
        return total;
    }

    //TOOD: MIDDLE
    private static int middle_left(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row-1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col).getSymbolFilled() != 1) total++;
        return total;
    }

    //TODO: MIDDLE
    private static int middle_middle(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col+1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col-1).getSymbolFilled() != 1) total++;
        return total;
    }

    //TODO: MIDDLE
    private static int middle_right(List<List<cellFilled>> matrixQuest, int row, int col){
        int total = 0;
        if(matrixQuest.get(row-1).get(col).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row-1).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col-1).getSymbolFilled() != 1) total++;
        if(matrixQuest.get(row+1).get(col).getSymbolFilled() != 1) total++;
        return total;
    }

    private static int countBiggestRegion(List<List<cellFilled>> matrixQuest){
        int biggestRegion = 0;
        int row = matrixQuest.size();
        int col = matrixQuest.get(0).size();
        for(int i=0; i<row ; i++){
            for(int j=0 ; j<col ; j++){
                int totalConnect = matrixQuest.get(i).get(j).getTotalConnectedCell();
                if(totalConnect !=0 && totalConnect>biggestRegion){
                    biggestRegion = totalConnect;
                }
            }
        }
        return biggestRegion;
    }
}

class cellFilled{
    private int symbolFilled;
    private int totalConnectedCell;
    
    public cellFilled(int symbolFilled){
        this.symbolFilled = symbolFilled;
        this.totalConnectedCell = 0;
    }

    public int getSymbolFilled() {
        return symbolFilled;
    }

    public void setSymbolFilled(int symbolFilled) {
        this.symbolFilled = symbolFilled;
    }

    public int getTotalConnectedCell() {
        return totalConnectedCell;
    }

    public void setTotalConnectedCell(int totalConnectedCell) {
        this.totalConnectedCell = totalConnectedCell;
    }

    
}