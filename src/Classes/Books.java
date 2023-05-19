package Classes;

import java.util.Date;

public class Books {
    private  String callnumber, name, auther, publisher;
    int quanitiy,Issued;
    Date Date;

    public void setQuanitiy(int quanitiy) {
        this.quanitiy = quanitiy;
    }

    public void setIssued(int Issued) {
        this.Issued = Issued;
    }

    public Books( String callnumber, String name, String auther, String publisher,int quanitiy,int Issued,Date date) {
        this.callnumber = callnumber;
        this.name = name;
        this.auther = auther;
        this.publisher = publisher;
        this.quanitiy = quanitiy;
        this.Issued=Issued;
        this.Date=date;
    }

    public int getIssued() {
        return Issued;
    }

    public Date getDate() {
        return Date;
    }
    public String getCallnumber() {
        return callnumber;
    }

    public String getName() {
        return name;
    }

    public String getAuther() {
        return auther;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuanitiy() {
        return quanitiy;
    }
    
}
