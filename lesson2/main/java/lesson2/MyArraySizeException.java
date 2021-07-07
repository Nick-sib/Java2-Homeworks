package lesson2;

public class MyArraySizeException extends Exception {

    int position;

    public MyArraySizeException(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        if (position == -1)
            return "MyArraySizeException {in columns count}";
        else
            return String.format("MyArraySizeException {in row = %d}", position);
    }
}
