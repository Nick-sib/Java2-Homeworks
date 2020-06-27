import java.util.Arrays;

public class Lesson5_task1 {

    static final int SIZE = 10_000_000;
    static final int H = SIZE / 2;


    public static void main(String[] args) {
//этап 1
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);

//этап 2
        Arrays.fill(arr, 1);//для большей идентичности сбрасываем все значения
        float[] a1 = new float[H];
        float[] a2 = new float[H];

        a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);

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

        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);
        System.out.println(System.currentTimeMillis() - a);

    }

}
