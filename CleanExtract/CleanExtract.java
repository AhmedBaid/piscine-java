public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] segments = s.split("\\|", -1);
        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            int firstDot = segment.indexOf('.');
            int lastDot = segment.lastIndexOf('.');

            String extracted;

            if (firstDot == -1) {
                extracted = segment;
            } else if (firstDot == lastDot) {
                extracted = segment.substring(firstDot + 1);
            } else {
                extracted = segment.substring(firstDot + 1, lastDot);
            }

            extracted = extracted.trim();

            if (!extracted.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(extracted);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                CleanExtract.extract("|hello||world|"));
    }
}