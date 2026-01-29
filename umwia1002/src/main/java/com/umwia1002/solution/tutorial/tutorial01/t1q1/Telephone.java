package com.umwia1002.solution.tutorial.tutorial01.t1q1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telephone {

    private static int numberOfTelephoneObject = 0;
    private String areaCode;
    private long number;

    Telephone(String areaCode, long number) {
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
    }

    public String fullNumber() {
        return String.format("%s-%s", this.areaCode, this.number);
    }

    public void hello() {
        System.out.println("Hello, I am a telephone object");
    }
}
