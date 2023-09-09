package com.popcristianvlad.security.hashing;

import com.popcristianvlad.security.hashing.base.JavaBaseHashing;

import java.security.NoSuchAlgorithmException;

public class SHA1Hashing extends JavaBaseHashing {

    public static byte[] sha1Hashing(String valueToHash) throws NoSuchAlgorithmException {
        return hash("SHA-1", valueToHash);
    }
}
