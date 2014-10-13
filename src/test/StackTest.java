package test;

import main.Fifo;
import main.Lifo;
import main.Stack;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;


public class StackTest {

    private Stack stack;
    private Fifo fifo = new Fifo();
    private Lifo lifo = new Lifo();
    private static Deque<Integer> dequeInteger = new ArrayDeque<Integer>();
    private static Deque<Double> dequeDouble = new ArrayDeque<Double>();
    private static Deque<String> dequeString = new ArrayDeque<String>();

    private void setDequeInt(Stack stack,int a){    // Этот метод нужен для того,
        for (int i = 0; i<a ;i++) {                 // чтобы не дублировать код при проверке метода pop().
            stack.add(i);
        }
    }


    @BeforeClass
    public static void setUpBe() throws Exception {

        for (int i = 0; i<100 ;i++){

            dequeInteger.add(i);    //190 символов
            dequeDouble.add(1.);    //300 символов
            dequeString.add("Hi!"); //300 символов

        }

    }

    @Before
    public void setUp() throws Exception {

        this.stack = new Stack();

    }

    @Test
    public void testPrintEachSecond() throws Exception {

        setDequeInt(stack,6);
        assertEquals("1 3 5 ",stack.EachSecondValue(stack.getStack()));

    }

    @Test
    public void testSumOfSymbolsInteger() throws Exception {

        assertEquals(190,stack.sumOfSymbols(dequeInteger));

    }

    @Test
    public void testSumOfSymbolsDouble() throws Exception {

        assertEquals(300,stack.sumOfSymbols(dequeDouble));

    }

    @Test
    public void testSumOfSymbolsString() throws Exception {
        assertEquals(300,stack.sumOfSymbols(dequeString));


    }

    @Test
    public void testSetGetStack() throws Exception {

        stack.setStack(dequeString);
        assertEquals(dequeString,stack.getStack());

    }

    @Test
    public void testSetGetStrategyFifo() throws Exception {

        stack.setStrategy(fifo);
        assertEquals(fifo,stack.getStrategy());

    }

    @Test
    public void testSetGetStrategyNull() throws Exception {

        assertEquals(null,stack.getStrategy());

    }

    @Test
    public void testAdd() throws Exception {

        stack.setStrategy(fifo);
        stack.add("T");
        assertEquals("T",stack.pop());

    }

    @Test (expected = NullPointerException.class)
    public void testPopWithoutStrategy() throws Exception {

        stack.setStack(dequeString);
        assertEquals(0,stack.pop());

    }

    @Test
    public void testPopFifo() throws Exception {

        setDequeInt(stack,100);

        stack.setStrategy(fifo);

        assertEquals(0, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());

    }

    @Test
    public void testPopLifo() throws Exception {

        setDequeInt(stack,100);

        stack.setStrategy(lifo);

        assertEquals(99, stack.pop());
        assertEquals(99, stack.pop());
        assertEquals(99, stack.pop());

    }

}