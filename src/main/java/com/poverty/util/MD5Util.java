package com.poverty.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 21:58
 */
public class MD5Util {

    public static String parse(String password, String salt) {
        Md5Hash hash = new Md5Hash(password, salt);
        return hash.toHex();
    }
}
