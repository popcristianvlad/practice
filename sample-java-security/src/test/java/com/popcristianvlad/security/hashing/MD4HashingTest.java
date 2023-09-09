package com.popcristianvlad.security.hashing;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MD4HashingTest {

    private static Stream<Arguments> md4HashingTestValues() {
        return Stream.of(
                Arguments.arguments("AbcdAbcd11", "40562b3671d64557e3805e24268b15ed", 16),
                Arguments.arguments("AbcdAbcd12", "8025f9b4c0f2e50ab7f0c7a4c078468c", 16),
                Arguments.arguments("AbcdAbcd1123", "9e1f54c33120ea5395605d60cb7c2f43", 16),
                Arguments.arguments("AbcdAbcdsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafdffffffffffffffffffd1123", "4d7a4fa17682fe0eba7dea7a996f5320", 16)
        );
    }

    @ParameterizedTest
    @DisplayName("Test MD4 hashing")
    @MethodSource("md4HashingTestValues")
    void testMD4Hashing(String valueToHash, String hexHashedValue, int bytesOutputSize) {
        byte[] hashedValue = MD4Hashing.md4Hashing(valueToHash);
        assertEquals(hexHashedValue, new String(Hex.encodeHex(hashedValue)));
        assertEquals(bytesOutputSize, hashedValue.length);
    }
}
