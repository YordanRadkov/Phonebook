import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ReadFromFile {

    private BufferedReader br;

    {
        try {
            br = new BufferedReader(new FileReader("phoneBook.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void readFromFile() throws IOException {
        String st;
        while ((st = br.readLine()) != null) {
            String[] array = st.split(", ");
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.setName(array[0]);
            phoneBook.setPhoneNumber(array[1]);
            PhoneBookService.checkPhoneNumberAndReplaceIt(phoneBook);
        }
    }
}

