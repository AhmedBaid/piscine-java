import java.io.IOException;

public class RegexReplace {
    public static String removeUnits(String s) {
        return s.replaceAll("(?<=\\d)(cm|€)(?=\\s|$)", "");
    }

    public static String obfuscateEmail(String s) {
        if (s == null || !s.contains("@")) {
            return s;
        }

        String[] parts = s.split("@");
        if (parts.length != 2) {
            return s;
        }

        String username = parts[0];
        String domain = parts[1];

        int sepIndex = -1;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (c == '-' || c == '.' || c == '_') {
                sepIndex = i;
                break;
            }
        }

        if (sepIndex != -1) {
            String keep = username.substring(0, sepIndex + 1);
            String hide = username.substring(sepIndex + 1).replaceAll(".", "*");
            username = keep + hide;
        } else if (username.length() > 3) {
            String keep = username.substring(0, 3);
            String hide = username.substring(3).replaceAll(".", "*");
            username = keep + hide;
        }

        String[] domParts = domain.split("\\.");

        if (domParts.length == 3) {
            domParts[0] = domParts[0].replaceAll(".", "*");
            domParts[2] = domParts[2].replaceAll(".", "*");
            domain = String.join(".", domParts);

        } else if (domParts.length == 2) {
            domParts[0] = domParts[0].replaceAll(".", "*");
            String tld = domParts[1];

            if (!tld.equals("com") && !tld.equals("org") && !tld.equals("net")) {
                domParts[1] = domParts[1].replaceAll(".", "*");
            }
            domain = String.join(".", domParts);
        }

        return username + "@" + domain;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(RegexReplace.removeUnits("1515151cm"));
        System.out.println(RegexReplace.removeUnits("32 cm et 50 €"));
        System.out.println(RegexReplace.removeUnits("32cms et 50€!"));

        System.out.println(RegexReplace.obfuscateEmail("john.doe@example.com"));
        System.out.println(RegexReplace.obfuscateEmail("jann@example.co.org"));
        System.out.println(RegexReplace.obfuscateEmail("jackob@example.fr"));
    }
}