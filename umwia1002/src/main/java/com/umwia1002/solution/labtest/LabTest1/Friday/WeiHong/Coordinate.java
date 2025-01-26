package com.umwia1002.solution.labtest.LabTest1.Friday.WeiHong;

public class Coordinate implements Comparable<Coordinate> {
    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public int compareTo(Coordinate o) {
        throw new UnsupportedOperationException();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return String.format("%10.2f %10.2f", latitude, longitude);
    }
}
