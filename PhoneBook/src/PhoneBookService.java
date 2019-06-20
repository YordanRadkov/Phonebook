import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class PhoneBookService {

    private static List<PhoneBook> list = new ArrayList<>();

    //Sorts list by the name of the people
    static void sortByName() {
        Comparator<PhoneBook> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        list.sort(byName);
        //print();
    }

    //Prints the list
    static void print() {

        for (PhoneBook o : list) {
            System.out.println(o.getName() + " " + o.getPhoneNumber());
        }
    }

    //Deletes from phoneBook by name
    static void deletePairByName(String name) {

        list.removeIf(phoneBook -> phoneBook.getName().equals(name));
        // print();

    }

    //Adds a new pair in the phoneBook
    static void addNewPair(String name, String phoneNumber) {
        if (checkPhoneNumber(phoneNumber)) {
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.setName(name);
            phoneBook.setPhoneNumber(phoneNumber);
            list.add(phoneBook);
        }
    }

    //Checks the phone number and leaves it the same
    private static boolean checkPhoneNumber(String phone) {
        if (phone.startsWith("0") && phone.length() == 10) {
            phone = phone.replace("0", "+359");
        }

        if (phone.startsWith("00359") && phone.length() == 14) {
            phone = phone.replace("00", "+");
        }

        if (phone.startsWith("+359") && phone.length() == 13) {
            String fourthAndFifthDigit = phone.substring(4, 6);
            if (fourthAndFifthDigit.equals("87") ||
                    fourthAndFifthDigit.equals("88") ||
                    fourthAndFifthDigit.equals("89")) {
                int sixthdigit = Integer.parseInt(phone.substring(6, 7));
                if (sixthdigit > 1 && sixthdigit < 10) {
                    int lastSixDigits = Integer.parseInt(phone.substring(7, 13));
                    return lastSixDigits >= 0 && lastSixDigits <= 999999;
                }
            }
        }
        return false;
    }

    //Searches in the phoneBook by name
    static void searchByName(String name) {
        for (PhoneBook e : list) {
            if (e.getName().equals(name)) {
                System.out.println(e.getName() + " " + e.getPhoneNumber());
            }
        }
    }

    //Checks the phone number and replaces it
    static void checkPhoneNumberAndReplaceIt(PhoneBook phoneBook) {

        if (phoneBook.getPhoneNumber().startsWith("0") && phoneBook.getPhoneNumber().length() == 10) {
            phoneBook.setPhoneNumber(phoneBook.getPhoneNumber().replace("0", "+359"));
        }

        if (phoneBook.getPhoneNumber().startsWith("00359") && phoneBook.getPhoneNumber().length() == 14) {
            phoneBook.setPhoneNumber(phoneBook.getPhoneNumber().replace("00", "+"));
        }

        if (phoneBook.getPhoneNumber().startsWith("+359") && phoneBook.getPhoneNumber().length() == 13) {
            String fourthAndFifthDigit = phoneBook.getPhoneNumber().substring(4, 6);
            if (fourthAndFifthDigit.equals("87") ||
                    fourthAndFifthDigit.equals("88") ||
                    fourthAndFifthDigit.equals("89")) {
                int sixthdigit = Integer.parseInt(phoneBook.getPhoneNumber().substring(6, 7));
                if (sixthdigit > 1 && sixthdigit < 10) {
                    int lastSixDigits = Integer.parseInt(phoneBook.getPhoneNumber().substring(7, 13));
                    if (lastSixDigits >= 0 && lastSixDigits <= 999999) {
                        list.add(phoneBook);
                    }
                }
            }
        }
    }

    //Prints first five persons
    static void printFirstFive() {

        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i).getName() + " " + list.get(i).getPhoneNumber() + " - number of calls: " + list.get(i).getCount());
        }
    }

    //Sorts the list by number of calls
    static void sortByCount() {

        Comparator<PhoneBook> byCount = (o1, o2) -> Integer.compare(o1.getCount(), o2.getCount());
        list.sort(byCount.reversed());

    }

    //Count calls made
    static void countCalls(String name, String phoneNumber) {

        for (PhoneBook e : list) {
            if (e.getName().equals(name) && e.getPhoneNumber().equals(phoneNumber)) {
                e.setCount(e.getCount() + 1);
            }
        }
    }

}

