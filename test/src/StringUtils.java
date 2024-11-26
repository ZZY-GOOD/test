public class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    public String substring(String str, int start, int end) {
        if (start < 0 || end > str.length() || start > end) {
            return "";
        }
        return str.substring(start, end);
    }
}
