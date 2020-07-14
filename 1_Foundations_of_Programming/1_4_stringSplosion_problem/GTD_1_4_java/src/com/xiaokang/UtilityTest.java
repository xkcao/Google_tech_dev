package com.xiaokang;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilityTest {

    public UtilityTest() {
    }

    @Test
    public void stringSplosionTest() {
        assertEquals("CCoCodCode", Utility.stringSplosion("Code"));
        assertEquals("aababc",Utility.stringSplosion("abc"));
        assertEquals("aab",Utility.stringSplosion("ab"));
        assertEquals("a",Utility.stringSplosion("a"));
        assertEquals("",Utility.stringSplosion(""));
    }
}