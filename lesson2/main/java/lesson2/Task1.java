package lesson2;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Random;

public class Task1 {

    private static final int ARRAY_SIZE = 4;
    private static final String DEF_VAL = "0";
    private static final Random random = new Random();



    static String[][] genArray() {
        String[] datas = {"0", "1", "2", "3", "4",
                          "5", "6", "7", "8", "9",
                          "r", "t", "y", "u", "i"};
        String[][] res = new String[3 + random.nextInt(2)][];;
        for (int i = 0; i < res.length; i++) {
            res[i] = new String[3 + random.nextInt(2)];
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = datas[random.nextInt(datas.length)];
            }
            System.out.println(Arrays.toString(res[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        String[][] arr = genArray();

        try {
            /*ошибку размера только фиксируем,
             тк в дальнейшем алгоритме учитываем вариативность размеров массима*/
            checkSize(arr);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        try {
            /**ошибки данных исправляем на значение по умолчанию @DEF_VAL
             * тк в дальнейшем не ловим исключений при Integer.parseInt() */
            checkValues(arr, true);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println("============================\n\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        System.out.println(System.out.printf("Сумма элементов массива = %d\n",  summValues(arr)));
    }


    static void checkSize(String[][] inArr) throws MyArraySizeException {
        if (inArr.length != ARRAY_SIZE) {
            throw new MyArraySizeException(-1);
        }
        for (int i = 0; i < inArr.length; i++) {
            if (inArr[i].length != ARRAY_SIZE)
                throw new MyArraySizeException(i);
        }
        System.out.println("Размерность массива соответсвует требованиям");
    }

    static void checkValues(String[][] inArr, boolean isCorrect) throws MyArrayDataException {
        for (int i = 0; i < inArr.length; i++) {
            for (int j = 0; j < inArr[i].length; j++) {
                try {
                    Integer.parseInt(inArr[i][j]);
                } catch (Exception e) {
                    //фиксируем, исправляем и запускаем рекурсию
                    String s = inArr[i][j];
                    inArr[i][j] = DEF_VAL;
                    try {
                        checkValues(inArr, false);
                    } catch (MyArrayDataException einn) {
                        einn.printStackTrace();
                    }
                    throw new MyArrayDataException(i, j, s);
                }
            }
        }
        if (isCorrect) System.out.println("Данные массива соответсвуют требованиям");
    }


    static int summValues(String[][] inArr) {
        int res = 0;
        for (int i = 0; i < inArr.length; i++) {
            for (int j = 0; j < inArr[i].length; j++) {
                res += Integer.parseInt(inArr[i][j]);
            }
        }
        return res;
    }
}
