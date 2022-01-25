package com.sample.airplane.seating.algorithm.model;

public class Section {

    private int sectionId;
    private int rowCount;
    private int colCount;

    public Section(int sectionId, int rowCount, int colCount) {
        this.sectionId = sectionId;
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public int getSectionId() {
        return sectionId;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }
}
