import java.util.HashMap;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Random random = new Random();

        //Task1
        String[] arr = {"Создать", "массив", "набором", "слов", "среди", "которых", "должны",
                "встречаться", "повторяющиеся"};
        HashMap<String, Integer> task1 = new HashMap<>();

        int count = 10 + random.nextInt(10);
        for (int i = 0; i < count; i++) {
            String val = arr[random.nextInt(arr.length)];
            task1.put(val, task1.getOrDefault(val,0) + 1 );
        }
        System.out.println(task1);


        //Task2
        System.out.println("");
        String[] arrNames = {"Анастасия", "Мария", "Дарья", "Анна", "Елизавета", "Александр", "Максим", "Иван", "Артем", "Дмитрий"};
        Long[] arrPhones  = {7309016891L, 5617558509L, 7855955546L, 6724412061L, 6602987533L, 7610512583L,
                9050880655L, 8618243479L, 1869179959L, 4209237581L, 2628530846L, 3455919803L, 9224067051L,
                9049918712L, 3600881409L, 4515165242L, 7455644884L, 5334917441L, 8712709247L, 9465921423L};

        PhoneBook phoneBook = new PhoneBook();
        for (Long phone: arrPhones) {
            phoneBook.add(arrNames[random.nextInt(arrNames.length)], phone);
        }

        String val = arrNames[random.nextInt(arrNames.length)];
        System.out.printf("%s: %s ", val, phoneBook.get(val));
    }

}
