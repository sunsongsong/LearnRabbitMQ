package com.example.rabbitmq;

public class RegTest {


    public static void main(String[] args) {
        String reg = "^[0-9]+\\.{0,1}[0-9]{0,2}$";
        String reg2 = "^(192|172.\\d{1,3}.\\d{1,3}.\\d{1,3})|172.2.2.2$";
        String ip = "172.1.22.3";
        System.out.println(ip.matches(reg2));

    }
}
