package redmart.common;

public class Util {
    public static boolean canParseAsInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void ensure(boolean condition, String messageIfConditionFalse) {
        if (! condition) {
            throw new RedmartException(messageIfConditionFalse);
        }
    }
}
