package test;

import main.StackNum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackNumTest {

    private StackNum stackNum;

    private void setStackNumElem(StackNum stackNum, Object...obj){
        for(Object o : obj){
            stackNum.add(o);
        }
    }

    @Before
    public void setUp() throws Exception {
        stackNum = new StackNum();
    }

    @Test
    public void testMinEqualValues() throws Exception {

        setStackNumElem(stackNum, 5, 5, 5, 5, 5);
        assertEquals(5,stackNum.min());

    }

    @Test
    public void testMinDifferentValues() throws Exception {

        setStackNumElem(stackNum, 1, 3, 0, 8, -5);
        assertEquals(-5,stackNum.min());

    }

    @Test
    public void testMinDoubleValues() throws Exception {

        setStackNumElem(stackNum, 1.834, -3.2352, 75, 9., -5.9);
        assertEquals(-5.9,stackNum.min());

    }

    @Test(expected = ClassCastException.class)
    public void testMinNaN() throws Exception {

        setStackNumElem(stackNum, 1.834,"nan" , 75, 9., -5.9);
        assertEquals(-5.9,stackNum.min());

    }
    @Test
    public void testMaxEqualValues() throws Exception {

        setStackNumElem(stackNum, 5, 5, 5, 5, 5);
        assertEquals(5,stackNum.max());

    }

    @Test
    public void testMaxDifferentValues() throws Exception {

        setStackNumElem(stackNum, 1, 3, 0, 8, -5);
        assertEquals(8,stackNum.max());

    }

    @Test
    public void testMaxDoubleValues() throws Exception {

        setStackNumElem(stackNum, 1.834, -3.2352, 75.9, 9., -5.9);
        assertEquals(75.9,stackNum.max());

    }

    @Test(expected = ClassCastException.class)
    public void testMaxNaN() throws Exception {

        setStackNumElem(stackNum, 1.834,"nan" , 75, 9., -5.9);
        assertEquals(-5.9,stackNum.max());

    }
}