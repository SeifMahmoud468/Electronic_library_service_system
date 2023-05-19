package LibrarianForms;

import AdminForms.AddLibrarian;
import AdminForms.AdminLogin;
import Classes.Books;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddBooks extends javax.swing.JFrame {

    Books[] s = new Books[100];
    Boolean Error;
    Date Date;
    int counter;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public AddBooks() {
        initComponents();
    }

    private void ReadFile() throws ParseException {
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
                s[i] = new Books(tokens[0], tokens[1], tokens[2], tokens[3], q, issued, Date);
                i++;
            }
            counter = i;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void AutherValidation() {
        String name = Auther.getText();
        for (int i = 0; i < name.length(); i++) {
            if (isDigit(name.charAt(i))) {
                Auther.setText("");
                JOptionPane.showMessageDialog(this, "Invalied Auther Name", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                Auther.grabFocus();
                return;
            }
        }
        Error = true;
    }

    private void PublisherValidation() {
        String name = Publisher.getText();
        for (int i = 0; i < name.length(); i++) {
            if (isDigit(name.charAt(i))) {
                Publisher.setText("");
                JOptionPane.showMessageDialog(this, "Invalied Publisher Name", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                Publisher.grabFocus();
                return;
            } else {
            }
        }
        Error = true;
    }

    private void EmptyFiled() {
        String callno = CallNumber.getText();
        String name = Name.getText();
        String auther = Auther.getText();
        String publisher = Publisher.getText();
        if (callno.isEmpty() || name.isEmpty() || auther.isEmpty() || publisher.isEmpty()) {
            Error = false;
            JOptionPane.showMessageDialog(this, "Incomplete Operation\nEMPTY FIELD", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Error = true;
        }
    }

    private boolean AddBooks() {
        try {
            FileWriter file = new FileWriter("Books.txt", true);
            BufferedWriter bw = new BufferedWriter(file);
            try (PrintWriter printer = new PrintWriter(file)) {
                String callno = CallNumber.getText();
                String name = Name.getText();
                String auther = Auther.getText();
                String publisher = Publisher.getText();
                int quantity = Integer.parseInt(Quantity.getText());
                Date = new Date(System.currentTimeMillis());
                printer.print(callno + "," + name + "," + auther + "," + publisher + "," + quantity + "," + 0 + "," + format.format(Date) + "\n");
                printer.close();
            }

            return true;

        } catch (IOException ex) {
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void CallNoValidation() {
        String callno = CallNumber.getText();
        for (int i = 1; i < callno.length(); i++) {
            if (isLetter(callno.charAt(i))) {
                CallNumber.setText("");
                CallNumber.grabFocus();
                JOptionPane.showMessageDialog(this, "Invalied Call Number", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                return;
            }
        }
    }

    private void QValidation() {
        String callno = Quantity.getText();
        for (int i = 1; i < callno.length(); i++) {
            if (isLetter(callno.charAt(i))) {
                Quantity.setText("");
                Quantity.grabFocus();
                JOptionPane.showMessageDialog(this, "Invalied Quantity", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                return;
            }
        }
        int quant = Integer.parseInt(callno);
        if (quant <= 0) {
            Quantity.setText("");
            Quantity.grabFocus();
            JOptionPane.showMessageDialog(this, "Invalied Quantity", "Error", JOptionPane.ERROR_MESSAGE);
            Error = false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        CallNumber = new javax.swing.JTextField();
        Auther = new javax.swing.JTextField();
        Publisher = new javax.swing.JTextField();
        AddBook = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Quantity = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Books");
        setLocation(new java.awt.Point(250, 250));

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel1.setText("Add Books");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Call No.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Auther:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Publisher:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Quantity:");

        Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameFocusLost(evt);
            }
        });

        CallNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CallNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CallNumberFocusLost(evt);
            }
        });

        Auther.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Auther.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AutherFocusLost(evt);
            }
        });

        Publisher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Publisher.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PublisherFocusLost(evt);
            }
        });

        AddBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddBook.setText("Add Book");
        AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                QuantityFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Publisher)
                    .addComponent(CallNumber)
                    .addComponent(Name)
                    .addComponent(Auther, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(Quantity))
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(Back)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Auther, CallNumber, Name, Publisher, Quantity});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CallNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Name)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Auther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(AddBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back)
                .addGap(23, 23, 23))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Auther, CallNumber, Name, Publisher, Quantity});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        LibrarianSection section = new LibrarianSection();
        section.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BackActionPerformed
    private void AddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookActionPerformed
        EmptyFiled();
        if (AddBooks()) {
            JOptionPane.showMessageDialog(this, "Book is Added");
            LibrarianSection section = new LibrarianSection();
            section.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_AddBookActionPerformed
    private void CallNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CallNumberFocusLost
        CallNoValidation();
    }//GEN-LAST:event_CallNumberFocusLost
    private void NameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFocusLost
        NameValidation();
    }//GEN-LAST:event_NameFocusLost
    private void AutherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AutherFocusLost
        AutherValidation();
    }//GEN-LAST:event_AutherFocusLost
    private void PublisherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PublisherFocusLost
        PublisherValidation();
    }//GEN-LAST:event_PublisherFocusLost

    private void QuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_QuantityFocusLost
        QValidation();
    }//GEN-LAST:event_QuantityFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBook;
    private javax.swing.JTextField Auther;
    private javax.swing.JButton Back;
    private javax.swing.JTextField CallNumber;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Publisher;
    private javax.swing.JTextField Quantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
