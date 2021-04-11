package com.pn.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

//@SuppressWarnings("all")//抑制警告
public class IDUtils {


    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    @Test
    public void testId(){
        System.out.println(IDUtils.getId());
    }
}
