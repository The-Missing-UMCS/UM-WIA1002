package com.umwia1002.solution.labtest.LabTest1.Friday.WeiHong;

import java.util.Iterator;
import java.util.List;

public class Login extends Feature<Coordinate> {
    public Login(List<Data<Coordinate>> data) {
        super(data);
    }

    @Override
    public Feature<Coordinate> dataCleaning() {
        Iterator<Data<Coordinate>> iterator = getData().iterator();
        while (iterator.hasNext()) {
            Data<Coordinate> loginData = iterator.next();
            double latitude = loginData.getData().getLatitude();
            double longitude = loginData.getData().getLongitude();
            if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) iterator.remove();
        }
        return this;
    }
}
