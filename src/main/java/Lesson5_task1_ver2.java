import java.util.Arrays;


/**Массив для каждого этапа создается новый, плюс посмотрю варианта без разрезвния массива (2 потока массив один)
 * Просто из любопытства добавлю проверку в конце что массивы идентичны
 * */
public class Lesson5_task1_ver2 {
    static final int SIZE = 10_000_000;
    static final int H = SIZE / 2;


    public static void main(String[] args) {
//этап 1
        float[] arr1 = new float[SIZE];
        Arrays.fill(arr1, 1);

        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);

//этап 2
        float[] arr2 = new float[SIZE];
        Arrays.fill(arr2, 1);
        float[] a1 = new float[H];
        float[] a2 = new float[H];

        a = System.currentTimeMillis();
        System.arraycopy(arr2, 0, a1, 0, H);
        System.arraycopy(arr2, H, a2, 0, H);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < H; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < H; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i + H) / 5) * Math.cos(0.2f + (i + H) / 5) * Math.cos(0.4f + (i + H) / 2));
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr2, 0, H);
        System.arraycopy(a2, 0, arr2, H, H);
        System.out.println(System.currentTimeMillis() - a);

//этап 3
        float[] arr3 = new float[SIZE];
        Arrays.fill(arr3, 1);

        a = System.currentTimeMillis();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < H; i++) {
                arr3[i] = (float)(arr3[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t3.start();

        Thread t4 = new Thread(() -> {
            for (int i = H; i < SIZE; i++) {
                arr3[i] = (float)(arr3[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - a);

//у меня получилось что массив так как не передается внутрь Thread класса, а берётся как внешний ресурс,
//то его можно не разрезать
        for (int i = 0; i < SIZE; i++) {
            if (arr1[i] != arr2[i] || arr2[i] != arr3[i]) {
                System.out.println("ERROR");
                break;
            }
        }
        
    }
}
