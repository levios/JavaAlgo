package algo;

import java.io.*;
import java.util.*;

public class Yelp {

    static class UserClick {
        String source;
        String destination;

        public UserClick(String source, String destination) {
            this.source = source;
            this.destination = destination;
        }

        public String toString() {
            return String.format("source=%s,         destination=%s", this.source, this.destination);
        }

    }

    ;

    public static void main(String[] args) {
        ArrayList<UserClick> userData = new ArrayList<>(Arrays.asList(
            new UserClick("Home Cleaning", "Restaurants"),
            new UserClick("Restaurants", "Delivery"),
            new UserClick("Delivery", "Address Search"),
            new UserClick("Address Search", "Burgers"),
            new UserClick("Burgers", "Order Delivery"),
            new UserClick("Order Delivery", "Start Order"),
            new UserClick("Start Order", "Turkey Burger"),
            new UserClick("A", "B"),
            new UserClick("B", "C"),
            new UserClick("B", "D")
        ));

        Collections.shuffle(userData);

        //for (UserClick userClick : userData) {
        //System.out.println(userClick);
        //}

        System.out.println(originateMultiple(userData, "A"));

    }

    ///////////   Your solution here /////////////
    // Given the shuffled click data and an origin page, find the final destination page
    // ex: input: 'Home' -> output: 'Turkey Burger'

    static String originate(List<UserClick> userData, String origin) {
        Map<String, String> m = new HashMap<>();
        for (int i = 0; i < userData.size(); i++) {
            m.put(userData.get(i).source, userData.get(i).destination);
        }
        Set<String> path = new HashSet<>();
        path.add(origin);
        String next = m.get(origin);
        String previous = origin;
        path.add(previous);
        while (next != null) {
            previous = next;
            next = m.get(next);
            if (path != null && path.contains(next)) {
                throw new IllegalStateException("cycle found");
            }
            path.add(next);
        }
        return previous;
    }


    static List<String> originateMultiple(List<UserClick> userData, String origin) {
        Map<String, Set<String>> m = new HashMap<>();
        for (int i = 0; i < userData.size(); i++) {
            m.putIfAbsent(userData.get(i).source, new HashSet<>());
            Set<String> values = m.get(userData.get(i).source);
            values.add(userData.get(i).destination);

        }
        return recursion(m, origin);
    }

    static List<String> recursion(Map<String, Set<String>> m, String origin) {
        List<String> list = new LinkedList<>();
        Set<String> next = m.get(origin);
        if (next == null) {
            return Collections.singletonList(origin);
        }
        for (String s : next) {
            List<String> paths = recursion(m, s);
            list.addAll(paths);
        }
        return list;
    }

}
