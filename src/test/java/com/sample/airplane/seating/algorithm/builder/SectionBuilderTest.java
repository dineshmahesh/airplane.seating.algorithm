package com.sample.airplane.seating.algorithm.builder;

import com.sample.airplane.seating.algorithm.model.Section;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class SectionBuilderTest {

    @Test
    void testSectionBuilder() {
        List<Section> mockedSection = mockSection();
        Integer[][] config = new Integer[][]{{3,1}};
        SectionBuilder sectionBuilder = new SectionBuilder(config);
        List<Section> sectionList = sectionBuilder.build();

        Assert.assertEquals(sectionList.get(0).getSectionId(), mockedSection.get(0).getSectionId());
        Assert.assertEquals(sectionList.get(0).getRowCount(), mockedSection.get(0).getRowCount());
        Assert.assertEquals(sectionList.get(0).getColCount(), mockedSection.get(0).getColCount());
    }


    private List<Section> mockSection() {
        return Collections.singletonList(new Section(1, 1, 3));
    }
}
