package com.example.kushkursach.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cell {
    private double data = 0;
    private boolean hasData = false;
}
