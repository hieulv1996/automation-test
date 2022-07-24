package weekTwo;

public class StudentInformation {
    int no;
    String firstName;
    String lastName;
    String dob;

    public StudentInformation(int no, String firstName, String lastName, String dob) {
        this.no = no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public StudentInformation() {
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
