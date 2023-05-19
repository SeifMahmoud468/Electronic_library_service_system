package MainForm;
import AdminForms.AdminLogin;
import LibrarianForms.LibrarianLogin;
import LibrarianForms.StudentLogin;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class HomeForm extends javax.swing.JFrame {

    public HomeForm() {
        initComponents();
    }
    public static void main(String[] args) {
            HomeForm window= new HomeForm();
            window.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label1 = new javax.swing.JLabel();
        LibrariansButton = new javax.swing.JButton();
        AdminButton = new javax.swing.JButton();
        StudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Mangment");
        setBackground(new java.awt.Color(51, 51, 255));
        setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        setLocation(new java.awt.Point(250, 250));
        setSize(new java.awt.Dimension(542, 400));

        Label1.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        Label1.setText("Library Mangment");
        Label1.setToolTipText("");

        LibrariansButton.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        LibrariansButton.setText("Librarian Login");
        LibrariansButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibrariansButtonActionPerformed(evt);
            }
        });

        AdminButton.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        AdminButton.setText("Admin Login");
        AdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminButtonActionPerformed(evt);
            }
        });

        StudentButton.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        StudentButton.setText("Student Login");
        StudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(Label1)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LibrariansButton, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(Label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LibrariansButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(StudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Label1.getAccessibleContext().setAccessibleParent(Label1);

        getAccessibleContext().setAccessibleParent(Label1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void LibrariansButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibrariansButtonActionPerformed
        // TODO add your handling code here:
        LibrarianLogin LibrarianWindow = null;
        try {
            LibrarianWindow = new LibrarianLogin();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        LibrarianWindow.setVisible(true);
        this.hide();
    }//GEN-LAST:event_LibrariansButtonActionPerformed
    private void AdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminButtonActionPerformed
            AdminLogin adminwidow= new AdminLogin();
            adminwidow.setVisible(true);
            this.hide();
    }//GEN-LAST:event_AdminButtonActionPerformed

    private void StudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentButtonActionPerformed
           StudentLogin StudentWindow = null;
        try {
            StudentWindow = new StudentLogin();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        StudentWindow.setVisible(true);
        this.hide();
    }//GEN-LAST:event_StudentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminButton;
    private javax.swing.JLabel Label1;
    private javax.swing.JButton LibrariansButton;
    private javax.swing.JButton StudentButton;
    // End of variables declaration//GEN-END:variables
}
