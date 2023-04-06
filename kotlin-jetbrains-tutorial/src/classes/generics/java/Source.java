package classes.generics.java;

public class Source<T> {

    private T value;

    public Source(T value) {
        this.value = value;
    }

    public T nextValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

//    public static void main(String[] args) {
//        show(new Source<>(1.12131));
//    }
//
//    public static <T extends Number> void show(Source<T> x) {
//        Source<Double> y = x; // This is completely safe since Double is a subtype of Number
//    }

}
