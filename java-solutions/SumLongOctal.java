public class SumLongOctal {
    public static void main(String[] args) {
        long s = 0;
        for (int i = 0; i != args.length; i++) {
            int first, last = -1;
            while (last + 1 < args[i].length()) {
                for (first = last + 1; first != args[i].length() &&
                        Character.isWhitespace(args[i].charAt(first)); ++first);
                for (last = first; last != args[i].length() &&
                        !Character.isWhitespace(args[i].charAt(last)) &&
                        args[i].charAt(last) != 'o' && args[i].charAt(last) != 'O'; ++last);
                int system = last != args[i].length() && (args[i].charAt(last) == 'o' || args[i].charAt(last) == 'O') ? 8 : 10;
                if (first != last) {
                    s += Long.parseLong(args[i], first, last, system);
                }
            }
        }
        System.out.println(s);
    }
}