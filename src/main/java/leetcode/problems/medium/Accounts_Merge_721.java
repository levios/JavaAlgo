package leetcode.problems.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/accounts-merge/solution/
 *
 * https://leetcode.com/problems/accounts-merge/discuss/1601980/Java-Solution-using-UnionFind-Beats-99.87-of-submissions
 *
 * Tags: DSU ; Disjoint set union ; Union Find
 */
public class Accounts_Merge_721 {

    public List<List<String>> accountsMerge1(List<List<String>> accountList) {
        int accountListSize = accountList.size();
        DSU dsu = new DSU(accountListSize);

        // Maps email to their component index
        Map<String, Integer> emailGroup = new HashMap<>();

        for (int i = 0; i < accountListSize; i++) {
            int accountSize = accountList.get(i).size();

            for (int j = 1; j < accountSize; j++) {
                String email = accountList.get(i).get(j);
                String accountName = accountList.get(i).get(0);

                // If this is the first time seeing this email then
                // assign component group as the account index
                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    // If we have seen this email before then union this
                    // group with the previous group of the email
                    dsu.unionBySize(i, emailGroup.get(email));
                }
            }
        }

        // Store emails corresponding to the component's representative
        Map<Integer, List<String>> components = new HashMap<Integer, List<String>>();
        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int groupRep = dsu.findRepresentative(group);

            if (!components.containsKey(groupRep)) {
                components.put(groupRep, new ArrayList<String>());
            }

            components.get(groupRep).add(email);
        }

        // Sort the components and add the account name
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> component = components.get(group);
            Collections.sort(component);
            component.add(0, accountList.get(group).get(0));
            mergedAccounts.add(component);
        }

        return mergedAccounts;
    }

    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        int size = accounts.size();

        UnionFind uf = new UnionFind(size);

        // prepare a hash with unique email address as key and index in accouts as value
        HashMap<String, Integer> emailToId = new  HashMap<>();
        for(int i = 0; i < size; i++) {
            List<String> details = accounts.get(i);
            for(int j = 1; j < details.size(); j++) {
                String email = details.get(j);

                // if we have already seen this email before, merge the account  "i" with previous account
                // else add it to hash
                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId.get(email));
                } else  {
                    emailToId.put(email, i);
                }
            }
        }

        // prepare a hash with index in accounts as key and list of unique email address for that account as value
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for(String key : emailToId.keySet()) {
            int root = uf.root(emailToId.get(key));

            if (!idToEmails.containsKey(root)) {
                idToEmails.put(root, new ArrayList<String>());
            }

            idToEmails.get(root).add(key);
        }

        // collect the emails from idToEmails, sort it and add account name at index 0 to get the final list to add to final return List
        List<List<String>> mergedDetails =  new ArrayList<>();
        for(Integer id : idToEmails.keySet()) {
            List<String> emails =  idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));

            mergedDetails.add(emails);
        }

        return  mergedDetails;
    }
}

class DSU {
    int representative [];
    int size [];

    DSU(int sz) {
        representative = new int[sz];
        size = new int[sz];

        for (int i = 0; i < sz; ++i) {
            // Initially each group is its own representative
            representative[i] = i;
            // Intialize the size of all groups to 1
            size[i] = 1;
        }
    }

    // Finds the representative of group x
    public int findRepresentative(int x) {
        if (x == representative[x]) {
            return x;
        }

        // This is path compression
        return representative[x] = findRepresentative(representative[x]);
    }

    // Unite the group that contains "a" with the group that contains "b"
    public void unionBySize(int a, int b) {
        int representativeA = findRepresentative(a);
        int representativeB = findRepresentative(b);

        // If nodes a and b already belong to the same group, do nothing.
        if (representativeA == representativeB) {
            return;
        }

        // Union by size: point the representative of the smaller
        // group to the representative of the larger group.
        if (size[representativeA] >= size[representativeB]) {
            size[representativeA] += size[representativeB];
            representative[representativeB] = representativeA;
        } else {
            size[representativeB] += size[representativeA];
            representative[representativeA] = representativeB;
        }
    }
}

class UnionFind {
    int[] parent;
    int[] weight;

    public UnionFind(int num) {
        parent = new int[num];
        weight = new int[num];

        for(int i =  0; i < num; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    public void union(int a, int  b) {
        int rootA = root(a);
        int rootB = root(b);

        if (rootA == rootB) {
            return;
        }

        if (weight[rootA] > weight[rootB]) {
            parent[rootB] = rootA;
            weight[rootA] += weight[rootB];
        } else {
            parent[rootA] = rootB;
            weight[rootB] += weight[rootA];
        }
    }

    public int root(int a) {
        if (parent[a] == a) {
            return a;
        }

        parent[a] = root(parent[a]);
        return parent[a];
    }
}
