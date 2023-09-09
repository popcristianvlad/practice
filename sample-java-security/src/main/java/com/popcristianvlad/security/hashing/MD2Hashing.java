package com.popcristianvlad.security.hashing;

import com.popcristianvlad.security.hashing.base.JavaBaseHashing;

import java.security.NoSuchAlgorithmException;

public class MD2Hashing extends JavaBaseHashing {

    public static byte[] md2Hashing(String valueToHash) throws NoSuchAlgorithmException {
        return hash("MD2", valueToHash);
    }
}