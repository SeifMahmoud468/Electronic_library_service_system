package AdminForms;

import Classes.Librarians;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Character.isLetter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DeleteLibrarian extends javax.swing.JFrame {

    Librarians[] s = new Librarians[100];
    int counter;
    boolean Error = true;

    public DeleteLibrarian() {
        initComponents();
        ID.grabFocus();
        int i = 0;
        try {
            File file = new File("Librarian.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String tokens[] = line.split(",");
                s[i] = new Librarians(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
                i++;
            }
            counter = i;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Validation() {
        String id = ID.getText();
        for (int i = 1; i < id.length(); i++) {
            if (isLetter(id.charAt(i)) && id.length() > 0) {
                ID.grabFocus();
                JOptionPane.showMessageDialog(this, "Invalied Id", "Error", JOptionPane.ERROR_MESSAGE);
                Error = false;
                break;
            }
        }
    }

    private boolean Delete() {
        String id = ID.getText();
        boolean deleted = false;
        if (Error) {
            for (int i = 0; i < counter; i++) {
                if (id.equals(s[i].getId())) {
                    for (int j = i; j < counter - 1; j++) {
                        Librarians temp = s[j];
                        s[j] = s[j + 1];
                        s[j + 1] = temp;
                    }
                    s[counter] = null;
                    counter--;
                    deleted = true;
                }
            }
            if (!deleted && id.length() > 0) {
                JOptionPane.showMessageDialog(this, "ID Not Found", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (id.length() == 0) {
                JOptionPane.showMessageDialog(this, "Enter ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return deleted;
    }

    private boolean write() {
        PrintWriter printer = null;
        try {
            File file = new File("Librarian.txt");
            printer = new PrintWriter(file);
            for (int i = 0; i < counter; i++) {
                String id = s[i].getId();
                String name = s[i].getName();
                String password = s[i].getPassword();
                String email = s[i].getEmail();
                String address = s[i].getAddress();
                String city = s[i].getCity();
                String contact = s[i].getContact();
                printer.println(id + "," + name + "," + password + "," + email + "," + address + "," + city + "," + contact);
            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DeleteLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            printer.close();
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Delete = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delete Librarian");
        setLocation(new java.awt.Point(250, 250));

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel1.setText("Delete Librarian");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Enter ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        Validation();
        if (Delete() && write() && Error) {
            JOptionPane.showMessageDialog(this, "Librarian Delete");
            this.hide();
            AdminSection back = new AdminSection();
            back.setVisible(true);
        }
    }//GEN-LAST:event_DeleteActionPerformed
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        AdminSection back = new AdminSection();
        back.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BackActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
