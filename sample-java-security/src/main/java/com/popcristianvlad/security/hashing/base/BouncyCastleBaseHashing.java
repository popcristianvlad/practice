package com.popcristianvlad.security.hashing.base;

import org.bouncycastle.crypto.Digest;

public class BouncyCastleBaseHashing {

    protected BouncyCastleBaseHashing() {
    }

    protected static byte[] hash(Digest digest, String valueToHash) {
        final byte[] bytes = valueToHash.getBytes();
        digest.update(bytes, 0, bytes.length);
        byte[] hash = new byte[digest.getDigestSize()];
        digest.doFinal(hash, 0);

        return hash;
    }
}
