/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royalsovereign.label.ucc.ingram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author hkim
 */
public class IngramUccLabelPrintingFrame extends javax.swing.JFrame {

    int lastSerialNumber;
    String shipFromName, shipFromAddress1, shipFromAddress2, shipFromCity, shipFromState, shipFromZipcode;
    String shipToName, shipToAddress1, shipToAddress2, shipToCity, shipToState, shipToZipcode;
    String SCAC, BOL, PO, AICode, containerType, GS1;
    String originalArchive;
    String[] PRO;
    
    /**
     * Creates new form IngramUccLabelPrintingFrame
     */
    public IngramUccLabelPrintingFrame() {
        super("Ingram UCC Label Printing");
        initComponents();
        setVisible(true);
        this.
        
        shipFromName = "Royal Sovereign Int'l Inc.";
        shipFromAddress1 = "2 Volvo Drive";
        shipFromAddress2 = "";
        shipFromCity = "Rockleigh";
        shipFromState = "NJ";
        shipFromZipcode = "07024";
        
        shipToName = "Ingram Micro Inc.";
        shipToAddress1 = "12510 Micro Drive";
        shipToAddress2 = "";
        shipToCity = "Mira Loma";
        shipToState = "CA";
        shipToZipcode = "91752";
        
        AICode = "00";
        containerType = "0";
        GS1 = "35565";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Ship From:");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NJ", "CA" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Container Type:");

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carton", "Pallet" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("BOL:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("PO#:");

        jTextField7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField7.setToolTipText("Enter BOL#");

        jTextField8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField8.setToolTipText("");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("PRO#:");
        
        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Ship From:");

        jComboBox3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox3.addItem("Branch 10");
        jComboBox3.addItem("Branch 30");
        jComboBox3.addItem("Branch 40");
        jComboBox3.addItem("Branch 80");
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        
        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Print Label");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("SCAC:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField7))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SCAC = jTextField1.getText();
        BOL = jTextField7.getText();
        PO = jTextField8.getText();
        String proList = jTextArea1.getText();
        PRO = proList.split("\n");
        if (SCAC.isEmpty() || BOL.isEmpty() || PO.isEmpty() || proList.isEmpty()){
            JOptionPane.showMessageDialog(this,"All Fields must be filled", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            getLastSerialNumber();
            String output = "";
            for (int i=0; i<PRO.length; i++){
               output += shipFromName + "," + shipFromAddress1 + "," + shipFromAddress2 + "," + shipFromCity + "," + shipFromState + "," + shipFromZipcode + ","; 
               output += shipToName + "," + shipToAddress1 + "," + shipToAddress2 + "," + shipToCity + "," + shipToState + "," + shipToZipcode + ",";                 
               output += SCAC + "," + PRO[i] + "," + BOL + "," + PO + "," + "," + AICode + "," + containerType + "," + GS1 + "," + ++lastSerialNumber + "," + "\n";
            }
            writeOutput(output);
        }
        System.out.println("process done");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selection = (String)((JComboBox)(evt.getSource())).getSelectedItem();
        if(selection.compareTo("CA")==0){
            shipFromName = "Royal Sovereign Int'l Inc.";
            shipFromAddress1 = "222 E. Redondo Beach Blvd.";
            shipFromAddress2 = "Unit F";
            shipFromCity = "Gardena";
            shipFromState = "CA";
            shipFromZipcode = "90248";
        }
        else if(selection.compareTo("NJ")==0){
            shipFromName = "Royal Sovereign Int'l Inc.";
            shipFromAddress1 = "2 Volvo Drive";
            shipFromAddress2 = "";
            shipFromCity = "Rockleigh";
            shipFromState = "NJ";
            shipFromZipcode = "07024";
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String selection = (String)((JComboBox)(evt.getSource())).getSelectedItem();
        if(selection.compareTo("Carton")==0){
            containerType = "0";
        }
        else if(selection.compareTo("Pallet")==0){
            containerType = "1";
        }
        System.out.println(containerType);
    }//GEN-LAST:event_jComboBox2ActionPerformed
    
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String selection = (String)((JComboBox)(evt.getSource())).getSelectedItem();
        if(selection.compareTo("Branch 10")==0){
            shipToName = "Ingram Micro Inc.";
            shipToAddress1 = "12510 Micro Drive";
            shipToAddress2 = "";
            shipToCity = "Mira Loma";
            shipToState = "CA";
            shipToZipcode = "91752";
        }
        else if(selection.compareTo("Branch 30")==0){
            shipToName = "Ingram Micro Inc.";
            shipToAddress1 = "3820 Micro Drive";
            shipToAddress2 = "";
            shipToCity = "Millington";
            shipToState = "TN";
            shipToZipcode = "38053";
        }
        else if(selection.compareTo("Branch 40")==0){
            shipToName = "Ingram Micro Inc.";
            shipToAddress1 = "415 East Lies Rd.";
            shipToAddress2 = "";
            shipToCity = "Carol Stream";
            shipToState = "IL";
            shipToZipcode = "60188";
        }
        else if(selection.compareTo("Branch 80")==0){
            shipToName = "Ingram Micro Inc.";
            shipToAddress1 = "80 Micro Drive";
            shipToAddress2 = "";
            shipToCity = "Jonestown";
            shipToState = "PA";
            shipToZipcode = "17038";
        }
        System.out.println(shipToName + "," + shipToAddress1 + "," + shipToAddress2 + "," + shipToCity + "," + shipToState + "," + shipToZipcode);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    
    
    private void getLastSerialNumber() {
        originalArchive = "";
        try {
            FileReader fr = new FileReader("//10.0.0.10/Public/IT/Label_Printing/bartender_edi/Ingram_Out.csv");
            BufferedReader br = new BufferedReader(fr);
            String readLine, lastLine="";
            readLine = br.readLine();
            originalArchive += readLine + "\n";
            while( readLine != null){
                //System.out.println(readLine);
                lastLine = readLine;
                readLine = br.readLine();
                if(readLine !=null)
                    originalArchive += readLine + "\n";
            }
            
            StringTokenizer st = new StringTokenizer(lastLine, ",");
            String token="";
            while (st.hasMoreElements()){
                token = st.nextToken();
            }
            lastSerialNumber = Integer.parseInt(token);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(IngramUccLabelPrintingFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(IngramUccLabelPrintingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void writeOutput(String output) {
        String labelFileName = "//10.0.0.10/Public/IT/Label_Printing/bartender_edi/Ingram_Out_java.csv";
        String archiveFileName = "//10.0.0.10/Public/IT/Label_Printing/bartender_edi/Ingram_Out.csv";
        
        System.out.println(output);
        System.out.println(originalArchive);
        try{
            FileWriter writeLabelFile = new FileWriter(labelFileName);
            writeLabelFile.append(output);
            writeLabelFile.flush();
            writeLabelFile.close();
        }
        catch (IOException ex) {
            Logger.getLogger(IngramUccLabelPrintingFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        try{
            FileWriter writeArchiveFile = new FileWriter(archiveFileName);
            writeArchiveFile.append(originalArchive + output);
            writeArchiveFile.flush();
            writeArchiveFile.close();
        }
        catch (IOException ex) {
            Logger.getLogger(IngramUccLabelPrintingFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
