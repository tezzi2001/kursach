package com.example.kushkursach.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

@Data
@NoArgsConstructor
public class Matrix {
    private double cell1;
    private double cell2;
    private double cell3;
    private double cell4;
    private double cell5;
    private double cell6;
    private double cell7;
    private double cell8;
    private double cell9;
    private double cell10;
    private double cell11;
    private double cell12;
    private double cell13;
    private double cell14;
    private double cell15;
    private double cell16;
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

    private double getCell(RealMatrix matrix, int row, int col) {
        try {
            return matrix.getEntry(row, col);
        } catch (RuntimeException e) {
            return 0;
        }
    }

    public RealMatrix toRealMatrix() {
        double[][] matrix = {
                {this.cell1, this.cell2, this.cell3, this.cell4},
                {this.cell5, this.cell6, this.cell7, this.cell8},
                {this.cell9, this.cell10, this.cell11, this.cell12},
                {this.cell13, this.cell14, this.cell15, this.cell16}
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
