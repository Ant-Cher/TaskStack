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
        for (int i = 0; i<a ;i++) {                 // чтобы не дублировать код при проверки метода pop().
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
        assertEquals(stack.EachSecondValue(stack.getStack()),"1 3 5 ");

    }

    @Test
    public void testSumOfSymbolsInteger() throws Exception {

        assertEquals(stack.sumOfSymbols(dequeInteger), 190);

    }

    @Test
    public void testSumOfSymbolsDouble() throws Exception {

        assertEquals(stack.sumOfSymbols(dequeDouble), 300);

    }

    @Test
    public void testSumOfSymbolsString() throws Exception {
        assertEquals(stack.sumOfSymbols(dequeString),300);


    }

    @Test
    public void testSetGetStack() throws Exception {

        stack.setStack(dequeString);
        assertEquals(stack.getStack(),dequeString);

    }

    @Test
    public void testSetGetStrategyFifo() throws Exception {

        stack.setStrategy(fifo);
        assertEquals(stack.getStrategy(), fifo);

    }

    @Test
    public void testSetGetStrategyNull() throws Exception {

        assertEquals(stack.getStrategy(), null);

    }

    @Test
    public void testAdd() throws Exception {

        stack.setStrategy(fifo);
        stack.add("T");
        assertEquals(stack.pop(), "T");

    }

    @Test (expected = NullPointerException.class)
    public void testPopWithoutStrategy() throws Exception {

        stack.setStack(dequeString);
        assertEquals(stack.pop(), 0);

    }

    @Test
    public void testPopFifo() throws Exception {

        setDequeInt(stack,100);

        stack.setStrategy(fifo);

        assertEquals(stack.pop(), 0);
        assertEquals(stack.pop(), 1);
        assertEquals(stack.pop(), 2);

    }

    @Test
    public void testPopLifo() throws Exception {

        setDequeInt(stack,100);

        stack.setStrategy(lifo);

        assertEquals(stack.pop(), 99);
        assertEquals(stack.pop(), 98);
        assertEquals(stack.pop(), 97);

    }

}