package main;

import java.util.Deque;

/**
 * Created by Aspera on 05.10.2014.
 * Реализация LIFO
 */
public class Lifo<T> implements Strategy<T>{

    public T get(Deque<T> stack){
        return stack.pollLast();
    }

}
