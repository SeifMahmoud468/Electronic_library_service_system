/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;



import java.util.Date;

public class IssuedBooks {
    private String Id;
    private  String Name;
    private String Callnumber;
    private String contactNumber; 
    private Date IssuedDate;

    public IssuedBooks(String Id,String Callnumber , String Name, String contactNumber, Date IssuedDate) {
        this.Id = Id;
        this.Name = Name;
        this.Callnumber = Callnumber;
        this.contactNumber = contactNumber;
        this.IssuedDate = IssuedDate;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCallnumber() {
        return Callnumber;
    }

    public void setCallnumber(String Callnumber) {
        this.Callnumber = Callnumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getIssuedDate() {
        return IssuedDate;
    }

    public void setIssuedDate(Date IssuedDate) {
        this.IssuedDate = IssuedDate;
    }



 
    

}
