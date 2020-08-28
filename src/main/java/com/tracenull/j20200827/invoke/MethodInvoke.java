package com.tracenull.j20200827.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * https://blog.csdn.net/wenyuan65/article/details/81145900
 */
public class MethodInvoke {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method animalMethod = Animal.class.getDeclaredMethod("print");
        Method catMethod = Cat.class.getDeclaredMethod("print");

        Animal animal = new Animal();
        Cat cat = new Cat();

        animalMethod.invoke(cat);
        animalMethod.invoke(animal);

        catMethod.invoke(cat);
        catMethod.invoke(animal);
    }
}


class Animal {

    public void print() {
        System.out.println("Animal.print()");
    }

}

class Cat extends Animal {

    @Override
    public void print() {
        System.out.println("Cat.print()");
    }
}
