import java.io.*;

class WriteToFile {

    private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter("phoneBook.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void whenWriteStringUsingBufferedWriter_thenCorrect(String name, String phoneNumber)
            throws IOException {

        PhoneBook phoneBook = new PhoneBook(name, phoneNumber);
        writer.write(phoneBook.getName() + ", " + phoneBook.getPhoneNumber());
        //writer.write(name + ", " + phoneNumber);
        writer.newLine();
    }

    static void closeWriter() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

