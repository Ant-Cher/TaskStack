package main;

import java.util.Deque;

/**
 * Created by Aspera on 05.10.2014.
 * Стэк, который может работать только с числами
 */
public class StackNum <T extends Number> extends Stack<T> {

    /**
     * Возращает значение минимального элемента стэка,
     * если одинаковых минимальных значений несколько,
     * то метод вернет значение первого минимального элемента.
     *
     * @return Number
     */
    public Number min(){
        Number min = stack.getFirst();
        for (T t : stack){
            if (min.doubleValue() > t.doubleValue()){
                min = t;
            }
        }
        return min;
    }

    /**
     * Возращает значение максимального элемента стэка,
     * если одинаковых максимальных значений несколько,
     * то метод вернет значение первого максимального элемента.
     *
     * @return Number
     */
    public Number max(){
        Number max = stack.getFirst();
        for (T t : stack){
            if (max.doubleValue() < t.doubleValue()){
                max = t;
            }
        }
        return max;
    }

}

