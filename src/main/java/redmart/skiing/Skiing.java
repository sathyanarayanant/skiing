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

    //package visible to allow unit testing this function
    static List<Point> sortByHeightAsc(List<List<Point>> listOfList) {
        List<Point> list = new ArrayList<>();

        for (List<Point> l : listOfList) {
            list.addAll(l);
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return new Integer(o1.getHeight()).compareTo(new Integer(o2.getHeight()));
            }
        });

        return list;
    }

    public static List<Point> getBestPath(Terrain terrain, Point point, PathCache pathCache) {

        List<Point> possibleNexts = new ArrayList<>();

        //previous column
        if (point.getColIndex() > 0) {
            Point p = terrain.getPrevCol(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //previous row
        if (point.getRowIndex() > 0) {
            Point p = terrain.getPrevRow(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //next col
        if (point.getColIndex() < terrain.numCols() - 1) {
            Point p = terrain.getNextCol(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        //next row
        if (point.getRowIndex() < terrain.numRows() - 1) {
            Point p = terrain.getNextRow(point.getRowIndex(), point.getColIndex());
            if (p.getHeight() < point.getHeight()) {
                possibleNexts.add(p);
            }
        }

        if (possibleNexts.isEmpty()) {
            return Lists.newArrayList(point);
        }

        //find the best next point
        List<List<Point>> paths = new ArrayList<>();
        for (Point p : possibleNexts) {
            if (! pathCache.contains(p)) {
                throw new RedmartException("No cache entry found for point with rowIndex "
                        + p.getRowIndex() + " and colIndex " + p.getColIndex());
            }

            List<Point> path = Lists.newArrayList(point);
            path.addAll(pathCache.get(p));

            paths.add(path);
        }

        return getBestPath(paths);
    }

    public static List<Point> getBestPath(List<List<Point>> paths) {
        if (paths.isEmpty()) {
            return null;
        }

        List<Point> best = paths.get(0);
        for (int i = 1; i < paths.size(); i++) {
            List<Point> path = paths.get(i);

            best = getBetterOf2(path, best);
        }

        return best;
    }

    //package visible to allow unit testing this function
    static int getDrop(List<Point> points) {
        if (points.isEmpty()) {
            return 0;
        } else {
            return points.get(0).getHeight() - points.get(points.size() - 1).getHeight();
        }
    }

    //package visible to allow unit testing this function
    static List<Point> getBetterOf2(List<Point> first, List<Point> second) {
        return isFirstBetter(first, second) ? first : second;
    }

    private static boolean isFirstBetter(List<Point> first, List<Point> second) {
        return (first.size() > second.size())
                || ((first.size() == second.size()) && (getDrop(first) > getDrop(second)));
    }

    public static List<Point> getBestPossiblePath(List<List<Point>> points) {

        Terrain terrain = new Terrain(points);

        List<Point> sorted = sortByHeightAsc(points);

        PathCache cache = new PathCache();
        List<Point> best = new ArrayList<Point>();
        for (Point point : sorted) {
            List<Point> path = getBestPath(terrain, point, cache);
            cache.put(point, path);

            best = getBetterOf2(path, best);
        }

        return best;
    }
}