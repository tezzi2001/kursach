package com.example.kushkursach.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

@Data
@NoArgsConstructor
public class Matrix {
    private Cell cell1;
    private Cell cell2;
    private Cell cell3;
    private Cell cell4;
    private Cell cell5;
    private Cell cell6;
    private Cell cell7;
    private Cell cell8;
    private Cell cell9;
    private Cell cell10;
    private Cell cell11;
    private Cell cell12;
    private Cell cell13;
    private Cell cell14;
    private Cell cell15;
    private Cell cell16;
    private boolean computed = false;
    private Double determinant;
    private int cols;
    private int rows;

    public Matrix(RealMatrix realMatrix) {
        this(realMatrix, null);
    }

    public Matrix(RealMatrix realMatrix, Double determinant) {
        this.computed = true;
        this.determinant = determinant;
        this.cell1 = getCell(realMatrix, 0, 0);
        this.cell2 = getCell(realMatrix, 0, 1);
        this.cell3 = getCell(realMatrix, 0, 2);
        this.cell4 = getCell(realMatrix, 0, 3);
        this.cell5 = getCell(realMatrix, 1, 0);
        this.cell6 = getCell(realMatrix, 1, 1);
        this.cell7 = getCell(realMatrix, 1, 2);
        this.cell8 = getCell(realMatrix, 1, 3);
        this.cell9 = getCell(realMatrix, 2, 0);
        this.cell10 = getCell(realMatrix, 2, 1);
        this.cell11 = getCell(realMatrix, 2, 2);
        this.cell12 = getCell(realMatrix, 2, 3);
        this.cell13 = getCell(realMatrix, 3, 0);
        this.cell14 = getCell(realMatrix, 3, 1);
        this.cell15 = getCell(realMatrix, 3, 2);
        this.cell16 = getCell(realMatrix, 3, 3);
        this.rows = realMatrix.getRowDimension();
        this.cols = realMatrix.getColumnDimension();
    }

    private Cell getCell(RealMatrix matrix, int row, int col) {
        try {
            return new Cell(matrix.getEntry(row, col), true);
        } catch (RuntimeException e) {
            return new Cell();
        }
    }

    public RealMatrix toRealMatrix() {
        double[][] matrix = {
                {this.cell1.getData(), this.cell2.getData(), this.cell3.getData(), this.cell4.getData()},
                {this.cell5.getData(), this.cell6.getData(), this.cell7.getData(), this.cell8.getData()},
                {this.cell9.getData(), this.cell10.getData(), this.cell11.getData(), this.cell12.getData()},
                {this.cell13.getData(), this.cell14.getData(), this.cell15.getData(), this.cell16.getData()}
        };
        double[][] matrixAdjusted = new double[this.rows][this.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                matrixAdjusted[i][j] = matrix[i][j];
            }
        }
        return MatrixUtils.createRealMatrix(matrixAdjusted);
    }
}
