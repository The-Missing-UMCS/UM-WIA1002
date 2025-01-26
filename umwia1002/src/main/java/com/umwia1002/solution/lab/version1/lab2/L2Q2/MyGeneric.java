package com.umwia1002.solution.lab.version1.lab2.L2Q2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyGeneric<E> {
    private E object;
}
