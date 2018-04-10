package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeC {
    List<String> collectSameElements(List<String> collection1, Map<String, List<String>> collection2) {
        //实现练习要求，并改写该行代码。
        List<String> list2 = new ArrayList<>();
        for (String key : collection2.keySet())
            if (key == "value")
                list2.addAll(collection2.get(key));

        return collection1.stream()
                .filter(str -> list2.contains(str))
                .collect(Collectors.toList());
    }
}
