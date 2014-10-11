package main;

import java.util.Deque;

/**
 * Created by Aspera on 05.10.2014.
 * Реализация FIFO
 */
public class Fifo<T> implements Strategy<T> {

    public T get(Deque<T> stack){
        return stack.pollFirst();
    }
}
