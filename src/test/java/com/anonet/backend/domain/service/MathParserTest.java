package com.anonet.backend.domain.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathParserTest {
    @Test
    void shouldSolveSimpleAddition(){
        MathParser parser = new MathParser();

        double result = parser.evaluate("10 + 5");

        assertEquals(15.0, result);
    }
}
