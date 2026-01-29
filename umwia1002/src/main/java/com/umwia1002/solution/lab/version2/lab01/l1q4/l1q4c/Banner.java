package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4c;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banner {

    private final ASCIIArtGenerator artGenerator;

    private ASCIIArtFont fontType;
    private int fontSize;
    private String symbol;

    public Banner() {
        this(new ASCIIArtGenerator());
    }

    public Banner(ASCIIArtGenerator artGenerator) {
        this.artGenerator = artGenerator;
        this.fontType = ASCIIArtFont.ART_FONT_MONO;
        this.fontSize = ASCIIArtGenerator.ART_SIZE_MEDIUM;
        this.symbol = ASCIIArtGenerator.DEFAULT_SYMBOL;
    }

    public void printMessage(String message) {
        System.out.println();
        artGenerator.printTextArt(message, fontSize, fontType, symbol);
        System.out.println();
    }
}
