package redmart.skiing;

/**
 * Created by sathya on 8/8/15.
 */
public class PointData {
    private int rowIndex;
    private int colIndex;
    private int height;

    PointData(int rowIndex, int colIndex, int height) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.height = height;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public int getHeight() {
        return height;
    }
}