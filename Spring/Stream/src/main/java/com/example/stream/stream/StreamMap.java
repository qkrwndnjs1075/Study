package com.example.stream.stream;

import com.example.stream.model.Order;
import com.example.stream.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public void testStreamMap(){
        List<Integer> numberList = Arrays.asList(3,6,-4);
        List<Integer> numberListX2 = numberList.stream()
                .map(x -> x*2)
                .collect(Collectors.toList());
        System.out.println(numberListX2);

        Stream<Integer> numberListStream = numberList.stream();
        List<String> strList = numberListStream
                .map(x-> "Number is"+ x)
                .toList();
        System.out.println(strList);

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@gmail.com");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@gmail.com");
        User user3 = new User()
                .setId(104)
                .setName("Charlie")
                .setVerified(true)
                .setEmailAddress("charlie@gmail.com");

        List<User> users = Arrays.asList(user1,user2,user3);
        List<String> userEmailList = users.stream()
                .map(User::getEmailAddress)
                .toList();
        System.out.println(userEmailList);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreateByUserId(101);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(103);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreateByUserId(102);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreateByUserId(101);

        List<Order> orders = Arrays.asList(order1,order2,order3,order4,order5);
        List<Long> usersId = orders.stream()
                .map(Order::getCreateByUserId)
                .collect(Collectors.toList());

        System.out.println(usersId);
    }
}
