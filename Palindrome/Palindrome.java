public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String s1 = new StringBuilder(s).toString();
        String s2 = new StringBuilder(s).reverse().toString();

        return s1.toLowerCase().equals(s2.toLowerCase());
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("ressasser"));
        System.out.println(Palindrome.isPalindrome("Bonjour"));
    }
}