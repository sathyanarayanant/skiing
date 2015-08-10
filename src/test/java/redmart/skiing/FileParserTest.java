package redmart.skiing;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sathya on 10/8/15.
 */
public class FileParserTest {

    @Test
    public void testParse() {
        //try parsing data like this:
        //2 2
        //1 2
        //3 4

        List<String> lines = Lists.newArrayList("2 2", "1 2", "3 4");

        List<List<Point>> points = FileParser.parse(lines);
        assertEquals(2, points.size());
        assertEquals(1, points.get(0).get(0).getHeight());
        assertEquals(2, points.get(0).get(1).getHeight());
        assertEquals(3, points.get(1).get(0).getHeight());
        assertEquals(4, points.get(1).get(1).getHeight());
    }
}
