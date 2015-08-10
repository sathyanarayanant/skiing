package redmart.skiing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathya on 8/8/15.
 */
public class TestData {

    private static final Logger LOG = LoggerFactory.getLogger(TestData.class);

    static List<List<Point>> getTestPoints4x4() {
        List<List<Point>> listOfList = new ArrayList<>();

        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0, 4));
        list.add(new Point(0, 1, 8));
        list.add(new Point(0, 2, 7));
        list.add(new Point(0, 3, 3));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new Point(1, 0, 2));
        list.add(new Point(1, 1, 5));
        list.add(new Point(1, 2, 9));
        list.add(new Point(1, 3, 3));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new Point(2, 0, 6));
        list.add(new Point(2, 1, 3));
        list.add(new Point(2, 2, 2));
        list.add(new Point(2, 3, 5));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new Point(3, 0, 4));
        list.add(new Point(3, 1, 4));
        list.add(new Point(3, 2, 1));
        list.add(new Point(3, 3, 6));
        listOfList.add(list);

        return listOfList;
    }

    static List<List<Point>> getTestPoints2x2() {
        List<List<Point>> listOfList = new ArrayList<>();

        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0, 1));
        list.add(new Point(0, 1, 2));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new Point(1, 0, 4));
        list.add(new Point(1, 1, 3));
        listOfList.add(list);

        return listOfList;
    }

    static List<List<Point>> getTestPoints2x5() {
        List<List<Point>> listOfList = new ArrayList<>();

        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0, 1));
        list.add(new Point(0, 1, 2));
        list.add(new Point(0, 2, 3));
        list.add(new Point(0, 3, 4));
        list.add(new Point(0, 4, 5));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new Point(1, 0, 6));
        list.add(new Point(1, 1, 7));
        list.add(new Point(1, 2, 8));
        list.add(new Point(1, 3, 9));
        list.add(new Point(1, 4, 10));

        listOfList.add(list);

        return listOfList;
    }

    static List<List<Point>> getTestPoints1x1() {
        List<List<Point>> listOfList = new ArrayList<>();

        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0, 1));

        listOfList.add(list);

        return listOfList;
    }
}
