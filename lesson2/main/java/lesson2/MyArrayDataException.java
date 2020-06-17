package lesson2;

public class MyArrayDataException extends Throwable {
    int i;
    int j;
    String value;

    public MyArrayDataException(int i, int j, String value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(
                "MyArrayDataException {in CELL address [%d, %d] = %s, isn't numeric value}",
                i,
                j,
                value);
    }
}
