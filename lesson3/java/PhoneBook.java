import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    /**считаем все телефоны сотовыми т.е. 10 значными, int короткий берём Long*/
    HashMap<String, HashSet<Long>> data = new HashMap<>();

    int add(String name, Long phone) {
        HashSet<Long> book = data.getOrDefault(name, new HashSet<>());
        book.add(phone);
        data.put(name, book);
        return book.size();
    }

    String get(String name) {
        HashSet<Long> book = data.getOrDefault(name, new HashSet<>());
        String res = book.size() == 0 ? "Нет в базе" : "";
        for (Long phoneNum: book) {
            res = String.format("%s\n%s", res,
                    String.valueOf(phoneNum)
                    .replaceFirst("(\\d{3})(\\d{3})(\\d{2})(\\d+)",
                            "+7 ($1) $2-$3-$4"));
        }
        return res;
    }
}
