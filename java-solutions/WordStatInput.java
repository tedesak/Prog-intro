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
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;

public class WordStatInput {
    public static void main(String[] args) {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));
            Writer writer = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(args[1]), "UTF-8"));
            try {
                int read = reader.read();
                Queue<String> q = new ArrayDeque<String>();
                Map<String, Integer> map = new HashMap<>();
                StringBuilder str = new StringBuilder("");
                while (read >= 0){
                    int a = Character.getType(read);
                    if (a == 1 || a == 2 || a == 20 || read == '\''){
                        str.append((char)read);
                    } else {
                        String S = str.toString().toLowerCase();
                        str = new StringBuilder("");
                        if (!S.isEmpty())
                            if (map.containsKey(S)){
                                map.put(S, map.get(S) + 1);
                            } else {
                                q.add(S);
                                map.put(S, 1);
                            }
                    }
                    read = reader.read();
                }
                while (!q.isEmpty()){
                    writer.write(q.element() + " " + map.get(q.element()) + "\n");
                    q.remove();
                }
            } finally {
                reader.close();
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Something is broken" + e.getMessage());
        } 
    }
}