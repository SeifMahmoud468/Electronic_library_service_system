package LibrarianForms;
import LibrarianForms.IssueBook;
import MainForm.HomeForm;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LibrarianSection extends javax.swing.JFrame {
    public LibrarianSection() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AddBooks = new javax.swing.JButton();
        ViewBooks = new javax.swing.JButton();
        IssueBook = new javax.swing.JButton();
        ViewIssueBooks = new javax.swing.JButton();
        ReturnBook = new javax.swing.JButton();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Librarian Section");
        setLocation(new java.awt.Point(250, 250));

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel1.setText("Librarian Section");

        AddBooks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddBooks.setText("Add Books");
        AddBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBooksActionPerformed(evt);
            }
        });

        ViewBooks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ViewBooks.setText("View Books");
        ViewBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewBooksActionPerformed(evt);
            }
        });

        IssueBook.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IssueBook.setText("Issue Book");
        IssueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueBookActionPerformed(evt);
            }
        });

        ViewIssueBooks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ViewIssueBooks.setText("View Issue Books");
        ViewIssueBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewIssueBooksActionPerformed(evt);
            }
        });

        ReturnBook.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReturnBook.setText("Return Book");
        ReturnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnBookActionPerformed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ViewIssueBooks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ReturnBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IssueBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ViewBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IssueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewIssueBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ReturnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void ReturnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnBookActionPerformed
        // TODO add your handling code here:
        ReturnBook returns = null;
        try {
            returns = new ReturnBook();
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(LibrarianSection.class.getName()).log(Level.SEVERE, null, ex);
        }
        returns.setVisible(true);
        this.hide();
    }//GEN-LAST:event_ReturnBookActionPerformed
    private void AddBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBooksActionPerformed
        // TODO add your handling code here:
        AddBooks add=new AddBooks();
        add.setVisible(true);
        this.hide();
    }//GEN-LAST:event_AddBooksActionPerformed
    private void ViewBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewBooksActionPerformed
        try {
            ViewBooks view = new ViewBooks();
            view.setVisible(true);
            this.hide();
        } catch (ParseException ex) {
            Logger.getLogger(LibrarianSection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ViewBooksActionPerformed
    private void IssueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueBookActionPerformed
        try {
            // TODO add your handling code here:
            IssueBook issue = new IssueBook();
            issue.setVisible(true);
            this.hide();
        } catch (ParseException | FileNotFoundException ex) {
            Logger.getLogger(LibrarianSection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IssueBookActionPerformed
    private void ViewIssueBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewIssueBooksActionPerformed
        try {
            // TODO add your handling code here:
            ViewIssueBooks books=new ViewIssueBooks();
            books.setVisible(true);
            this.hide();
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(LibrarianSection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ViewIssueBooksActionPerformed
    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        HomeForm logout=new HomeForm();
        logout.setVisible(true);
        this.hide();
    }//GEN-LAST:event_LogoutActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBooks;
    private javax.swing.JButton IssueBook;
    private javax.swing.JButton Logout;
    private javax.swing.JButton ReturnBook;
    private javax.swing.JButton ViewBooks;
    private javax.swing.JButton ViewIssueBooks;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
