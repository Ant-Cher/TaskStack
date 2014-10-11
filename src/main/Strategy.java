package main;

import java.util.Deque;

/**
 * Created by Aspera on 05.10.2014.
 */
public interface Strategy <T> {

    public T get(Deque<T> stack);

}
