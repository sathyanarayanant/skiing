package redmart.skiing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathya on 8/8/15.
 */
public class LengthDrop {
    private int length;
    private int drop;

    public LengthDrop(int length, int drop) {
        this.length = length;
        this.drop = drop;
    }

    public int getLength() {
        return length;
    }

    public int getDrop() {
        return drop;
    }

    public static LengthDrop best(List<LengthDrop> lengthDrops) {
        int bestLength = 0;
        int bestDrop = 0;

        for (LengthDrop ld : lengthDrops) {
            if ((ld.length > bestLength) || (ld.length == bestLength) && (ld.drop > bestDrop)) {
                bestLength = ld.length;
                bestDrop = ld.drop;
            }
        }

        return new LengthDrop(bestLength, bestDrop);
    }

    public static LengthDrop best(LengthDrop ld1, LengthDrop ld2) {
        List<LengthDrop> list = new ArrayList<>();
        list.add(ld1);
        list.add(ld2);

        return best(list);
    }
}
