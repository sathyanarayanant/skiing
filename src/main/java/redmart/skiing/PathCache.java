package redmart.skiing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sathya on 8/8/15.
 */
public class PathCache {

    private Map<String, List<Point>> cache = new HashMap<>();

    void put(Point point, List<Point> path) {
        String key = getKey(point.getRowIndex(), point.getColIndex());
        cache.put(key, path);
    }

    List<Point> get(Point point) {
        String key = getKey(point.getRowIndex(), point.getColIndex());
        return cache.get(key);
    }

    boolean contains(Point point) {
        String key = getKey(point.getRowIndex(), point.getColIndex());
        return cache.containsKey(key);
    }

    private String getKey(int rowIndex, int colIndex) {
        return rowIndex + "_" + colIndex;
    }
}
