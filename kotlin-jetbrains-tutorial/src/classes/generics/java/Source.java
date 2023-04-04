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

}
