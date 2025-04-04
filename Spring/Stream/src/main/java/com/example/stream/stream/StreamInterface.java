package com.example.stream.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInterface {

    public void testStream(){

        Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
        List<String> names = nameStream.collect(Collectors.toList());
        System.out.println(names);

        String[] cityArray = new String[] {"San Jose", "Seoul", "Tokyo"};
        Stream<String> cityStream = Arrays.stream(cityArray);
        List<String> cityList = cityStream.collect(Collectors.toList());
        System.out.println(cityList);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3,5,7));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println(numberList);




    }
}
