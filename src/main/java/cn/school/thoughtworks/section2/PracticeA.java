package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String,Long> map = collection1.stream()
                                .collect(Collectors.groupingBy(str -> str,Collectors.counting()));
        Map<String,Integer> map2 = new HashMap<String,Integer>();
        for(String key:map.keySet())
            map2.put(key,(int)(long)map.get(key));
        return map2;
    }
}
