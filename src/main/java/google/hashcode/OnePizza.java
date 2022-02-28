package google.hashcode;

import java.io.*;
import java.util.*;

public class OnePizza {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/hashcode/";
    static final String IN = FILENAME + "a_an_example.in.txt";
    static final String OUT = FILENAME + "a_an_example.out";
    ///////////////////////////////////////////
    private static void solve() {
        int clients = in.nextInt();
        int counter = 0;
        Map<Integer, Set<String>> likesByClient = new HashMap<>();
        Map<Integer, Set<String>> dislikesByClient = new HashMap<>();
        Map<String, Integer> ingredientLikes = new HashMap<>();
        Map<String, Integer> ingredientDislikes = new HashMap<>();
        for (int i = 0; i < clients; i++) {
            int likeCount = in.nextInt();
            Set<String> likes = new HashSet<>();
            for (int j = 0; j < likeCount; j++) {
                String ing = in.next();
                ingredientLikes.putIfAbsent(ing, 0);
                ingredientLikes.computeIfPresent(ing, (key,val) -> val+1);
                likes.add(ing);
            }
            int dislikeCount = in.nextInt();
            Set<String> dislikes = new HashSet<>();
            for (int j = 0; j < dislikeCount; j++) {
                String ing = in.next();
                ingredientDislikes.putIfAbsent(ing, 0);
                ingredientDislikes.computeIfPresent(ing, (key,val) -> val+1);
                dislikes.add(ing);
            }
            likesByClient.put(i, likes);
            dislikesByClient.put(i, dislikes);
        }
        Set<String> s = ingredientLikes.keySet();
        s.removeAll(ingredientDislikes.keySet());
        String output = String.join(" ", s);
        print(s.size() + " " + output);
    }

    private static void print(Object s) {
        out.println(s);
        if (debug) System.out.println(s);
    }

    private static Scanner in;
    private static PrintStream out;

    private static void run() throws Exception {
        if (debug) {
            in = new Scanner(new File(IN));
            // in = new Scanner(Quali4.class.getResourceAsStream(IN));
            out = new PrintStream(new FileOutputStream(OUT));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        }
        solve();
        in.close();
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
//        if (debug)
//            System.in.read();
    }
}
