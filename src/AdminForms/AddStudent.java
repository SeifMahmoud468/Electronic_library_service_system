package AdminForms;
import Classes.Student;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class AddStudent extends javax.swing.JFrame {
    public AddStudent() {
        initComponents();
    }
    boolean Error;
    Student[] s = new Student[100];
    int counter;
    private void ReadFile() {
        int i = 0;
        try {
            File file = new File("Student.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String tokens[] = line.split(",");
                s[i] = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
                i++;
            }
            counter=i;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void IdValidation() {
        String id = Id.getText();        
        for (int i = 1; i < id.length(); i++) {
            if (isLetter(id.charAt(i))) {
                Id.setText("");
                Id.grabFocus();
                JOptionPane.showMessageDialog(this, "Invalied Id", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                return;
            }

        }
        for (int i = 0; i < counter; i++) {
            if (id.equals(s[i].getId())) {
                Id.setText("");
                Id.grabFocus();
                JOptionPane.showMessageDialog(this, "ID is already taken", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
            }
        }
        Error = false;
    }
    private void NameValidation() {
        String name = Name.getText();
        for (int i = 0; i < name.length(); i++) {
            if (isDigit(name.charAt(i))) {
                Name.setText("");
                JOptionPane.showMessageDialog(this, "Invalied Name", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                Name.grabFocus();
                return;
            }
        }
        Error = true;
    }
    private boolean EmailValidation() {
        String email = Email.getText();
        if (email.length() > 0) {
            String EmailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
            Pattern EmailPat = Pattern.compile(EmailPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = EmailPat.matcher(email);
            if (matcher.find() == false) {
                Email.setText("");
                JOptionPane.showMessageDialog(this, "Invalied Email", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                Email.grabFocus();

            }
            return matcher.find();
        }
        return false;
    }
    private void CityValidation() {
        String city = City.getText();
        for (int i = 0; i < city.length(); i++) {
            if (isDigit(city.charAt(i))) {
                City.setText("");
                City.grabFocus();
                JOptionPane.showMessageDialog(this, "Invalied City Name", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                return;
            }
        }
        Error = true;
    }
    private void ContactValidation() {
        String phone = Contact.getText();
        if (phone.charAt(0) == '+' || isDigit(phone.charAt(0))) {
            for (int i = 1; i < phone.length(); i++) {
                if (isLetter(phone.charAt(i))) {
                    Contact.setText("");
                    Contact.grabFocus();
                    JOptionPane.showMessageDialog(this, "Invalied Contact number", "Error", JOptionPane.ERROR_MESSAGE);
                    Error = false;
                    return;
                }
            }
            Error = true;
        } else {
            Contact.setText("");
            Contact.grabFocus();
            JOptionPane.showMessageDialog(this, "Invalied Contact number", "Error", JOptionPane.ERROR_MESSAGE);
            Error = false;
        }
    }
    private void EmptyFiled() {
        String id = Id.getText();
        String name = Name.getText();
        String password = Password.getText();
        String email = Email.getText();
        String address = Address.getText();
        String city = City.getText();
        String contact = Contact.getText();
        if (id.isEmpty() || name.isEmpty() || password.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty() || contact.isEmpty()) {
            Error = false;
            JOptionPane.showMessageDialog(this, "Incomplete Registration\nEMPTY FIELD", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Error = true;
        }
    }
    private boolean AddLibririan() {
        try {
            FileWriter file = new FileWriter("Student.txt", true);
            BufferedWriter bw = new BufferedWriter(file);
            try (PrintWriter printer = new PrintWriter(file)) {
                String id = Id.getText();
                String name = Name.getText();
                String password = Password.getText();
                String email = Email.getText();
                String address = Address.getText();
                String city = City.getText();
                String contact = Contact.getText();
                printer.print(id + "," + name + "," + password + "," + email + "," + address + "," + city + "," + contact+"\n");
                printer.close();
            }

            return true;

        } catch (IOException ex) {
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        City = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Contact = new javax.swing.JTextField();
        Id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Email = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        Address = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 250));

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel1.setText("Add Student");

        City.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CityFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Id");

        Contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ContactFocusLost(evt);
            }
        });

        Id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IdFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Address:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("City:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Contact No.:");

        Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameFocusLost(evt);
            }
        });

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailFocusLost(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Email)
                    .addComponent(Password)
                    .addComponent(Address)
                    .addComponent(Name)
                    .addComponent(Contact)
                    .addComponent(City)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void CityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CityFocusLost
        // TODO add your handling code here:
        if(City.getText().length()>0)
            CityValidation();
    }//GEN-LAST:event_CityFocusLost
    private void ContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContactFocusLost
        // TODO add your handling code here:
        if(Contact.getText().length()>0)
            ContactValidation();
    }//GEN-LAST:event_ContactFocusLost
    private void IdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdFocusLost
        // TODO add your handling code here:
        ReadFile();
        IdValidation();
    }//GEN-LAST:event_IdFocusLost
    private void NameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFocusLost
        // TODO add your handling code here:
       if(Name.getText().length()>0)
            NameValidation();
    }//GEN-LAST:event_NameFocusLost
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        EmptyFiled();
        if (Error) {
            if (AddLibririan()) {
                JOptionPane.showMessageDialog(this, "Student Added");
                this.hide();
                AdminSection back = new AdminSection();
                back.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Process can not be done", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_AddActionPerformed
    private void EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFocusLost
        // TODO add your handling code here:
        EmailValidation();
    }//GEN-LAST:event_EmailFocusLost
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        AdminSection back = new AdminSection();
        back.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BackActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField Address;
    private javax.swing.JButton Back;
    private javax.swing.JTextField City;
    private javax.swing.JTextField Contact;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Name;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
