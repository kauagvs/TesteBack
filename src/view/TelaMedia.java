/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.bean.Cadastro;
import model.dao.CadastroDAO;

/**
 *
 * @author Kaua Semenov
 */
public class TelaMedia extends javax.swing.JFrame {

    /** Creates new form Resultado */
    public TelaMedia() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTMedia.getModel();
        readJTable(); 
        ((DefaultTableCellRenderer) jTMedia.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    
    
    }

    public void readJTable(){
      
        DefaultTableModel modelo = (DefaultTableModel) jTMedia.getModel();
        modelo.setNumRows(0);
        CadastroDAO cdao = new CadastroDAO();
        
        for(Cadastro c: cdao.readavg()){
            
            modelo.addRow(new Object[]{
                c.getVl_total(),
                
            });
            
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTMedia = new javax.swing.JTable();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTMedia.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jTMedia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDIA DO SALDO DOS CLIENTES"
            }
        ));
        jTMedia.setRowHeight(30);
        jScrollPane1.setViewportView(jTMedia);

        jButtonSair.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jButtonSair.setText("Ok");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSair)
                        .addGap(108, 108, 108))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSair, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        TelaClientesdaMedia tela = new TelaClientesdaMedia();
        tela.setVisible(true); 
        tela.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMedia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMedia;
    // End of variables declaration//GEN-END:variables

}
