package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data;

public class Coordinate implements Comparable<Coordinate> {
    double latitude;
    double longitude;

    Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public boolean isValidCoordinate() {
        return this.latitude >= -90 && this.latitude <= 90 
                && this.longitude >= -180 && this.longitude <= 180;
    }

    @Override
    public String toString() {
        return String.format("%6.1f, %6.1f", this.latitude, this.longitude);
    }

    @Override
    public int compareTo(Coordinate o) {
        return this.latitude != o.latitude ? Double.compare(this.latitude, o.latitude) : Double.compare(this.longitude, o.longitude);
    }
}
