package redmart.skiing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {
        System.out.println("hello world");

        //List<List<Point>> points = pf.getTestPoints3();
        List<List<PointData>> points = getPointsFromFile("input.txt");

        /*Terrain terrain = new Terrain(points);

        TerrainHelper th = new TerrainHelper();
        List<Point> sorted = th.sortByHeightAsc(points);

        Cache cache = new Cache();
        LengthDrop best = new LengthDrop(0, 0);
        for (Point point : sorted) {
            LengthDrop ld = th.getBestLengthDrop(terrain, point, cache);
            cache.put(point, ld);

            best = LengthDrop.best(ld, best);
        }*/

        Skiing th = new Skiing();
        List<PointData> best = th.getBestPathInTerrain(points);

        System.out.println("best length: " + best.size() + ", best drop: " + th.getDrop(best));
    }

    static List<List<PointData>> getPointsFromFile(String fileName) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());

        FileParser fp = new FileParser();
        return fp.parse(strings);
    }
}
