package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Feature;


import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data.Coordinate;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data.Data;

import java.util.List;

public class Login extends Feature<Coordinate> {
    public Login(List<Data<Coordinate>> data) {
        super(data);
    }

    @Override
    public Login dataCleaning() {
        List<Data<Coordinate>> dataList = dataList();
        dataList.removeIf(data -> data == null || data.getData() == null || !data.getData().isValidCoordinate());
        return this;
    }
}

