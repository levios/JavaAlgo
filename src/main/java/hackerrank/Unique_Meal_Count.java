package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Unique_Meal_Count {

    static class Meal {
        String name;
        List<String> ing;
        Meal(String name, List<String> ing) {
            this.ing = ing;
            this.name = name;
        }
    }

    public static int getUniqueMealCount(List<Meal> meals) {
        Set<Set<String>> set = new HashSet<>();
        for (Meal meal: meals) {
            set.add(new HashSet<>(meal.ing));
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(
                getUniqueMealCount(Arrays.asList(
                        new Meal("", Arrays.asList("t", "o", "p")),
                        new Meal("", Arrays.asList("c", "t", "p")),
                        new Meal("", Arrays.asList("o", "t", "p")),
                        new Meal("", Arrays.asList("p", "t", "c")))
                )
        );
    }

//    public static void main(String[] args) {
//        String line;
//        List<Meal> meals = new ArrayList<Meal>();
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(" - ");
//                meals.add(
//                        new Meal(
//                                parts[0],
//                                Arrays.asList(parts[1].split(","))
//                        )
//                );
//            }
//
//            int uniqueMeals = getUniqueMealCount(meals);
//            System.out.println(uniqueMeals);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
}
