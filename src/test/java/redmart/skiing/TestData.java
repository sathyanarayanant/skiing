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

    static List<List<PointData>> getTestPoints4x4() {
        List<List<PointData>> listOfList = new ArrayList<>();

        List<PointData> list = new ArrayList<>();
        list.add(new PointData(0, 0, 4));
        list.add(new PointData(0, 1, 8));
        list.add(new PointData(0, 2, 7));
        list.add(new PointData(0, 3, 3));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new PointData(1, 0, 2));
        list.add(new PointData(1, 1, 5));
        list.add(new PointData(1, 2, 9));
        list.add(new PointData(1, 3, 3));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new PointData(2, 0, 6));
        list.add(new PointData(2, 1, 3));
        list.add(new PointData(2, 2, 2));
        list.add(new PointData(2, 3, 5));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new PointData(3, 0, 4));
        list.add(new PointData(3, 1, 4));
        list.add(new PointData(3, 2, 1));
        list.add(new PointData(3, 3, 6));
        listOfList.add(list);

        return listOfList;
    }

    static List<List<PointData>> getTestPoints2x2() {
        List<List<PointData>> listOfList = new ArrayList<>();

        List<PointData> list = new ArrayList<>();
        list.add(new PointData(0, 0, 1));
        list.add(new PointData(0, 1, 2));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new PointData(1, 0, 4));
        list.add(new PointData(1, 1, 3));
        listOfList.add(list);

        return listOfList;
    }

    static List<List<PointData>> getTestPoints2x5() {
        List<List<PointData>> listOfList = new ArrayList<>();

        List<PointData> list = new ArrayList<>();
        list.add(new PointData(0, 0, 1));
        list.add(new PointData(0, 1, 2));
        list.add(new PointData(0, 2, 3));
        list.add(new PointData(0, 3, 4));
        list.add(new PointData(0, 4, 5));
        listOfList.add(list);

        list = new ArrayList<>();
        list.add(new PointData(1, 0, 6));
        list.add(new PointData(1, 1, 7));
        list.add(new PointData(1, 2, 8));
        list.add(new PointData(1, 3, 9));
        list.add(new PointData(1, 4, 10));

        listOfList.add(list);

        return listOfList;
    }

    static List<List<PointData>> getTestPoints1x1() {
        List<List<PointData>> listOfList = new ArrayList<>();

        List<PointData> list = new ArrayList<>();
        list.add(new PointData(0, 0, 1));

        listOfList.add(list);

        return listOfList;
    }
}
