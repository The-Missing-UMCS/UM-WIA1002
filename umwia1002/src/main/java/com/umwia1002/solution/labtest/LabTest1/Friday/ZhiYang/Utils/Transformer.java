package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Utils;

@FunctionalInterface
public interface Transformer<A, B> {
    B transform(A a);
}
