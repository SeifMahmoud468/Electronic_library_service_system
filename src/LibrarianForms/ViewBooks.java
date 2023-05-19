package LibrarianForms;

import Classes.Books;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ViewBooks extends javax.swing.JFrame {
    Books[] s = new Books[100];
    int counter;
    Date Date;
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    private void ReadFile() throws FileNotFoundException, ParseException {
        int i = 0;
            File file = new File("Books.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String tokens[] = line.split(",");
                int q = Integer.parseInt(tokens[4]);
                int issued= Integer.parseInt(tokens[5]);
                Date= format.parse(tokens[6]);
                s[i] = new Books(tokens[0], tokens[1], tokens[2], tokens[3], q,issued,Date);
                i++;
            }
            counter = i;
    }
    private void Viewfile() throws ParseException
    {
        try {
            ReadFile();
            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < counter; i++) {
                Date=s[i].getDate();
                Object[] row=new Object[]{i+1,s[i].getCallnumber(),s[i].getName(),s[i].getAuther(),s[i].getPublisher(),s[i].getQuanitiy(),s[i].getIssued(),format.format(Date)};
                d.insertRow(d.getRowCount(), row);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ViewBooks() throws ParseException {
        initComponents();
        Viewfile();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Books");
        setLocation(new java.awt.Point(250, 250));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Call No.", "Name", "Author", "Publisher", "Quantity", "Issued", "Added Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        LibrarianSection section= new LibrarianSection();
        section.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BackActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}