import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.lang.StringBuilder;
import java.util.TreeMap;
import java.util.Map;

public class WordStatWordsShingles {
    public static void main(String[] args) {
        try {
            MyScanner reader = new MyScanner(new FileInputStream(args[0]));
            try {
                Writer writer = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(args[1]), "UTF-8"));
                try {
                    int read = reader.read();
                    TreeMap<String, Integer> map = new TreeMap<>();
                    StringBuilder str = new StringBuilder();
                    while (read >= 0) {
                        int readNew = reader.read();
                        boolean f = Character.getType(read) == Character.DASH_PUNCTUATION || Character.isLetter(read) || read == '\'';
                        if (f) {
                            str.append((char) read);
                            if (str.length() == 4) {
                                str.deleteCharAt(0);
                            }
                        }
                        if (f && (str.length() == 3 || readNew < 0) ||
                         !f && (str.length() == 2 || str.length() == 1)) {
                            String S = str.toString().toLowerCase();
                            if (map.containsKey(S)) {
                                map.put(S, map.get(S) + 1);
                            } else {
                                map.put(S, 1);
                            }
                        }
                        if (!f) {
                            str = new StringBuilder("");
                        }
                        read = readNew;
                    }
                    for (Map.Entry<String, Integer> p : map.entrySet()) {
                        writer.write(p.getKey() + " " + p.getValue() + "\n");
                    }
                 }finally {
                    writer.close();
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("I/O error" + e.getMessage());
        } 
    }
}
