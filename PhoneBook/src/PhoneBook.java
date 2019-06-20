class PhoneBook {

    private String name;
    private String phoneNumber;
    private int count;

    PhoneBook(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    PhoneBook() {
    }

    int getCount() {
        return count;
    }

    void setCount(int count) {
        this.count = count;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


