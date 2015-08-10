package redmart.skiing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sathya on 8/8/15.
 */
public class PathCache {

    private Map<String, List<PointData>> cache = new HashMap<>();

    void put(PointData point, List<PointData> path) {
        String key = getKey(point.getRowIndex(), point.getColIndex());
        cache.put(key, path);
    }

    List<PointData> get(PointData point) {
        String key = getKey(point.getRowIndex(), point.getColIndex());
        return cache.get(key);
    }

    boolean contains(PointData point) {
        String key = getKey(point.getRowIndex(), point.getColIndex());
        return cache.containsKey(key);
    }

    private String getKey(int rowIndex, int colIndex) {
        return rowIndex + "_" + colIndex;
    }
}
