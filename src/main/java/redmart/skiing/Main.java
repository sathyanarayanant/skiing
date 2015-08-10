package redmart.skiing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {

        List<List<Point>> points = getPointsFromFile("input.txt");

        List<Point> best = Skiing.getBestPossiblePath(points);

        System.out.println("best length: " + best.size() + ", best drop: " + Skiing.getDrop(best));
    }

    static List<List<Point>> getPointsFromFile(String fileName) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());

        return FileParser.parse(strings);
    }
}
