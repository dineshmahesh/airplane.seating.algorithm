package com.sample.airplane.seating.algorithm.factory;

import com.sample.airplane.seating.algorithm.model.Layout;
import com.sample.airplane.seating.algorithm.util.LayoutPrintUtil;

public interface SeatingAlgorithm {

    void allocateSeat(Integer[][] config, int totalPassengers);

    default void printLayout(Layout layout) {
        LayoutPrintUtil layoutPrintUtil = new LayoutPrintUtil(layout);
        layoutPrintUtil.printLayout();
    }
}
