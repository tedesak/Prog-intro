import java.io.IOException;
import java.io.FileInputStream;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.lang.StringBuilder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;

public class WsppCountLastL {
    public static void main(String[] args) {
        try {
            Map<String, IntList> map = new LinkedHashMap<>();
            Map<Integer, List<String>> sortMap = new TreeMap<>();
            try (MyScanner reader = new MyScanner(new FileInputStream(args[0]))) {
                int read = reader.read(), count = 0, numStr = 1;
                StringBuilder str = new StringBuilder();
                while (read >= 0) {
                    if (Character.getType(read) == Character.DASH_PUNCTUATION || Character.isLetter(read)
                        || read == '\'') {
                        str.append((char) read);
                    } else {
                        String s = str.toString().toLowerCase();
                        str = new StringBuilder("");
                        if (!s.isEmpty()) {
                            count++;
                            if (!map.containsKey(s)) {
                                map.put(s, new IntList());
                                map.get(s).pushBack(0);
                                map.get(s).pushBack(0);
                            }
                            if (map.get(s).getEl(1) == numStr) {
                                map.get(s).setLastEl(count);
                            }
                            if (map.get(s).getEl(1) < numStr) {
                                map.get(s).pushBack(count);
                                map.get(s).setEl(1, numStr);
                            }
                            map.get(s).inc(0);
                        }
                        if (read == '\n' || read == '\r') {
                            numStr++;
                            if (read == '\r' && reader.readWithoutChange() == '\n') {
                                reader.read();
                            }
                            count = 0;
                        }
                    }
                    read = reader.read();
                }
                for (Map.Entry<String, IntList> p : map.entrySet()) {
                    int key = p.getValue().getEl(0);
                    if (!sortMap.containsKey(key)) {
                        sortMap.put(key, new ArrayList<>());
                    }
                    sortMap.get(key).add(p.getKey());
                }
            }
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(args[1]),
                StandardCharsets.UTF_8
            ))) {
                for (Map.Entry<Integer, List<String>> p : sortMap.entrySet()) {
                    for (String S : p.getValue()) {
                        IntList list = map.get(S);
                        writer.write(S + " " + list.getEl(0) + " ");
                        for (int i = 2; i != list.size() - 1; i++) {
                            writer.write(list.getEl(i) + " ");
                        }
                        writer.write(list.getEl(list.size() - 1) + "\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("I/O error" + e.getMessage());
        }
    }
}