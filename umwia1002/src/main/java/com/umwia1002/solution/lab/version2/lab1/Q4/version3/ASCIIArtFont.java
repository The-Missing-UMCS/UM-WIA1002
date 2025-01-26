package com.umwia1002.solution.lab.version2.lab1.Q4.version3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ASCIIArtFont {
    ART_FONT_DIALOG("Dialog"),
    ART_FONT_DIALOG_INPUT("Dialog Input"),
    ART_FONT_MONO("Monospaced"),
    ART_FONT_SERIF("Serif");

    private final String value;
}
