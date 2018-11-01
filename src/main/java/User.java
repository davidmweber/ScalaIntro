import java.util.Objects;

public class User {
    String firstName;
    String surname;
    String address;
    int age;
    String email;

    public User(String firstName, String surname, String address, int age, String email) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSurname(), getAddress(), getAge(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}


