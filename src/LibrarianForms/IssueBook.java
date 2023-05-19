package LibrarianForms;

import AdminForms.AddLibrarian;
import AdminForms.AdminLogin;
import Classes.Books;
import Classes.IssuedBooks;
import Classes.Student;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.isLetter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class IssueBook extends javax.swing.JFrame {
    Boolean Studentcheck=false,callnocheck=false,issuecheck=true;
    IssuedBooks[] IBooks = new IssuedBooks[100];
    Books[] Books = new Books[100];
    Student[] Students = new Student[100];
    Boolean Error, test = false,leo=false;
    int found, foundStudent = 0;
    int StudentIndex;
    Date Date;
    int counterbooks, counterIssuse, counterStudents;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public IssueBook() throws ParseException, FileNotFoundException {
        initComponents();
    }

    private void ReadStudentFile() {
        int i = 0;
        try {
            File file = new File("Student.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String tokens[] = line.split(",");
                Students[i] = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
                i++;
            }

            counterStudents = i;
            String id = ID.getText();

            StudentIndex = 0;
            for (int j = 0; j < counterStudents; j++) {
                if (id.equals(Students[j].getId())) {
                    StudentIndex = j;
                    Studentcheck = true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReadBooksFile() throws ParseException {
        int i = 0;
        try {
            
            File file = new File("Books.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String tokens[] = line.split(",");
                int q = Integer.parseInt(tokens[4]);
                int issued = Integer.parseInt(tokens[5]);
                Date = format.parse(tokens[6]);
                Books[i] = new Books(tokens[0], tokens[1], tokens[2], tokens[3], q, issued, Date);
                i++;
            }
            counterbooks = i;
            String callno = BookNo.getText();
            for (int j = 0; j < counterbooks; j++) {
                if (callno.equals(Books[j].getCallnumber())) {
                    found = j;
                    callnocheck=true;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReadFileIssued() throws FileNotFoundException, ParseException {
        File file = new File("IssuedBooks.txt");
        String id = ID.getText();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String tokens[] = line.split(",");
            Date = format.parse(tokens[4]);
            IBooks[counterIssuse] = new IssuedBooks(tokens[0], tokens[1], tokens[2], tokens[3], Date);
            counterIssuse++;
            foundStudent = 0;
            for (int i = 0; i < counterIssuse; i++) {
                if (id.equals(IBooks[i].getId())) {
                    foundStudent++;
                }

            }
        }
    }

    private void IdValidation() {
        Error = false;
        String id = ID.getText();
        for (int i = 1; i < id.length(); i++) {
            if (isLetter(id.charAt(i))) {
                ID.setText("");
                ID.grabFocus();
                Name.setText("");
                Contact.setText("");
                JOptionPane.showMessageDialog(this, "Invalied Id", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                return;
            }
        }

    } 
    private void IssueCheck() throws FileNotFoundException, ParseException {
        ReadStudentFile();
        ReadBooksFile();
        ReadFileIssued();
        Name.setText(Students[StudentIndex].getName());
        Contact.setText(Students[StudentIndex].getContact());
        if (foundStudent >= 3) {
            Error = false;
            ID.setText("");
            ID.grabFocus();
            Name.setText("");
            Contact.setText("");
            JOptionPane.showMessageDialog(this, "Student has reached the maximum number of issued books", "Error", JOptionPane.ERROR_MESSAGE);
            issuecheck =false;
        }
       
    }

    private void writefile() throws IOException {
        FileWriter file = new FileWriter("IssuedBooks.txt", true);
        BufferedWriter bw = new BufferedWriter(file);
        try (PrintWriter printer = new PrintWriter(file)) {
            String id = ID.getText();
            String callnumber = BookNo.getText();
            String name = Name.getText();
            String contact = Contact.getText();
            String date;
            Date = new Date(System.currentTimeMillis());
            date = format.format(Date);
            printer.println(id + "," + callnumber + "," + name + "," + contact + "," + date);
            printer.close();

        }
    }
private boolean AddBooks() {
        try {
            File file = new File("Books.txt");
            
            try (PrintWriter printer = new PrintWriter(file)) {
                
                for (int i = 0; i < counterbooks; i++) {
                    
                    Date=Books[i].getDate();
                    printer.print(Books[i].getCallnumber() + "," +Books[i].getName()+","+Books[i].getPublisher()+ ","  +Books[i].getAuther()+ "," +
                            Books[i].getQuanitiy()+","+Books[i].getIssued()+ ","+format.format(Date)+"\n");
                }
            }

            return true;

        }
catch (IOException ex) {
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
}
    
    private boolean Bookediting() throws FileNotFoundException {
        if (Books[found].getQuanitiy() == 0) {
            BookNo.setText("");
            BookNo.grabFocus();
            JOptionPane.showMessageDialog(this, "There's no books left to issue", "Error", JOptionPane.ERROR_MESSAGE);
            Error = false;
        } 
        else {
            int quantity = Books[found].getQuanitiy();
            int issue = Books[found].getIssued();
            Books[found].setQuanitiy(quantity-1);
            Books[found].setIssued(issue+1);
            Error = true;
            AddBooks();
        }
        return Error;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        BookNo = new javax.swing.JTextField();
        Issued = new javax.swing.JButton();
        Name = new javax.swing.JLabel();
        Contact = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 250));

        jLabel2.setText("Student Name:");

        jLabel3.setText("Student ID:");

        jLabel4.setText("Student Contact:");

        jLabel5.setText("Book Call No.");

        ID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IDFocusLost(evt);
            }
        });
        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IDKeyPressed(evt);
            }
        });

        BookNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BookNoFocusLost(evt);
            }
        });

        Issued.setText("Issued");
        Issued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssuedActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel1.setText("Issue Book");

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Issued, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(BookNo)
                    .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(BookNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(Contact, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(Issued))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssuedActionPerformed
                                         
          
           
            try {
                if (Studentcheck==true&&callnocheck==true&&issuecheck==true)
                {
                    ReadFileIssued();
                    Bookediting();
                    writefile();
                    JOptionPane.showMessageDialog(this, "Book is Issued");
                    this.hide();
                    LibrarianSection back = new LibrarianSection();
                    back.setVisible(true);
                    
                }
                else
                    JOptionPane.showMessageDialog(this, "Call no/Student Id is invalid");
                
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException | IOException ex) {
                Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_IssuedActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        LibrarianSection section = new LibrarianSection();
        section.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BackActionPerformed

    private void IDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDFocusLost
        try {
            IdValidation();
            IssueCheck();
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }//GEN-LAST:event_IDFocusLost
    private void IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyPressed
        int Key = evt.getKeyCode();
        if (Key == KeyEvent.VK_ENTER) {
            try {
                IdValidation();
                IssueCheck();
            } catch (FileNotFoundException | ParseException ex) {
                Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_IDKeyPressed
    private void BookNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BookNoFocusLost
        try {
            // TODO add your handling code here:
            ReadBooksFile();
        } catch (ParseException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BookNoFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField BookNo;
    private javax.swing.JLabel Contact;
    private javax.swing.JTextField ID;
    private javax.swing.JButton Issued;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}
