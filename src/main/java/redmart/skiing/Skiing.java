package redmart.skiing;

import com.google.common.collect.Lists;
import redmart.common.RedmartException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sathya on 8/8/15.
 * Contains stateless helper functions related to computing best path
 */
public class Skiing {

    public static List<PointData> sortByHeightAsc(List<List<PointData>> listOfList) {
        List<PointData> list = new ArrayList<>();

        for (List<PointData> l : listOfList) {
            list.addAll(l);
        }

        Collections.sort(list, new Comparator<PointData>() {
            @Override
            public int compare(PointData o1, PointData o2) {
                return new Integer(o1.getHeight()).compareTo(new Integer(o2.getHeight()));
            }
        });

        return list;
    }

    LengthDrop getBestLengthDrop(Terrain terrain, PointData point, Cache cache) {

        List<PointData> possibleNexts = new ArrayList<>();

        //previous column
        if (point.getColIndex() > 0) {
            PointData p = terrain.getPrevCol(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //previous row
        if (point.getRowIndex() > 0) {
            PointData p = terrain.getPrevRow(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //next col
        if (point.getColIndex() < terrain.numCols() - 1) {
            PointData p = terrain.getNextCol(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //next row
        if (point.getRowIndex() < terrain.numRows() - 1) {
            PointData p = terrain.getNextRow(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        if (possibleNexts.isEmpty()) {
            return new LengthDrop(1, 0);
        }

        //find the best next point
        List<LengthDrop> lengthDrops = new ArrayList<>();
        for (PointData p : possibleNexts) {
            if (! cache.contains(p)) {
                throw new RedmartException("No cache entry found for point with rowIndex "
                        + p.getRowIndex() + " and colIndex " + p.getColIndex());
            }

            int length = cache.get(p).getLength() + 1;
            int drop = cache.get(p).getDrop() + point.getHeight() - p.getHeight();

            lengthDrops.add(new LengthDrop(length, drop));
        }

        return LengthDrop.best(lengthDrops);
    }

    public static List<PointData> getBestPath(Terrain terrain, PointData point, PathCache pathCache) {

        List<PointData> possibleNexts = new ArrayList<>();

        //previous column
        if (point.getColIndex() > 0) {
            PointData p = terrain.getPrevCol(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //previous row
        if (point.getRowIndex() > 0) {
            PointData p = terrain.getPrevRow(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //next col
        if (point.getColIndex() < terrain.numCols() - 1) {
            PointData p = terrain.getNextCol(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //next row
        if (point.getRowIndex() < terrain.numRows() - 1) {
            PointData p = terrain.getNextRow(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        if (possibleNexts.isEmpty()) {
            return Lists.newArrayList(point);
        }

        //find the best next point
        List<List<PointData>> paths = new ArrayList<>();
        for (PointData p : possibleNexts) {
            if (! pathCache.contains(p)) {
                throw new RedmartException("No cache entry found for point with rowIndex "
                        + p.getRowIndex() + " and colIndex " + p.getColIndex());
            }

            List<PointData> path = Lists.newArrayList(point);
            path.addAll(pathCache.get(p));

            paths.add(path);
        }

        return getBestPath(paths);
    }

    public static List<PointData> getBestPath(List<List<PointData>> paths) {
        if (paths.isEmpty()) {
            return null;
        }

        List<PointData> best = paths.get(0);
        for (int i = 1; i < paths.size(); i++) {
            List<PointData> path = paths.get(i);

            best = getBestPath(path, best);
        }

        return best;
    }

    public static int getDrop(List<PointData> points) {
        if (points.isEmpty()) {
            return 0;
        } else {
            return points.get(0).getHeight() - points.get(points.size() - 1).getHeight();
        }
    }

    public static List<PointData> getBestPath(List<PointData> first, List<PointData> second) {
        return isFirstBetter(first, second) ? first : second;
    }

    public static boolean isFirstBetter(List<PointData> first, List<PointData> second) {
        return (first.size() > second.size())
                || ((first.size() == second.size()) && (getDrop(first) > getDrop(second)));
    }

    public static List<PointData> getBestPathInTerrain(List<List<PointData>> points) {

        Terrain terrain = new Terrain(points);

        Skiing th = new Skiing();
        List<PointData> sorted = th.sortByHeightAsc(points);

        PathCache cache = new PathCache();
        List<PointData> best = new ArrayList<PointData>();
        for (PointData point : sorted) {
            List<PointData> path = th.getBestPath(terrain, point, cache);
            cache.put(point, path);

            best = getBestPath(path, best);
        }

        return best;
    }
}