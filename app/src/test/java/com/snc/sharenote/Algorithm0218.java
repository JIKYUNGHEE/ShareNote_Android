package com.snc.sharenote;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Algorithm0218 {
    @Mock
    Marble13460 marble;

    @Before
    public void setUp() {
         marble = new Marble13460();
    }

    @Test
    public void test_backjoon_13460() {
        try {
            marble.test();

            assertEquals(4, 2 + 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
