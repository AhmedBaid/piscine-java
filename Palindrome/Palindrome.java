public class Palindrome {
    public static boolean isPalindrome(String s) {
        String s1 = new StringBuilder(s).toString();
        String s2 = new StringBuilder(s).reverse().toString();


        return s1.equals(s2);
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("ressasser"));
        System.out.println(Palindrome.isPalindrome("Bonjour"));
    }
}