package com.umwia1002.solution.labtest.LabTest1.Thursday;

import java.util.*;

public class TestDS2023Generics {
    public static int progress = 4;

    public static void main(String[] args) throws Exception {
        testCPU();
        testGPU();
    }
    
    public static void testCPU() throws Exception {
        System.out.println("=== CPU Class constructors, conversions and string representation ===");
        CpuInt a = new CpuInt(3);
        CpuInt b = new CpuInt().fromInteger(5);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.printf("a.toInteger() -> class: %s, value: %d\n",
                a.toInteger().getClass(), a.toInteger());
        System.out.println("---");

        if (progress < 2) {
            return;
        }

        System.out.println("=== CPU Vector constructors and printing ===");
        ArrayList<CpuInt> aa = VecUtil.arr2vec(CpuInt.class, new int[] {1,2,3});
        ArrayList<CpuInt> bb = VecUtil.ones(CpuInt.class, 3);
        VecUtil.printVec(aa);
        VecUtil.printVec(bb);
        System.out.println("---");
        if (progress < 3) {
            return;
        }

        System.out.println("=== CPU Vector multiplications ===");
        bb = VecUtil.mul(bb, new CpuInt(3)); 
        ArrayList<CpuInt> cc = VecUtil.mul(aa, bb);
        VecUtil.printVec(bb);
        VecUtil.printVec(cc);
        System.out.println("---");
        if (progress < 4) {
            return;
        }

        System.out.println("=== CPU Vector Dot Product ===");
        System.out.println(VecUtil.dot(aa, bb));
        System.out.println("---");
    }

    public static void testGPU() throws Exception {
        System.out.println("=== GPU Class constructors, conversions and string representation ===");
        GpuInt a = new GpuInt(3);
        GpuInt b = new GpuInt().fromInteger(5);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.printf("a.toInteger() -> class: %s, value: %d\n",
                a.toInteger().getClass(), a.toInteger());
        System.out.println("---");
        if (progress < 2) {
            return;
        }

        System.out.println("=== GPU Vector constructors and printing ===");
        ArrayList<GpuInt> aa = VecUtil.arr2vec(GpuInt.class, new int[] { 1, 2, 3 });
        ArrayList<GpuInt> bb = VecUtil.ones(GpuInt.class, 3);
        VecUtil.printVec(aa);
        VecUtil.printVec(bb);
        System.out.println("---");
        if (progress < 3) {
            return;
        }

        System.out.println("=== GPU Vector multiplications ===");
        bb = VecUtil.mul(bb, new GpuInt(3)); // Vec * Scalar
        ArrayList<GpuInt> cc = VecUtil.mul(aa, bb);
        VecUtil.printVec(bb);
        VecUtil.printVec(cc);
        System.out.println("---");
        if (progress < 4) {
            return;
        }

        System.out.println("=== GPU Vector Dot Product ===");
        System.out.println(VecUtil.dot(aa, bb));
        System.out.println("---");
    }

}
