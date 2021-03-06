/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DocumentModel;
import preprocessing.MiningAllDoc;

/**
 *
 * @author Prince Al Keita
 */
public class Interface1 extends javax.swing.JFrame {
    private  List<DocumentModel> documentsF;
    /**
     * Creates new form Interface
     */
    public Interface1(List<DocumentModel> documents) {
        initComponents();
        init(documents);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void init(List<DocumentModel> documents){
        setEnabled(false);
        documentsF=new ArrayList<DocumentModel>();
        searchButton.addActionListener(new ActionListener()
                       {
                            public void actionPerformed(ActionEvent ae)
                            {
                              setEnabled(true);
                             doc1Label.setText(" ");
                             doc2Label.setText(" ");
                             doc3Label.setText(" ");
                             String result="";   
                             String word=wordView.getText();
                            MiningAllDoc allDoc=new MiningAllDoc(documents);
                            allDoc.stemmingAllDoc();
                            allDoc.queryUpdate(word);
                           documentsF= allDoc.getScore();
                           doc1Label.setText(documentsF.get(0).getName());
                           doc2Label.setText(documentsF.get(1).getName());
                           doc3Label.setText(documentsF.get(2).getName());
                                
 
                            
                            }
                        });
        doc1Label.addMouseListener(new MouseAdapter()  
                        {  
                            public void mouseClicked(MouseEvent e)  
                            {  
                                Runtime rTime = Runtime.getRuntime();
                                String url = "test\\"+documentsF.get(0).getName();
                                String browser = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe ";
                                Process pc;
                                try {
                                    pc = rTime.exec(browser + url);
                                     pc.waitFor();
                                } catch (IOException ex) {
                                    Logger.getLogger(Interface1.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Interface1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                       

                            }  
                        }); 
        doc2Label.addMouseListener(new MouseAdapter()  
                        {  
                            public void mouseClicked(MouseEvent e)  
                            {  
                                Runtime rTime = Runtime.getRuntime();
                                String url = "test\\"+documentsF.get(1).getName();
                                String browser = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe ";
                                Process pc;
                                try {
                                    pc = rTime.exec(browser + url);
                                     pc.waitFor();
                                } catch (IOException ex) {
                                    Logger.getLogger(Interface1.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Interface1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                       

                            }  
                        });
        doc3Label.addMouseListener(new MouseAdapter()  
                        {  
                            public void mouseClicked(MouseEvent e)  
                            {  
                                Runtime rTime = Runtime.getRuntime();
                                String url = "test\\"+documentsF.get(2).getName();
                                String browser = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe ";
                                Process pc;
                                try {
                                    pc = rTime.exec(browser + url);
                                     pc.waitFor();
                                } catch (IOException ex) {
                                    Logger.getLogger(Interface1.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Interface1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                       

                            }  
                        }); 
        
                        
    }
    public void setEnabled(boolean bool){
         doc1Label.setEnabled(bool);
         doc1Label.setVisible(bool);
         doc2Label.setVisible(bool);
         doc3Label.setVisible(bool);
         doc2Label.setEnabled(bool);
         doc3Label.setEnabled(bool);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelView = new javax.swing.JPanel();
        wordView = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        doc1Label = new javax.swing.JLabel();
        doc2Label = new javax.swing.JLabel();
        doc3Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        wordView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordViewActionPerformed(evt);
            }
        });

        searchButton.setText("Search");

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(wordView, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(searchButton))
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(doc1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doc2Label, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(doc3Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(71, 71, 71))
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(34, 34, 34)
                .addComponent(doc1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(doc3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(doc2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wordViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wordViewActionPerformed

    
  //  public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface1.setVisible(true);
            }
        });*/
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel doc1Label;
    private javax.swing.JLabel doc2Label;
    private javax.swing.JLabel doc3Label;
    private javax.swing.JPanel panelView;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField wordView;
    // End of variables declaration//GEN-END:variables
}
