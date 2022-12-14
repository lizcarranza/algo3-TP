package org.example.juego;

import org.example.juego.Boxes.Box;
import java.util.Random;

public class Board {
    public final Box[][] matrix;
    private final int rows = 10;
    private final int columns = 10;
    public int[][] minesList;


    public Board() {
        this.matrix = new Box[rows][columns];

        createTable();
    }

    private int randomNumberRows() {

        Random random = new Random();

        return random.nextInt(rows);
    }

    private int randomNumberCols() {
        Random random = new Random();
        return random.nextInt(columns);
    }

    private void createTable() {

        int mines = 10;
        minesList = new int[mines +1][2];

        int rRow = randomNumberRows();
        int rCol = randomNumberCols();

        int i = 0;
        while (i < mines) {
            if (matrix[rRow][rCol] == null || !matrix[rRow][rCol].bomb) {
                matrix[rRow][rCol] = BoxFactory.createBomb();
                i++;
                createNumberBoxes(rRow, rCol);
                minesList[i][0]=rRow;
                minesList[i][1]=rCol;
            }
            rRow = randomNumberRows();
            rCol = randomNumberCols();

        }
        createEmptyBoxes();
    }

    private void createNumberBoxes(int rowBomb, int colBomb){
        int colStart = colBomb - 1;
        int colEnd = colBomb + 1;
        int rowStart = rowBomb - 1;
        int rowEnd = rowBomb + 1;

        if (colStart < 0) {
            colStart = 0;
        }
        if (colEnd > rows-1) {
            colEnd = rows-1;
        }
        if (rowStart < 0) {
            rowStart = 0;
        }
        if (rowEnd > columns-1) {
            rowEnd = columns-1;
        }


        for  (int i = rowStart; i <= rowEnd; i++){
            for (int j = colStart; j <= colEnd; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = BoxFactory.createBox(1);
                } else if (!matrix[i][j].bomb) {
                    matrix[i][j] = BoxFactory.createBox(matrix[i][j].number + 1);
                }
            }
        }

    }

    private void createEmptyBoxes(){
        for (int i = 0; i < rows; i++) {
            for  (int j = 0; j < columns; j++){
                if (matrix[i][j] == null) {
                    matrix[i][j] = BoxFactory.createBox(0);
                }
            }
        }
    }

    public void clickBox(int row, int col) {
        matrix[row][col] = BoxFactory.createClickedBox(matrix[row][col].number);
    }

    public void unableAllBoxes() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j].visible = true;
            }
        }
    }

    public void enableBoxes(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j].visible = false;
            }
        }
    }

    public void setFlagBox( int row, int col) {
        if (!matrix[row][col].visible) {
            int i = matrix[row][col].number;
            matrix[row][col] = BoxFactory.createFlagBox(i);
        }
    }

    public void unsetFlag(int row, int col){
        if (matrix[row][col].flag){
            int i = matrix[row][col].getNumber();
            if (i == 10)
                matrix[row][col] = BoxFactory.createBomb();
            else
                matrix[row][col] = BoxFactory.createBox(i);
        }
    }

}
