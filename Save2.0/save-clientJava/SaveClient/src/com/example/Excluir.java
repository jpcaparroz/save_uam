package com.example;

import com.example.models.Usuario;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.api.server.rmi.SaveService;

public class Excluir extends javax.swing.JFrame {
    
    Usuario user;
    List <Usuario> usuarios = new ArrayList<>();
 
    public Excluir() {
        initComponents();
        
        listarUsuarios();
    }

    public Excluir(Usuario user){
        initComponents();
        listarUsuarios();
        
        this.user = user;
    }
    
    //Listar Usuarios
    public void listarUsuarios() { 
        
        excluirCombo.removeAllItems();
        DefaultTableModel defaultUsuarios = (DefaultTableModel) usuariosTable.getModel();
        defaultUsuarios.setRowCount(0);

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            SaveService stub = (SaveService) registry.lookup("Save");
                       
            usuarios = stub.getUsuarios();
            
            for (Usuario listaUser : usuarios) {
                String tabelaUsuarios[] = {listaUser.getEmail(), listaUser.getNome()};
                defaultUsuarios.addRow(tabelaUsuarios);
                excluirCombo.addItem(listaUser.getEmail());
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    } 
    
    //Método para aparecer uma mensagem pop-up
    public void mensagemPopUp(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuariosTable = new javax.swing.JTable();
        logoMini = new javax.swing.JLabel();
        excluirButton = new javax.swing.JButton();
        excluirCombo = new javax.swing.JComboBox<>();
        voltarButton = new javax.swing.JButton();
        box = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N

        usuariosTable.setBackground(new java.awt.Color(255, 255, 255));
        usuariosTable.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        usuariosTable.setForeground(new java.awt.Color(0, 0, 0));
        usuariosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "E-mail", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usuariosTable.setGridColor(new java.awt.Color(0, 0, 0));
        usuariosTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        usuariosTable.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(usuariosTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 132, 833, 267));

        logoMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveLogoMini.png"))); // NOI18N
        jPanel1.add(logoMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        excluirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/excluirButton.png"))); // NOI18N
        excluirButton.setBorder(null);
        excluirButton.setBorderPainted(false);
        excluirButton.setContentAreaFilled(false);
        excluirButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirButtonActionPerformed(evt);
            }
        });
        jPanel1.add(excluirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 658, -1, -1));

        excluirCombo.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jPanel1.add(excluirCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 566, 310, 42));

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/voltar2.png"))); // NOI18N
        voltarButton.setBorder(null);
        voltarButton.setBorderPainted(false);
        voltarButton.setContentAreaFilled(false);
        voltarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(986, 10, -1, -1));

        box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/controleBox2.png"))); // NOI18N
        jPanel1.add(box, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 36, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        AdminHome admin = new AdminHome(user);
        
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void excluirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirButtonActionPerformed
        
        try {
            
            String excluir = excluirCombo.getSelectedItem().toString();
            
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            SaveService stub = (SaveService) registry.lookup("Save");
            
            if (stub.excluirUsuario(excluir)) {
                
                mensagemPopUp("Erro ao exlcuir o usuario...");
                
            } else {  
                
                listarUsuarios();
                mensagemPopUp("Usuario " + excluir + " excluido com sucesso!");
                
            }
            
            if(excluir.isBlank() || excluir.isEmpty()) {
                mensagemPopUp("Usuário inválido");
            } else {
                stub.excluirUsuario(excluir);
            }           
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_excluirButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Excluir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel box;
    private javax.swing.JButton excluirButton;
    private javax.swing.JComboBox<String> excluirCombo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoMini;
    private javax.swing.JTable usuariosTable;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
