import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void addContact(HashMap<String, ArrayList<String>> phoneBook, String name, String phone) {

        if (phoneBook.containsKey(name)) {
            ArrayList<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }

    public static void printPhoneBook(HashMap<String, ArrayList<String>> phoneBook) {

        ArrayList<Map.Entry<String, ArrayList<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            String name = entry.getKey();
            ArrayList<String> phones = entry.getValue();
            System.out.println(name);
            for (String phone : phones) {
                System.out.println(phone);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Контакт1", "111");
        addContact(phoneBook, "Контакт2", "222");
        addContact(phoneBook, "Контакт3", "333");
        addContact(phoneBook, "Контакт1", "444");
        addContact(phoneBook, "Контакт1", "555");
        addContact(phoneBook, "Контакт3", "666");

        printPhoneBook(phoneBook);
    }
}