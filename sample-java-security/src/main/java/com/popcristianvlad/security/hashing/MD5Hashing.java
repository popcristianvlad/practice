package com.popcristianvlad.security.hashing;

import com.popcristianvlad.security.hashing.base.JavaBaseHashing;

import java.security.NoSuchAlgorithmException;

public class MD5Hashing extends JavaBaseHashing {

    public static byte[] md5Hashing(String valueToHash) throws NoSuchAlgorithmException {
        return hash("MD5", valueToHash);
    }
}
