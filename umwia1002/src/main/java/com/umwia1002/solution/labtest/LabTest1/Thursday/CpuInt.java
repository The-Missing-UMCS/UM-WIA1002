package com.umwia1002.solution.labtest.LabTest1.Thursday;

public class CpuInt implements NumberInterface<CpuInt> {
    int value;

    CpuInt() {}

    CpuInt(int value) {
        this.value = value;
    }

    @Override
    public CpuInt fromInteger(int value) {
        return new CpuInt(value);
    }

    @Override
    public Integer toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s[%d]", getDevice(), this.value);
    }

    public String getDevice() {
        return "CPU";
    }

    public CpuInt add(CpuInt o) {
        System.out.printf("CPU Debug: %d + %d = %d\n", this.value,
                o.value, this.value + o.value);
        return new CpuInt(this.value + o.value);
    }

    public CpuInt mul(CpuInt o) {
        System.out.printf("CPU Debug: %d * %d = %d\n", this.value,
                o.value, this.value * o.value);
        return new CpuInt(this.value * o.value);
    }

}
