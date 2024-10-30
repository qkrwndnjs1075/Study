package com.example.stream.stream;

import java.util.Arrays;
import java.util.List;

public class StreamSorted {

    public void testStreamSorted(){

        List<Integer> numbers = Arrays.asList(3,1,5,2);
        List<Integer> sortedNumber = numbers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumber);
    }
}
