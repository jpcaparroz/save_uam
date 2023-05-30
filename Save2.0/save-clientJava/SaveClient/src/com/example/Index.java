package com.example;

import com.api.server.rmi.modules.Usuario;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import com.api.server.rmi.SaveService;

public class Index extends javax.swing.JFrame {

    public Index() {
        initComponents();

        apagar();
    }

    public void mensagemPopUp(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    //Método para exibir elementos da tela de login
    public void telaLogin(){
        helpText.show();
        loginBox.show();
        loginField.show();
        entrarButton.show();
        cadastrarButton.show();
        
        apagar();
    }
    
    //Método para esconder Ações de Cadastro
    public void apagar(){
        nomeBox.disable();
        nomeBox.hide();
        
        emailBox.hide();
        emailBox.disable();
        
        emailField.hide();
        emailField.disable();
        
        nomeField.hide();
        nomeField.disable();
        
        cadastrar.hide();
        cadastrar.disable();
        
        voltarButton.hide();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        entrarButton = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        loginField = new javax.swing.JTextField();
        loginBox = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        nomeBox = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailBox = new javax.swing.JLabel();
        helpText = new javax.swing.JLabel();
        cadastrarButton = new javax.swing.JLabel();
        voltarButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveLogo.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 172, -1, -1));

        entrarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/entrar.png"))); // NOI18N
        entrarButton.setBorder(null);
        entrarButton.setBorderPainted(false);
        entrarButton.setContentAreaFilled(false);
        entrarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrarButton.setFocusPainted(false);
        entrarButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/entrarPressed.png"))); // NOI18N
        entrarButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/entrarPressed.png"))); // NOI18N
        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(entrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 453, -1, -1));

        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cadastrar.png"))); // NOI18N
        cadastrar.setBorder(null);
        cadastrar.setBorderPainted(false);
        cadastrar.setContentAreaFilled(false);
        cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastrar.setFocusPainted(false);
        cadastrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cadastrarPressed.png"))); // NOI18N
        cadastrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cadastrarPressed.png"))); // NOI18N
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 528, -1, -1));

        loginField.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        loginField.setText("LOGIN");
        loginField.setBorder(null);
        jPanel1.add(loginField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 398, 270, 30));

        loginBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        jPanel1.add(loginBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 394, -1, -1));

        nomeField.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        nomeField.setText("NOME");
        nomeField.setBorder(null);
        jPanel1.add(nomeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 398, 270, 30));

        nomeBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        jPanel1.add(nomeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 394, -1, -1));

        emailField.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        emailField.setText("EMAIL");
        emailField.setBorder(null);
        jPanel1.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 456, 270, 30));

        emailBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        jPanel1.add(emailBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 452, -1, -1));

        helpText.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        helpText.setText("não tem um login?");
        jPanel1.add(helpText, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        cadastrarButton.setFont(new java.awt.Font("JetBrains Mono", 2, 18)); // NOI18N
        cadastrarButton.setText("cadastrar");
        cadastrarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastrarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastrarButtonMouseClicked(evt);
            }
        });
        jPanel1.add(cadastrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 497, -1, -1));

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/voltar.png"))); // NOI18N
        voltarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarButtonMouseClicked(evt);
            }
        });
        jPanel1.add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 362, -1, -1));

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
    
    //Ir para a tela de Cadastro do Save
    private void cadastrarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarButtonMouseClicked
        nomeBox.show();
        nomeBox.enable();
        
        emailBox.show();
        emailBox.enable();
        
        emailField.show();
        emailField.enable();
        
        nomeField.show();
        nomeField.enable();
        
        cadastrar.show();
        cadastrar.enable();
        voltarButton.show();
        
        helpText.hide();
        loginBox.hide();
        loginField.hide();
        entrarButton.hide();
        cadastrarButton.hide();
    }//GEN-LAST:event_cadastrarButtonMouseClicked
    
    //Voltar para o Login
    private void voltarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarButtonMouseClicked

        telaLogin();
    }//GEN-LAST:event_voltarButtonMouseClicked
    
    //Login no aplicativo Save
    private void entrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButtonActionPerformed

        String login = loginField.getText();

        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            SaveService stub = (SaveService) registry.lookup("Save");

            Usuario user = new Usuario();

           user = stub.getUsuario(login);

            if (stub.login(login) == true) {

                if (user.getEmail().equals("root@admin.com")) {

                    AdminHome admin = new AdminHome(user);
                    admin.setVisible(true);

                    this.dispose();

                } else {
                    Home home = new Home(user);

                    home.setVisible(true);
                    this.dispose();
                }

            } else {
                mensagemPopUp("Login não encontrado ");

                System.out.println(stub.login(login));
            }

        } catch (Exception e) {
            System.out.println(e);
            mensagemPopUp("Login não encontrado ");
        }

    }//GEN-LAST:event_entrarButtonActionPerformed
    
    //Botão para cadastro dentro do Save
    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed

        String email = emailField.getText();
        String nome = nomeField.getText();

        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            SaveService stub = (SaveService) registry.lookup("Save");

            if (stub.cadastrar(email, nome) == true) {

                mensagemPopUp("Usuario " + nome + " cadastrado!");
                telaLogin();

            } else {
                mensagemPopUp("Email já cadastrado =(");

            }
            
        } catch (Exception e) {
            System.out.println(e);
            mensagemPopUp("Email já cadastrado =(");
        }
    }//GEN-LAST:event_cadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JLabel cadastrarButton;
    private javax.swing.JLabel emailBox;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton entrarButton;
    private javax.swing.JLabel helpText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginBox;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nomeBox;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel voltarButton;
    // End of variables declaration//GEN-END:variables
}
