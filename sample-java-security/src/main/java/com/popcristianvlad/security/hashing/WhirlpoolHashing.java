package com.popcristianvlad.security.hashing;

import com.popcristianvlad.security.hashing.base.BouncyCastleBaseHashing;
import org.bouncycastle.crypto.digests.WhirlpoolDigest;

public class WhirlpoolHashing extends BouncyCastleBaseHashing {

    public static byte[] whirlpoolHashing(String valueToHash) {
        return hash(new WhirlpoolDigest(), valueToHash);
    }
}
