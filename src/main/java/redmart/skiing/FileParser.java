package redmart.skiing;

import redmart.common.Util;

import java.util.ArrayList;
import java.util.List;
import static redmart.common.Util.ensure;

/**
 * Created by sathya on 9/8/15.
 */
public class FileParser {

    List<List<PointData>> parse(List<String> lines)  {

        ensure(!lines.isEmpty(), "No lines specified in input");

        //first line is the number of rows and columns
        String split[] = lines.get(0).split("\\s+");
        ensure(split.length == 2, "First line should have two tokens after splitting by space");

        ensure(Util.canParseAsInt(split[0]), "Cannot parse [" + split[0] + "] as int in line 1");

        int numRows = Integer.parseInt(split[0]);
        ensure(numRows == lines.size() - 1, "Invalid number of lines in input. Found " +
                (lines.size()) + ", expected " + (numRows + 1));

        ensure(Util.canParseAsInt(split[1]), "Cannot parse [" + split[1] + "] as int in line 1");

        int numCols = Integer.parseInt(split[1]);

        List<List<PointData>> listOfList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            split = lines.get(i).split("\\s+");

            ensure(split.length == numCols, "Invalid number of tokens after splitting by space in line " + (i + 1) +
                    ". Found " + split.length + "tokens but expected " + numCols);

            List<PointData> list = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                String token = split[j];
                ensure(Util.canParseAsInt(token), "Cannot parse [" + token + "] as int in line 1");

                PointData point = new PointData(i - 1, j, Integer.parseInt(token));
                list.add(point);
            }

            listOfList.add(list);
        }

        return listOfList;
    }

}
