package main;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.lang.Math.*;
/**
 * Created by Aspera on 05.10.2014.
 */
public class Stack< T >  {

    private Strategy strategy;

    protected Deque<T> stack = new ArrayDeque<T>();

    /**
     * Выводит на экран каждый второй элемент стека
     */
    public String EachSecondValue() {
       return EachSecondValue(this.stack);
    }

    public String EachSecondValue(Deque<T> stack){

        String result = "";
        int i = 0;

        for (T t : stack) {
            i++;
            if (i%2==0){
                result += t.toString() + " ";
            }
        }

        return result;
    }

    /**
     * Возвращает сумму символов в стэке
     *
     * @return int
     */
    public int sumOfSymbols () {
        return sumOfSymbols (this.stack);
    }

    public int sumOfSymbols (Deque<T> stack){

        String s1 = "";
        for (T t : stack) {
            String s2 = s1;
            s1 = s2 + t.toString();

        }
        return s1.length();

    }

    public void setStack(Deque<T> stack){
        this.stack = stack;
    }

    public Deque<T> getStack(){
        return this.stack;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void add(T t){
        stack.addLast(t);
    }
    /**
     * Вытаскивает значение элемента из стэка
     */
    public T pop(){
        return (T) strategy.get(stack);
    }

}
