package LibrarianForms;

import Classes.Books;
import Classes.IssuedBooks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ReturnBook extends javax.swing.JFrame {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date Date;
    int counterIssuse, Bookfound, IDfound;
    IssuedBooks[] s = new IssuedBooks[100];
    Books[] Books = new Books[100];
    int counter;
    private void ReadFileIssued() throws FileNotFoundException, ParseException {
        File file = new File("IssuedBooks.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String tokens[] = line.split(",");
            Date = format.parse(tokens[4]);
            s[counterIssuse] = new IssuedBooks(tokens[0], tokens[1], tokens[2], tokens[3], Date);
            counterIssuse++;
        }
    }
    private void ReadFile() throws FileNotFoundException, ParseException {
        int i = 0;
        File file = new File("Books.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String tokens[] = line.split(",");
            int q = Integer.parseInt(tokens[4]);
            int issued = Integer.parseInt(tokens[5]);
            Date = format.parse(tokens[6]);
            Books[i] = new Books(tokens[0], tokens[1], tokens[2], tokens[3], q, issued, Date);
            i++;
        }
        counter = i;
    }
    private boolean Bookfound() {
        Bookfound = 0;
        for (int i = 0; i < counter; i++) {
            if (Books[i].getCallnumber().equals(BookNumber.getText())) {
                Bookfound = i;
                return true;
            }
        }
        return false;
    }
    private boolean Idfound() {
        String book = BookNumber.getText();
        String Id = StudentId.getText();
        IDfound = 0;
        for (int i = 0; i < counterIssuse; i++) {
            if (s[i].getId().equals(Id) && s[i].getCallnumber().equals(book)) {
                IDfound = i;
                return true;
            }
        }
        return false;
    }
    private boolean IssuedDate() {
        String date = format.format(s[IDfound].getIssuedDate());
        String tokens[] = date.split("-");
        int checkIssuedDay = Integer.parseInt(tokens[0]);
        int checkIssuedMonth = Integer.parseInt(tokens[1]);
        int checkIssuedYear = Integer.parseInt(tokens[2]);
        date = format.format(new Date(System.currentTimeMillis()));
        tokens = date.split("-");
        int checkCurrentDay = Integer.parseInt(tokens[0]);
        int checkCurrentMonth = Integer.parseInt(tokens[1]);
        int checkCurrentYear = Integer.parseInt(tokens[2]);
        if (checkIssuedMonth + 1 == checkCurrentMonth||checkIssuedMonth == checkCurrentMonth) {
            if (checkIssuedDay <= checkCurrentDay) {
                if (checkIssuedYear == checkCurrentYear) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }
    private void Delete() {
        for (int i = IDfound; i < counterIssuse - 1; i++) {
            IssuedBooks Temp = s[i];
            s[i] = s[i + 1];
            s[i + 1] = Temp;
        }
        counterIssuse--;
    }
    private void AddBooks() throws FileNotFoundException {
        int c = Books[Bookfound].getQuanitiy();
        Books[Bookfound].setQuanitiy(c + 1);
        c = Books[Bookfound].getIssued();
        Books[Bookfound].setIssued(c - 1);
        File file = new File("Books.txt");
        PrintWriter printer = new PrintWriter(file);
        for (int i = 0; i < counter; i++) {
            Date = Books[i].getDate();
            printer.print(Books[i].getCallnumber() + "," + Books[i].getName() + "," + Books[i].getPublisher() + "," + Books[i].getAuther() + ","
                    + Books[i].getQuanitiy() + "," + Books[i].getIssued() + "," + format.format(Date) + "\n");
        }
        printer.close();
    }
    private void writefile() throws IOException {
        File file = new File("IssuedBooks.txt");
        PrintWriter printer = new PrintWriter(file);
        for (int i = 0; i < counterIssuse; i++) {
            String id = s[i].getId();
            String callnumber = s[i].getCallnumber();
            String name = s[i].getName();
            String contact = s[i].getContactNumber();
            Date = s[i].getIssuedDate();
            String date = format.format(Date);
            printer.println(id + "," + callnumber + "," + name + "," + contact + "," + date);
        }
        printer.close();

    }
    public ReturnBook() throws FileNotFoundException, ParseException {
        initComponents();
        ReadFileIssued();
        ReadFile();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BookNumber = new javax.swing.JTextField();
        StudentId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Return Book");
        setLocation(new java.awt.Point(250, 250));

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel1.setText("Return Book");

        BookNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        StudentId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Book Call No.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Student ID:");

        Return.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Return.setText("Return");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BookNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(134, 134, 134))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BookNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(Return)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        LibrarianSection section = new LibrarianSection();
        section.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BackActionPerformed
    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        boolean works = false;
        boolean works2=Idfound();
        if (Bookfound()) {
            works = true;
        }
        if (works2&&works) {
            try {
                if (!IssuedDate()) {
                    JOptionPane.showMessageDialog(this, "Penalty Due To beening Late", "Error", JOptionPane.ERROR_MESSAGE);
                }
                AddBooks();
                Delete();
                writefile();
                JOptionPane.showMessageDialog(this, "Book returned successfully!");
                LibrarianSection section = new LibrarianSection();
                section.setVisible(true);
                this.hide();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Either Book/ID Not Found", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_ReturnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField BookNumber;
    private javax.swing.JButton Return;
    private javax.swing.JTextField StudentId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
