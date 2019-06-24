package com.swpu.funchat.util;

import java.util.UUID;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/23
 */
public class IdGenerator {

    public static long generateId() {
        //随机生成一位整数
        int random = (int) (Math.random() * 9 + 1);
        String valueOf = String.valueOf(random);
        //生成uuid的hashCode值
        String uuid = UUID.randomUUID().toString();
        int hashCode = uuid.hashCode();
        System.out.println(hashCode);
        //可能为负数
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        String value = valueOf + String.format("%09d", hashCode);
        return Long.valueOf(value);
    }
}
