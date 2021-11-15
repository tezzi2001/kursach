package com.example.kushkursach.services;

import com.example.kushkursach.domain.Matrix;
import com.example.kushkursach.domain.Operation;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.springframework.stereotype.Service;

@Service
public class MatrixService {
    public Matrix process(Operation operation) {
        switch (operation.getType()) {
            case DETERMINANT: return determinant(operation.getMatrix1());
            case REVERSE: return reverse(operation.getMatrix1());
            case MULTIPLY: return multiply(operation.getMatrix1(), operation.getMatrix2());
            case ADD: return add(operation.getMatrix1(), operation.getMatrix2());
            case SUBTRACT: return subtract(operation.getMatrix1(), operation.getMatrix2());
            default: return null;
        }
    }

    private Matrix determinant(Matrix matrix1) {
        LUDecomposition luDecomposition = new LUDecomposition(matrix1.toRealMatrix());
        double determinant = luDecomposition.getDeterminant();
        matrix1.setDeterminant(determinant);
        matrix1.setComputed(true);
        return matrix1;
    }

    private Matrix reverse(Matrix matrix1) {
        RealMatrix result = MatrixUtils.inverse(matrix1.toRealMatrix());
        return new Matrix(result);
    }

    private Matrix multiply(Matrix matrix1, Matrix matrix2) {
        RealMatrix result = matrix1.toRealMatrix().multiply(matrix2.toRealMatrix());
        return new Matrix(result);
    }

    private Matrix add(Matrix matrix1, Matrix matrix2) {
        RealMatrix result = matrix1.toRealMatrix().add(matrix2.toRealMatrix());
        return new Matrix(result);
    }

    private Matrix subtract(Matrix matrix1, Matrix matrix2) {
        RealMatrix result = matrix1.toRealMatrix().subtract(matrix2.toRealMatrix());
        return new Matrix(result);
    }
}
