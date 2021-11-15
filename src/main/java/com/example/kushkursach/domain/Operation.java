package com.example.kushkursach.domain;

import lombok.Data;

@Data
public class Operation {
    private Matrix matrix1 = new Matrix();
    private Matrix matrix2 = new Matrix();
    private Type type;
    private Matrix result = new Matrix();
}
