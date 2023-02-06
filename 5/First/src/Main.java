import java.util.*;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */
class PhoneBook {
    public Map<String, String> phones;

    public PhoneBook() {
        phones = new HashMap<>();
    }

    // Делаем метод для красивого вывода:
    StringBuilder getPhoneBook() {
        StringBuilder outStr = new StringBuilder();
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            outStr.append(entry.getValue());
            outStr.append(": ");
            outStr.append(entry.getKey());
            outStr.append("\n");
        }
        return outStr;
    }

    // Т.к. у нас может быть несколько номеров у одного человека, будем хранить ключи-телефоны
    // как строку, номера будут через запятую
    void put(String name, String phone) {
        if (phones.containsKey(phone)) {
            System.out.printf("The number %s is already in Phone Book!\nTry again!\n", phone);
        } else {
            if (phones.containsValue(name)) {
                String newPhones;
                for (Map.Entry<String, String> entry : phones.entrySet()) {
                    if (name.equals(entry.getValue())) {
                        String existing = entry.getKey();
                        newPhones = existing + ", " + phone;
                        phones.remove(existing, name);
                        phones.put(newPhones, name);
                        return;
                    }
                }
            } else{
                phones.put(phone, name);
                System.out.printf("Adding %s, phone: %s successful!\n", name, phone);
            }
        }
    }

    // Тут все просто, просто ищем ключ по значению
    String getPhoneByName(String name) {
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            if (name.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return "Name " + name + " not found!\n";
    }

    // Т.к. ключи-телефоны у нас хранятся как строки, через запятую, то при поиске
    // мы будем разбивать их на массив строк и искать по нему
    String getNameByPhone(String phone) {
        Set<String> key = phones.keySet();
        for (String s : key) {
            String[] phonesArr = s.split(", ");
            for (String value : phonesArr) {
                if (Objects.equals(value, phone)) {
                    return phones.get(s);
                }
            }
        }
        return "Number " + phone + " not found!\n";
    }

    // Тут тоже всё просто: ищем ключ по значению, удаляем, если нашли
    void removeName(String name) {
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            if (name.equals(entry.getValue())) {
                phones.remove(entry.getKey());
                System.out.printf("Removing name %s successful!\n", name);
                return;
            }
        }
        System.out.printf("Name %s not found!\n", name);
    }

    // Удаление номера
    // Тут сложнее, т.к. может быть несколько номеров
    // Будем снова раскладывать (но на этот раз на список) строк и формировать новую строку для записи в качестве ключа
    void removePhone(String phone) {
        Set<String> key = phones.keySet();

        for (String item : key) {
            List<String> phonesList = new ArrayList<>(Arrays.asList(item.split(", ")));
            for (String value : phonesList) {
                if (Objects.equals(value, phone)) {
                    phonesList.remove(phone);
                    String s = String.join(", ", phonesList);
                    String name = phones.get(item);
                    phones.remove(item);
                    phones.put(s, name);
                    System.out.printf("Removing phone %s successful!\n", phone);
                    return;
                }
            }
        }
        System.out.printf("Phone %s not found!\n", phone);
    }


    // Замена номера
    // Аналогичная процедура, что и при удалении номера с небольшими изменениями
    void replacePhone(String oldPhone, String newPhone) {
        Set<String> key = phones.keySet();

        for (String item : key) {
            List<String> phonesList = new ArrayList<>(Arrays.asList(item.split(", ")));
            for (String value : phonesList) {
                if (Objects.equals(value, oldPhone)) {
                    phonesList.remove(oldPhone);
                    phonesList.add(newPhone);
                    String s = String.join(", ", phonesList);
                    String name = phones.get(item);
                    phones.remove(item);
                    phones.put(s, name);
                    System.out.printf("Replacing %s to %s successful!\n", oldPhone, newPhone);
                    return;
                }
            }
        }
        System.out.printf("Phone %s not found!\n", oldPhone);
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.put("Ross", "1");
        newPhoneBook.put("Rachel", "2");
        newPhoneBook.put("Joey", "3");
        newPhoneBook.put("Chandler", "4");
        newPhoneBook.put("Phoebe", "5");
        newPhoneBook.put("Monica", "6");
        newPhoneBook.put("Gunther", "7");
        newPhoneBook.put("Janice", "8");
        newPhoneBook.put("Frank", "9");

        // Попробуем добавить уже существующий номер
        newPhoneBook.put("Richard", "1");
        // Не получилось, вносим с другим номером
        newPhoneBook.put("Richard", "10");
        // Добавим Richard-у еще один номер
        newPhoneBook.put("Richard", "11");

        // Выведем нашу книгу
        System.out.println(newPhoneBook.getPhoneBook());

        // Попробуем получить телефон по существующему имени - успешно:
        System.out.println(newPhoneBook.getPhoneByName("Richard"));
        // Попробуем получить телефон по несуществующему имени - не получится:
        System.out.println(newPhoneBook.getPhoneByName("Jack"));

        // Попробуем получить имя по существующему номеру:
        System.out.println(newPhoneBook.getNameByPhone("10"));
        // Видим, что возвращается имя Richard, даже если у него несколько номеров

        // Попробуем получить имя по несуществующему номеру - не получится:
        System.out.println(newPhoneBook.getNameByPhone("12"));

        // Попробуем удалить все номера по существующему имени - успешно:
        newPhoneBook.removeName("Frank");
        // Выведем книгу, видим, что этого имени и всех его номеров нет:
        System.out.println(newPhoneBook.getPhoneBook());

        // Попробуем удалить у Richard'а только один телефон:
        newPhoneBook.removePhone("10");
        // Выведем книгу, видим, что этого телефона нет, но остался второй:
        System.out.println(newPhoneBook.getPhoneBook());
        // Попробуем удалить у Richard'а этот же телефон - выдастся сообщение, что телефона нет':
        newPhoneBook.removePhone("10");

        // Добавим Richard-у второй номер обратно:
        newPhoneBook.put("Richard", "10");
        // Изменим этот номер:
        newPhoneBook.replacePhone("10", "12");
        // Выведем книгу, видим, что один его номер поменялся:
        System.out.println(newPhoneBook.getPhoneBook());
    }
}