package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeD {
    Map<String, Integer> createUpdatedCollection(List<String> collectionA, Map<String, List<String>> object) {
        //实现练习要求，并改写该行代码。

        Map<String, Long> map = collectionA.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for (String key : map.keySet())
            map2.put(key, (int) (long) map.get(key));
        Map<String, Integer> map3 = new HashMap<String, Integer>();
        for (String key : map2.keySet()) {
            String str1 = key.replaceAll("[^a-z^A-Z]", "");
            String str2 = key.replaceAll("[^0-9]", "");
            if (map3.containsKey(str1))
                map3.put(str1, map3.get(str1) + (str2.equals("") ? 1 : Integer.parseInt(str2)));
            else
                map3.put(str1, str2.equals("") ? map2.get(key) : Integer.parseInt(str2));
        }

        List<String> list = object.get("value");
        list.stream().map(str ->
        {
            if (!map3.get(str).equals(null) && map3.get(str) >= 3)
                map3.put(str, map3.get(str) - map3.get(str)/3);
            return str;
        }).collect(Collectors.toList());

        return map3;
    }
}
