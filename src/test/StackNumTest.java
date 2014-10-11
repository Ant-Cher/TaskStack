package test;

import main.StackNum;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.NON_EXISTENT;

import static org.junit.Assert.*;
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
        assertEquals(stackNum.min(),5);

    }

    @Test
    public void testMinDifferentValues() throws Exception {

        setStackNumElem(stackNum, 1, 3, 0, 8, -5);
        assertEquals(stackNum.min(),-5);

    }

    @Test
    public void testMinDoubleValues() throws Exception {

        setStackNumElem(stackNum, 1.834, -3.2352, 75, 9., -5.9);
        assertEquals(stackNum.min(),-5.9);

    }

    @Test(expected = ClassCastException.class)
    public void testMinNaN() throws Exception {

        setStackNumElem(stackNum, 1.834,"nan" , 75, 9., -5.9);
        assertEquals(stackNum.min(),-5.9);

    }
    @Test
    public void testMaxEqualValues() throws Exception {

        setStackNumElem(stackNum, 5, 5, 5, 5, 5);
        assertEquals(stackNum.max(),5);

    }

    @Test
    public void testMaxDifferentValues() throws Exception {

        setStackNumElem(stackNum, 1, 3, 0, 8, -5);
        assertEquals(stackNum.max(),8);

    }

    @Test
    public void testMaxDoubleValues() throws Exception {

        setStackNumElem(stackNum, 1.834, -3.2352, 75.9, 9., -5.9);
        assertEquals(stackNum.max(),75.9);

    }

    @Test(expected = ClassCastException.class)
    public void testMaxNaN() throws Exception {

        setStackNumElem(stackNum, 1.834,"nan" , 75, 9., -5.9);
        assertEquals(stackNum.max(),-5.9);

    }
}