package com.sample.airplane.seating.algorithm.builder;

import com.sample.airplane.seating.algorithm.model.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SectionBuilder {

    private Integer[][] layoutConfig;

    public SectionBuilder(Integer[][] layoutConfig) {
        this.layoutConfig = layoutConfig;
    }

    public List<Section> build() {
        return IntStream.range(0, layoutConfig.length)
                        .mapToObj(index -> new Section((index + 1),
                                                        layoutConfig[index][1],
                                                        layoutConfig[index][0]))
                        .collect(Collectors.toList());
    }
}
