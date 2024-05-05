public class Main {
    public static void main(String[] args) {
        String result = rearrange("apple");
        System.out.println(result);
    }

    public static String rearrange(String str) {
        String temp = "";
        for (int i = str.length() - 1; i > 0; i--) {
            temp += str.substring(i - 1, i);
        }
        return temp;
    }
}
