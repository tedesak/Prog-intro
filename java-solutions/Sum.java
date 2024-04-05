public class Sum {
    public static void main(String[] args) {
        int s = 0, a, pos;
        for (int i = 0; i != args.length; i++){
            a = 0;
            pos = 1;
            for (int j = 0; j != args[i].length(); j++){
                if (args[i].charAt(j) == '-'){
                    pos = -1;
                } else if (args[i].charAt(j) == '+' | Character.isWhitespace(args[i].charAt(j))){
                    s += pos * a;
                    pos = 1;
                    a = 0;
                } else {
                    a *= 10;
                    a += args[i].charAt(j) - 48;
                }
            }
            s += pos * a;
        }
        System.out.println(s);
    }
}