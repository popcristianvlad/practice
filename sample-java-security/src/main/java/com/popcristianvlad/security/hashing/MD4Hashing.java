package com.popcristianvlad.security.hashing;

import com.popcristianvlad.security.hashing.base.BouncyCastleBaseHashing;
import org.bouncycastle.crypto.digests.MD4Digest;

public class MD4Hashing extends BouncyCastleBaseHashing {

    public static byte[] md4Hashing(String valueToHash) {
        return hash(new MD4Digest(), valueToHash);
    }
}