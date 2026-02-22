public class StringReplace {
    public static <W> String replace(String s, W target, W replacement) {
        return s.replaceAll(target.toString(), replacement.toString());
    }
}