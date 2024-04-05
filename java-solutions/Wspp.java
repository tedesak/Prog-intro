import java.io.IOException;
import java.io.FileInputStream;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;

public class Wspp {
    public static void main(String[] args) {
        try {
            MyScanner reader = new MyScanner(new FileInputStream(args[0]));
            try {
                Writer writer = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(args[1]), "UTF-8"));
                try {
                    int read = reader.read(), count = 0;
                    Queue<String> q = new ArrayDeque<String>();
                    Map<String, IntList> map = new HashMap<>();
                    StringBuilder str = new StringBuilder("");
                    while (read >= 0) {
                        if (Character.getType(read) == Character.DASH_PUNCTUATION || Character.isLetter(read) || read == '\'') {
                            str.append((char)read);
                        } else {
                            String S = str.toString().toLowerCase();
                            str = new StringBuilder("");
                            if (!S.isEmpty()) {
                                count++;
                                if (!map.containsKey(S)) {
                                    map.put(S, new IntList());
                                    q.add(S);
                                }
                                map.get(S).pushBack(count);
                            }
                        }
                        read = reader.read();
                    }
                    while (!q.isEmpty()) {
                        IntList mas = map.get(q.element());
                        writer.write(q.element() + " " + mas.size() + " ");
                        for (int i = 0; i != mas.size(); i++) {
                            writer.write(mas.getEl(i) + "");
                            if (i + 1 != mas.size()) {
                                writer.write(" ");
                            }
                        }
                        writer.write("\n");
                        q.remove();
                    }
                } finally {
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