package com.popcristianvlad.security.hashing;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhirlpoolHashingTest {

    private static Stream<Arguments> whirlpoolHashingTestValues() {
        return Stream.of(
                Arguments.arguments("AbcdAbcd11", "578ec49f7319876460ade31e47dfd5aa4975b536dc5d16f2e612c514bfb80147898e77bc06d724088ba8b1137149282c4a0829816f644b6d0378e931ee1270f7", 64),
                Arguments.arguments("AbcdAbcd12", "d1716a85fa520ea387c797b77cb75d561298cfd2dbcbec233f7a32d84872431c8bfe09df037566fa6de14578d14d217e9d7a1a125d83070ddfb9f03f902fd014", 64),
                Arguments.arguments("AbcdAbcd1123", "73df244e1b21abf85036b3a6719425cc18afc6267f2e14cbf4b07c3b3541e5e08dc767165506fc4e755d001af959f43c9d11d138bf9150b4676aec81d43584f5", 64),
                Arguments.arguments("AbcdAbcdsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafdffffffffffffffffffd1123", "1dcd06c1fe288ce11509230ee2e982e1575effeecbdc9667c5a3287ec3a85da151920efe521fd3f607164cea883bd6f0f1adc37cd4063e9c27cece7f9b25cc00", 64)
        );
    }

    @ParameterizedTest
    @DisplayName("Test Whirlpool hashing")
    @MethodSource("whirlpoolHashingTestValues")
    void testWhirlpoolHashing(String valueToHash, String hexHashedValue, int bytesOutputSize) {
        byte[] hashedValue = WhirlpoolHashing.whirlpoolHashing(valueToHash);
        assertEquals(hexHashedValue, new String(Hex.encodeHex(hashedValue)));
        assertEquals(bytesOutputSize, hashedValue.length);
    }
}
