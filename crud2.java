package MyWindowPackage;

public class crud {

    public static void main(String[] args) {
        // Launch the JFrame
        grud frame = new grud();
        frame.setVisible(true);
    }
}

class BarangayRequest {

    int id;
    String name;
    String address;
    String sex;
    String age;
    String occupation;
    String purpose;
    String status;

    public BarangayRequest(int id, String name, String address, String sex,
                            String age, String occupation, String purpose, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.age = age;
        this.occupation = occupation;
        this.purpose = purpose;
        this.status = status;
    }
}
