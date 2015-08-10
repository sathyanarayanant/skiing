package redmart.skiing;

import redmart.common.RedmartException;

import java.util.List;

/**
 * Created by sathya on 8/8/15.
 */
public class Terrain {

    private final List<List<Point>> points;

    Terrain(List<List<Point>> points) {
        this.points = points;
    }

    Point getPrevRow(int rowIndex, int colIndex) {
        ensureValid(rowIndex - 1, colIndex);

        return points.get(rowIndex - 1).get(colIndex);
    }

    Point getNextRow(int rowIndex, int colIndex) {
        ensureValid(rowIndex + 1, colIndex);

        return points.get(rowIndex + 1).get(colIndex);
    }

    Point getPrevCol(int rowIndex, int colIndex) {
        ensureValid(rowIndex, colIndex - 1);

        return points.get(rowIndex).get(colIndex - 1);
    }

    Point getNextCol(int rowIndex, int colIndex) {
        ensureValid(rowIndex, colIndex + 1);

        return points.get(rowIndex).get(colIndex + 1);
    }

    int numRows() {
        return points.size();
    }

    int numCols() {
        return points.get(0).size();
    }

    void ensureValid(int rowIndex, int colIndex) {

        if (rowIndex < 0 || rowIndex > numRows() - 1) {
            throw new RedmartException("Invalid rowIndex " + rowIndex);
        }

        if (colIndex < 0 || colIndex > numCols() -1) {
            throw new RedmartException("Invalid colIndex " + colIndex);
        }
    }
}