package com.snc.sharenote;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class Algorithm0218 {
    @Mock
    Number13460 number13460;

    @Mock
    Number2667 number2667;

    @Before
    public void setUp() {
        number13460 = new Number13460();
        number2667 = new Number2667();
    }

    @Test
    public void test_backjoon_13460() {
        try {
            number13460.test();

            assertEquals(4, 2 + 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_backjoon_2667() {
        try {
            File problemFile = getFileFromPath(this,"Pnumber2667.txt");
            number2667.test(problemFile);

            assertEquals(4, 2 + 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFileFromPath(Object obj, String fileName) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        return new File(resource.getPath());
    }
}
