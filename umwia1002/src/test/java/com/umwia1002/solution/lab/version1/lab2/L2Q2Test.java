package com.umwia1002.solution.lab.version1.lab2;

import com.umwia1002.solution.lab.version1.lab2.L2Q3.CompareMax;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class L2Q2Test {

    @Benchmark
    public void testMaximal() {
        CompareMax.maximal("a", "b", "c");
    }

    @Benchmark
    public void testMax() {
        CompareMax.max("a", "b", "c");
    }

    @Benchmark
    public void testMaximum() {
        CompareMax.maximum("a", "b", "c");
    }
}

