package com.example;

import com.example.models.Usuario;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.api.server.rmi.SaveService;

public class Users extends javax.swing.JFrame {
    
    Usuario user;
 
    public Users() {
        initComponents();
        
        listarUsuarios();
    }

    public Users(Usuario user){
        initComponents();
        listarUsuarios();
        
        this.user = user;
    }
    
    //Listar Usuarios
    public void listarUsuarios() { 
        
        DefaultTableModel defaultUsuarios = (DefaultTableModel) usuariosTable.getModel();
        defaultUsuarios.setRowCount(0);

        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            SaveService stub = (SaveService) registry.lookup("Save");
            
            List <Usuario> usuarios = new ArrayList<>();
            
            usuarios = stub.getUsuarios();
            
            System.out.println(usuarios.get(0).getEmail());
            
            for (Usuario listaUser : usuarios) {
                String tabelaUsuarios[] = {listaUser.getEmail(), listaUser.getNome()};
                defaultUsuarios.addRow(tabelaUsuarios);
                
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
        voltarButton = new javax.swing.JButton();
        logoMini1 = new javax.swing.JLabel();

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
        usuariosTable.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
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
        jScrollPane1.setViewportView(usuariosTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 830, 590));

        logoMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveLogoMini.png"))); // NOI18N
        jPanel1.add(logoMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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

        logoMini1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/controleBox.png"))); // NOI18N
        jPanel1.add(logoMini1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 36, -1, -1));

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
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoMini;
    private javax.swing.JLabel logoMini1;
    private javax.swing.JTable usuariosTable;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
