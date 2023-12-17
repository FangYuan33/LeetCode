package leetcode.hashmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution811 {

    public static void main(String[] args) {
        System.out.println(new Solution811().subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> domainCount = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];

            int index = -1;
            do {
                domain = domain.substring(index + 1);
                domainCount.put(domain, domainCount.getOrDefault(domain, 0) + count);
                index = domain.indexOf(".");
            } while (index != -1);
        }

        List<String> res = new LinkedList<>();
        String format = "%d %s";
        for (Map.Entry<String, Integer> domainCountEntry : domainCount.entrySet()) {
            res.add(String.format(format, domainCountEntry.getValue(), domainCountEntry.getKey()));
        }
        return res;
    }
}
