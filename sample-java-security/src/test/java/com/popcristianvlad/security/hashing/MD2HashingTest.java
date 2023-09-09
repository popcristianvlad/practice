package com.popcristianvlad.security.hashing;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MD2HashingTest {

    private static Stream<Arguments> md2HashingTestValues() {
        return Stream.of(
                Arguments.arguments("AbcdAbcd11", "f20147317d6777f48dad9f6df1f00bf6", 16),
                Arguments.arguments("AbcdAbcd12", "c409f9aa3679a34048460e06e16c31ce", 16),
                Arguments.arguments("AbcdAbcd1123", "41a5b94f2bcc2d01062305c30161d7f9", 16),
                Arguments.arguments("AbcdAbcdsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafdffffffffffffffffffd1123", "2608efda21ca21b929de9cc82c2b447e", 16)
        );
    }

    @ParameterizedTest
    @DisplayName("Test MD2 hashing")
    @MethodSource("md2HashingTestValues")
    void testMD2Hashing(String valueToHash, String hexHashedValue, int byteOutputSize) throws NoSuchAlgorithmException {
        byte[] hashedValue = MD2Hashing.md2Hashing(valueToHash);
        assertEquals(hexHashedValue, new String(Hex.encodeHex(hashedValue)));
        assertEquals(byteOutputSize, hashedValue.length);
    }
}
