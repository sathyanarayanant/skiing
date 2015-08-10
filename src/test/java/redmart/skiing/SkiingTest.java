package redmart.skiing;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SkiingTest {

    @Test
    public void testWithGiven4x4() {
        List<List<PointData>> points = TestData.getTestPoints4x4();

        List<PointData> bestPath = Skiing.getBestPathInTerrain(points);

        //path should be 9-5-3-2-1
        assertEquals(5, bestPath.size());

        assertEquals(1, bestPath.get(0).getRowIndex());
        assertEquals(2, bestPath.get(0).getColIndex());
        assertEquals(9, bestPath.get(0).getHeight());

        assertEquals(1, bestPath.get(1).getRowIndex());
        assertEquals(1, bestPath.get(1).getColIndex());
        assertEquals(5, bestPath.get(1).getHeight());

        assertEquals(2, bestPath.get(2).getRowIndex());
        assertEquals(1, bestPath.get(2).getColIndex());
        assertEquals(3, bestPath.get(2).getHeight());

        assertEquals(2, bestPath.get(3).getRowIndex());
        assertEquals(2, bestPath.get(3).getColIndex());
        assertEquals(2, bestPath.get(3).getHeight());

        assertEquals(3, bestPath.get(4).getRowIndex());
        assertEquals(2, bestPath.get(4).getColIndex());
        assertEquals(1, bestPath.get(4).getHeight());
    }

    @Test
    public void testWith2x2() {
        List<List<PointData>> points = TestData.getTestPoints2x2();

        //input is like this:
        //1 2
        //4 3

        //best path should be: 4-3-2-1

        List<PointData> bestPath = Skiing.getBestPathInTerrain(points);
        assertEquals(4, bestPath.size());
        assertEquals(4, bestPath.get(0).getHeight());
        assertEquals(3, bestPath.get(1).getHeight());
        assertEquals(2, bestPath.get(2).getHeight());
        assertEquals(1, bestPath.get(3).getHeight());
    }

    @Test
    public void testWith2x5() {
        List<List<PointData>> points = TestData.getTestPoints2x5();

        //input is like this:
        //1 2 3 4 5
        //6 7 8 9 10

        //best path should be: 10-9-8-7-6-1
        List<PointData> bestPath = Skiing.getBestPathInTerrain(points);
        assertEquals(6, bestPath.size());

        assertEquals(10, bestPath.get(0).getHeight());
        assertEquals(9, bestPath.get(1).getHeight());
        assertEquals(8, bestPath.get(2).getHeight());
        assertEquals(7, bestPath.get(3).getHeight());
        assertEquals(6, bestPath.get(4).getHeight());
        assertEquals(1, bestPath.get(5).getHeight());
    }

    @Test
    public void testWith1x1() {
        List<List<PointData>> points = TestData.getTestPoints1x1();

        //input has just 1 point with height 1

        //best path should be: 1

        List<PointData> bestPath = Skiing.getBestPathInTerrain(points);
        assertEquals(1, bestPath.size());

        assertEquals(0, bestPath.get(0).getRowIndex());
        assertEquals(0, bestPath.get(0).getColIndex());
        assertEquals(1, bestPath.get(0).getHeight());
    }
}
