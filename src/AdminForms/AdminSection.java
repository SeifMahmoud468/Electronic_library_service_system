package AdminForms;
import MainForm.HomeForm;
public class AdminSection extends javax.swing.JFrame {
    public AdminSection() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        View_librarian = new javax.swing.JButton();
        Add_librarian = new javax.swing.JButton();
        Delete_librarian = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Add_librarian1 = new javax.swing.JButton();
        Label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 250));

        View_librarian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        View_librarian.setText("View Librarian");
        View_librarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_librarianActionPerformed(evt);
            }
        });

        Add_librarian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Add_librarian.setText("Add Librarian");
        Add_librarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_librarianActionPerformed(evt);
            }
        });

        Delete_librarian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Delete_librarian.setText("Delete Librarian");
        Delete_librarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_librarianActionPerformed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        Add_librarian1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Add_librarian1.setText("Add Student");
        Add_librarian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_librarian1ActionPerformed(evt);
            }
        });

        Label1.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        Label1.setText("Admin Section");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(Label1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Add_librarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(View_librarian, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add_librarian, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete_librarian, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(148, 148, 148))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Label1)
                .addGap(18, 18, 18)
                .addComponent(Add_librarian, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(View_librarian, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add_librarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete_librarian, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void View_librarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_librarianActionPerformed
        // TODO add your handling code here:
        ViewLibrarian view=new ViewLibrarian();
        view.setVisible(true);
        this.hide();
    }//GEN-LAST:event_View_librarianActionPerformed

    private void Add_librarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_librarianActionPerformed
        // TODO add your handling code here:
        AddLibrarian add= new AddLibrarian();
        add.setVisible(true);
        this.hide();
    }//GEN-LAST:event_Add_librarianActionPerformed

    private void Delete_librarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_librarianActionPerformed
        // TODO add your handling code here:
        DeleteLibrarian delete=new DeleteLibrarian();
        delete.setVisible(true);
        this.hide();
    }//GEN-LAST:event_Delete_librarianActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        HomeForm back=new HomeForm();
        back.setVisible(true);
        this.hide();
    }//GEN-LAST:event_LogoutActionPerformed

    private void Add_librarian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_librarian1ActionPerformed
        // TODO add your handling code here:
        AddStudent student=new AddStudent();
        student.setVisible(true);
        this.hide();
    }//GEN-LAST:event_Add_librarian1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_librarian;
    private javax.swing.JButton Add_librarian1;
    private javax.swing.JButton Delete_librarian;
    private javax.swing.JLabel Label1;
    private javax.swing.JButton Logout;
    private javax.swing.JButton View_librarian;
    // End of variables declaration//GEN-END:variables
}
