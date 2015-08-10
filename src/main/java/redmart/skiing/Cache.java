package redmart.skiing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sathya on 8/8/15.
 */
public class Cache {

    private Map<String, LengthDrop> cache = new HashMap<>();

    void put(PointData point, LengthDrop ld) {
        String key = getKey(point.getRowIndex(), point.getColIndex());
        cache.put(key, ld);
    }

    LengthDrop get(PointData point) {
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
