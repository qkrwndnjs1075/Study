package com.example.stream.stream;

import com.example.stream.model.Order;
import com.example.stream.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorted {

    public void testStreamSorted(){

        List<Integer> numbers = Arrays.asList(3,1,5,2);
        List<Integer> sortedNumber = numbers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumber);

        User user1 = new User()
                .setId(101)
                .setName("Paul")
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
        List<User> sortedUser = users.stream()
                .sorted((u1,u2)->u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());
        System.out.println(sortedUser);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreateByUserId(101)
                .setCreateAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(103)
                .setCreateAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreateByUserId(102)
                .setCreateAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(104)
                .setCreateAt(now.minusMinutes(15));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreateByUserId(101)
                .setCreateAt(now.minusHours(10));

        List<Order> orders = Arrays.asList(order1,order2,order3,order4,order5);
        List<Order> sortedOrder = orders.stream()
                .sorted(((o1, o2) -> o1.getCreateAt().compareTo(o2.getCreateAt())))
                .collect(Collectors.toList());
        System.out.println(sortedOrder);

    }
}
