package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4c;

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
