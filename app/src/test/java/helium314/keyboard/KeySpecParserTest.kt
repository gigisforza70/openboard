package helium314.keyboard

import helium314.keyboard.keyboard.internal.KeySpecParser
import helium314.keyboard.latin.common.Constants
import org.junit.Assert.assertEquals
import org.junit.Test

class KeySpecParserTest {
    @Test fun label() {
        assertEquals("a", KeySpecParser.getLabel("a"))
        assertEquals("a", KeySpecParser.getLabel("a|b"))
        assertEquals("hey", KeySpecParser.getLabel("hey|there"))
        assertEquals("a|b", KeySpecParser.getLabel("a|b|c"))
        assertEquals("a|b", KeySpecParser.getLabel("a\\|b"))
        assertEquals("a|b", KeySpecParser.getLabel("a\\|b|c"))
        assertEquals("a|b|c", KeySpecParser.getLabel("a\\|b|c|d"))
    }

    @Test fun code() {
        assertEquals('a'.code, KeySpecParser.getCode("a"))
        assertEquals('b'.code, KeySpecParser.getCode("a|b"))
        assertEquals(Constants.CODE_OUTPUT_TEXT, KeySpecParser.getCode("hey|there"))
        assertEquals('c'.code, KeySpecParser.getCode("a|b|c"))
        assertEquals(Constants.CODE_OUTPUT_TEXT, KeySpecParser.getCode("a\\|b"))
        assertEquals('c'.code, KeySpecParser.getCode("a\\|b|c"))
        assertEquals('d'.code, KeySpecParser.getCode("a\\|b|c|d"))
    }
}
