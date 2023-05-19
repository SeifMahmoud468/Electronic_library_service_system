package Classes;

import java.util.Date;

public class Student {
    private String Id,name, password, email, address, city, contact;
    private String IssuedBooks[] = new String[3];
    public int booknumbers=0;
    Date[] IssuedDate= new Date[3];

    public Student(String Id, String name, String password, String email, String address, String city, String contact) {
        this.Id = Id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact = contact;
    }
    public void setbook(String callnumber)
    {
        this.IssuedBooks[booknumbers]=callnumber;
    }
    public String[] getbooks()
    {
        return IssuedBooks;
    }
    public String getId() {
        return Id;
    }

    public void setDate(Date date){
        this.IssuedDate[booknumbers]=date;
    }
    public Date[] getdate()
    {
        return IssuedDate;
    }
    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
}