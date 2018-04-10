package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeC {
    Map<String, Integer> createUpdatedCollection(List<String> collectionA, Map<String, List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Long> map = collectionA.stream()
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()));
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for (String key : map.keySet())
            map2.put(key, (int) (long) map.get(key));

        List<String> list = object.get("value");
        list.stream().map(str ->
        {
            if (!map2.get(str).equals(null) && map2.get(str) >= 3)
                map2.put(str, map2.get(str) - map2.get(str)/3);
            return str;
        }).collect(Collectors.toList());

        return map2;
    }
}
