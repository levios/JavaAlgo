package algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Deliveroo interview - 2021-11-08
 */
public class Calculate_Clicks_by_Domain {

    Map<String, Long> calculateClicksByDomain(String[] dom) {
        Map<String, Long> m = new HashMap<>();
        // over.flow.com
        for (String s : dom) {
            String[] parts = s.split(",");
            Integer count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            if (m.containsKey(domain)) {
                m.put(domain, m.get(domain) + count);
            } else {
                m.put(domain, (long)count);
            }

            // return: An int value, representing the index of the last occurrence of the character in the string, or -1 if it never occurs
            String temp;
            int idx = domain.lastIndexOf(".");
            while (idx != -1) {
                String subdomain = domain.substring(idx + 1, domain.length());
                if (m.containsKey(subdomain)) {
                    m.put(subdomain, m.get(subdomain) + count);
                } else {
                    m.put(subdomain, (long)count);
                }

                temp = domain.substring(0, idx);
                idx = temp.lastIndexOf(".");
            }

        }
        return m;
    }


}
