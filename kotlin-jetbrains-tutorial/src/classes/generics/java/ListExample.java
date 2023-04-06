package classes.generics.java;

import examples.controlFlow.Animal;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<? super String> list = new ArrayList<>();
        list.add("Hello");
        var value = list.get(0);
        System.out.println(value);
        fill(list, "baggio");
        System.out.println(list);
        var newList = new ArrayList<>();
        newList.add(new Animal("richie"));
        System.out.println();
        fill(newList, "NewList");
        System.out.println(newList);
        var animals = (List.of(new Animal("")));
        var words = new ArrayList<>(List.of("hello", "world"));
        fill(words, "!");
        fill(new ArrayList<>((List.of(new Animal("")))), "");
    }

    public static void fill(List list, String value) {
        list.add(value);
    }

}
