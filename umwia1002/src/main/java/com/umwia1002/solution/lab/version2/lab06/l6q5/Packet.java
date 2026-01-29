package com.umwia1002.solution.lab.version2.lab06.l6q5;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record Packet(
    MediaType mediaType,
    int id
) implements Comparable<Packet> {

    @Override
    public int compareTo(Packet o) {
        return Integer.compare(mediaType.priority, o.mediaType.priority);
    }

    @Override
    public String toString() {
        return String.format("%s %d (Priority=%d)", mediaType.type, id, mediaType.priority);
    }

    @Getter
    @RequiredArgsConstructor
    public enum MediaType {
        VOICE("Voice", 2),
        VIDEO("Video", 1),
        DATA("Data", 0);

        private final String type;
        private final int priority;
    }
}
