package com.umwia1002.solution.lab.version1.lab2;

import com.umwia1002.solution.lab.version1.lab2.L2Q3.l2q3b.CompareMax;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class L2Q2Test {

    @Benchmark
    public void testMaximal() {
        CompareMax.maxUsingComparison1("a", "b", "c");
    }

    @Benchmark
    public void testMax() {
        CompareMax.maxUsingComparison2("a", "b", "c");
    }

    @Benchmark
    public void testMaximum() {
        CompareMax.maxUsingStream("a", "b", "c");
    }
}

