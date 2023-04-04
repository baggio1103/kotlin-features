package classes.generics.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        var source = new Source<>("() -> {}");
//        System.out.println(source.nextValue());
        demo(new Source<>("fasd"));
        demo(new Source<>(Integer.bitCount(2)));
    }

    public static void demo(Source<? extends Animal> newSource) {
        System.out.println(newSource.nextValue());
       var animal =  newSource.nextValue();
       Source<Object> source = (Source<Object>) newSource;
        System.out.println(source.nextValue());

    }


}

class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }
}
