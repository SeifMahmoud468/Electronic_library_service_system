package LibrarianForms;

import Classes.IssuedBooks;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ViewIssueBooks extends javax.swing.JFrame {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date Date;
    int counterIssuse;
    IssuedBooks[] s=new IssuedBooks[100]; 
    
   
    public ViewIssueBooks() throws FileNotFoundException, ParseException {
        initComponents();
        Viewfile();
    }
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
       private void Viewfile() throws ParseException
    {
        try {
            ReadFileIssued();
            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < counterIssuse; i++) {
                Date=s[i].getIssuedDate();
                Object[] row=new Object[]{i+1,s[i].getCallnumber(),s[i].getId(),s[i].getName(),s[i].getContactNumber(),format.format(Date)};
                d.insertRow(d.getRowCount(), row);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Back1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Issue Books");
        setLocation(new java.awt.Point(250, 250));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Call No.", "Student ID", "Student Name", "Student Contact", "Issued Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Back1.setText("Back");
        Back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(Back1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back1ActionPerformed
        // TODO add your handling code here:
        LibrarianSection section= new LibrarianSection();
        section.setVisible(true);
        this.hide();
    }//GEN-LAST:event_Back1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}