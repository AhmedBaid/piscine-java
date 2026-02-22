public class StringContains {
    public static boolean isStringContainedIn(String subString, String s) {
        return subString!=null && s!=null && s.contains(subString);
    }
}