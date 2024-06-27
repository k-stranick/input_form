package dtcc.itn261.assignment11;

import java.time.LocalDate;
import java.util.Objects;
// validation logic here instead?
public class FormData {
    private String name;
    private String phone;
    private LocalDate birthday; // Consider using LocalDate for date values
    private String email;
    private String address;
    private String city;
    private String state; // Assuming state is a string e.g., the state's name
    private String zipCode;

    private String notes;

    // No Parameter Constructor
    public FormData() {
    }

    public String getName() {
        return name;
    }

    // Getters and Setters
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;     //!= null) ? birthday : LocalDate.of(1,1,1);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return (!Objects.equals(state, "Select A State")) ? state : "";
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
