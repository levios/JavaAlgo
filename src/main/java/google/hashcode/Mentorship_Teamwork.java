package google.hashcode;

import java.io.*;
import java.util.*;

public class Mentorship_Teamwork {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/hashcode/";
    static final String IN = FILENAME + "b.txt";
    static final String OUT = FILENAME + "b.out";
    ///////////////////////////////////////////
    private static void solve() {

        Set<Contributor> contributors = new HashSet<>();

        int contributorsCount = in.nextInt();
        int projects = in.nextInt();
        for (int i = 0; i < contributorsCount; i++) {
            String contributor = in.next();
            int skillsCount = in.nextInt();
            List<Role> skills = new ArrayList<>();
            for (int j = 0; j < skillsCount; j++) {
                String skillName = in.next();
                int level = in.nextInt();
                skills.add(new Role(skillName, level));
            }
            contributors.add(new Contributor(contributor, skills, false));
        }

        for (int i = 0; i < projects; i++) {
            String projName = in.next();
            int days = in.nextInt();
            int awarded = in.nextInt();
            int bestBefore = in.nextInt();
            int numRole = in.nextInt();
            for (int j = 0; j < numRole; j++) {
                String skillName = in.next();
                int level = in.nextInt();
            }
        }



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

    static class Contributor {
        public String name;
        public List<Role> skills;
        public boolean isBusy;
        public Contributor (String name, List<Role> skills, boolean isBusy) {
            this.name = name;
            this.skills = skills;
            this.isBusy = isBusy;
        }
    }

    static class Role {
        public String skillName;
        public int level;
        public Role (String skillName, int level) {
            this.skillName = skillName;
            this.level = level;
        }
    }

    static class Project {
        public String projName;
        public int days;
        public int awarded;
        public int bestBefore;
        public List<Role> roles;
        public Project(String projName, int days, int awarded, int bestBefore, List<Role> roles) {
            this.projName = projName;
            this.days = days;
            this.awarded = awarded;
            this.bestBefore = bestBefore;
            this.roles = roles;
        }
    }
}
