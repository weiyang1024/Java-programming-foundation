package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeA {
    Map<String, Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> object) {
        //实现练习要求，并改写该行代码。
        List<String> list = object.get("value");
        list.stream().map(str ->
        {
            if (!collectionA.get(str).equals(null))
                collectionA.put(str, collectionA.get(str) - 1);
            return str;
        }).collect(Collectors.toList());

        return collectionA;
    }
}
