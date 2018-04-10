package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeB {
    List<String> collectSameElements(List<String> collection1, List<List<String>> collection2) {
        //实现练习要求，并改写该行代码。

        List<String> list2 = new ArrayList<>();
        for(List<String> cur_list : collection2)
            list2.addAll(cur_list);

        return collection1.stream()
                .filter(str -> list2.contains(str))
                .collect(Collectors.toList());
    }
}
