package se.lexicon;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for simple SpringApp.
 */
public class SpringAppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldThrowException()
    {
        assertThrows(
                Exception.class, ()-> { throw new Exception(); }
            );
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }
}

