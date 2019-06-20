import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {

        // Insert pairs in the file
        try {
            WriteToFile.whenWriteStringUsingBufferedWriter_thenCorrect("Yordan", "+359896711271");
            WriteToFile.whenWriteStringUsingBufferedWriter_thenCorrect("Ivan", "00359896711272");
            WriteToFile.whenWriteStringUsingBufferedWriter_thenCorrect("Petko", "0896711273");
            WriteToFile.whenWriteStringUsingBufferedWriter_thenCorrect("Katia", "0887777777");
            WriteToFile.whenWriteStringUsingBufferedWriter_thenCorrect("Yordan", "+359896711277");
        } finally {
            WriteToFile.closeWriter();
        }

        ReadFromFile read = new ReadFromFile();
        //read correct pairs from the file
        read.readFromFile();

        System.out.println("Print the correct pairs");
        PhoneBookService.print();

        PhoneBookService.addNewPair("Zlatko", "00359896111111");
        PhoneBookService.addNewPair("Ani", "00359896222222");
        // wrong phoneNumber
        PhoneBookService.addNewPair("Ana", "0000359896222222");

        System.out.println();
        System.out.println("After deleted");
        PhoneBookService.deletePairByName("Petko");
        PhoneBookService.print();

        System.out.println("\n" + "Find byName");
        PhoneBookService.searchByName("Ivan");

        System.out.println("\n" + "Sorted by name");
        PhoneBookService.sortByName();
        PhoneBookService.print();

        System.out.println("\n" + "Ordered by call");
        PhoneBookService.countCalls("Yordan", "+359896711271");
        PhoneBookService.countCalls("Yordan", "+359896711271");
        PhoneBookService.countCalls("Yordan", "+359896711271");
        PhoneBookService.countCalls("Yordan", "+359896711271");
        PhoneBookService.countCalls("Yordan", "+359896711271");

        PhoneBookService.countCalls("Zlatko", "00359896111111");
        PhoneBookService.countCalls("Zlatko", "00359896111111");

        PhoneBookService.countCalls("Ani", "00359896222222");
        PhoneBookService.countCalls("Ani", "00359896222222");
        PhoneBookService.countCalls("Ani", "00359896222222");
        PhoneBookService.countCalls("Ani", "00359896222222");

        PhoneBookService.countCalls("Ivan", "+359896711272");

        PhoneBookService.countCalls("Katia", "+359887777777");
        PhoneBookService.countCalls("Katia", "+359887777777");
        PhoneBookService.countCalls("Katia", "+359887777777");

        PhoneBookService.sortByCount();
        PhoneBookService.printFirstFive();
    }
}
