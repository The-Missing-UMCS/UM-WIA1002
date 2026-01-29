package com.umwia1002.solution.lab.version2.lab01.l1q1;


public record Time(
    int hour,
    int minute
) {

    boolean hasValidHour() {
        return hour >= 0 && hour <= 23;
    }

    boolean hasValidMinute() {
        return minute >= 0 && minute <= 59;
    }

    @Override
    public String toString() {
        if (hasValidHour() && hasValidMinute()) {
            return String.format("Hour: %d Minute: %d  %d:%d %s",
                hour, minute, hour % 12 == 0 ? 12 : hour % 12, minute, hour / 12 > 0 ? "PM" : "AM");
        } else {
            return String.format("Hour: %d Minute: %d  Invalid time input", hour, minute);
        }
    }
}
