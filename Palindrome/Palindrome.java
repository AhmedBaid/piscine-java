public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s==null){
            return false;
        }
        return new StringBuilder(s) == new StringBuilder(s).reverse();
    }
}