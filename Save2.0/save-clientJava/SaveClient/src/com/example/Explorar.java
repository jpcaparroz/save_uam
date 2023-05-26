package com.example;

import com.api.server.rmi.modules.FilmeUsuario;
import com.api.server.rmi.modules.Usuario;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.api.server.rmi.SaveService;

public class Explorar extends javax.swing.JFrame {
    
    Usuario user;
    
    List<FilmeUsuario> listaFilme = new ArrayList<>();
    int count = 0;
    int countMax = 0;

    public Explorar() {
        initComponents();

    }

    public Explorar(Usuario user){
        initComponents();
        
        filmePoster();
        this.user = user;
    }

    // Método para exibir filmes
    public void filmePoster() {

        if (listaFilme.isEmpty()) {
            mensagemPopUp("O banco Save não possue filmes");
        } else {

            try {

                nomeFilme.setText(listaFilme.get(count).getNomeFilme());
                anoFilme.setText(Integer.toString(listaFilme.get(count).getAnoFilme()));

                switch (listaFilme.get(count).getNotaFilme()) {
                    case 1:

                        notaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nota1.png")));
                        break;
                    case 2:

                        notaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nota2.png")));
                        break;
                    case 3:

                        notaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nota3.png")));
                        break;
                    case 4:

                        notaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nota4.png")));
                        break;
                    case 5:

                        notaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nota5.png")));
                        break;
                    default:
                        notaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nota1.png")));
                }

                filmePoster.setIcon(poster(listaFilme.get(count).getPosterFilme()));

            } catch (Exception ex) {
                Logger.getLogger(Filmes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    //Método para redimensionar o poster
    public Icon poster(String imagem) throws Exception{
        
        if (imagem.contains("https")) {
            
            InputStream inputStream = new URL(imagem).openStream();
            Image posterImage = ImageIO.read(inputStream);
        
            Image nova = posterImage.getScaledInstance(220, 270, Image.SCALE_SMOOTH);
        
            ImageIcon icon = new ImageIcon(nova);
            return icon;
            
        } else {
            imagem = "https://t4.ftcdn.net/jpg/02/14/06/71/360_F_214067110_eB6LNUMWR8nSXSTEG1SSpJGfkS7c9zMd.jpg";
            InputStream inputStream = new URL(imagem).openStream();
            Image posterImage = ImageIO.read(inputStream);
        
            Image nova = posterImage.getScaledInstance(220, 270, Image.SCALE_SMOOTH);
        
            ImageIcon icon = new ImageIcon(nova);
            return icon;
            
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
        logoMini = new javax.swing.JLabel();
        voltarButton = new javax.swing.JButton();
        explorarBox = new javax.swing.JLabel();
        esqButton = new javax.swing.JButton();
        dirButton = new javax.swing.JButton();
        anoFilme = new javax.swing.JLabel();
        notaFilme = new javax.swing.JLabel();
        nomeFilme = new javax.swing.JLabel();
        filmePoster = new javax.swing.JLabel();
        likeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        explorarBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/explorarBox.png"))); // NOI18N
        jPanel1.add(explorarBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 51, -1, -1));

        esqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/setaEsqIcon.png"))); // NOI18N
        esqButton.setBorder(null);
        esqButton.setBorderPainted(false);
        esqButton.setContentAreaFilled(false);
        esqButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        esqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esqButtonActionPerformed(evt);
            }
        });
        jPanel1.add(esqButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 359, -1, -1));

        dirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/setaDirIcon.png"))); // NOI18N
        dirButton.setBorder(null);
        dirButton.setBorderPainted(false);
        dirButton.setContentAreaFilled(false);
        dirButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirButtonActionPerformed(evt);
            }
        });
        jPanel1.add(dirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 359, -1, -1));

        anoFilme.setFont(new java.awt.Font("Sansita One", 0, 32)); // NOI18N
        anoFilme.setForeground(new java.awt.Color(0, 0, 0));
        anoFilme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anoFilme.setText("ANO");
        anoFilme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(anoFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 206, 320, -1));

        notaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nota1.png"))); // NOI18N
        jPanel1.add(notaFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 536, -1, -1));

        nomeFilme.setFont(new java.awt.Font("Sansita One", 0, 32)); // NOI18N
        nomeFilme.setForeground(new java.awt.Color(0, 0, 0));
        nomeFilme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeFilme.setText("FILME");
        nomeFilme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nomeFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 173, 320, -1));
        jPanel1.add(filmePoster, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 256, 193, 255));

        likeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/likeButton.png"))); // NOI18N
        likeButton.setBorder(null);
        likeButton.setBorderPainted(false);
        likeButton.setContentAreaFilled(false);
        likeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        likeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/likeButtonPressed.png"))); // NOI18N
        likeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/likeButtonPressed.png"))); // NOI18N
        likeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(likeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 673, -1, -1));

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
        Home home = new Home(user);
        
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void esqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esqButtonActionPerformed

        if (count == 0) {
            mensagemPopUp("Não possue mais filme");
        } else {
            count--;
            filmePoster();
        }
    }//GEN-LAST:event_esqButtonActionPerformed

    private void dirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirButtonActionPerformed

        if (count + 1 == countMax) {
            mensagemPopUp("Não possue mais filme");
        } else {
            count++;
            filmePoster();
        }
    }//GEN-LAST:event_dirButtonActionPerformed

    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeButtonActionPerformed
        FilmeUsuario filme = listaFilme.get(count);
        Adicionar adicionar = new Adicionar(filme, this.user);
        
        adicionar.setVisible(true);
    }//GEN-LAST:event_likeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Explorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Explorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Explorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Explorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Explorar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anoFilme;
    private javax.swing.JButton dirButton;
    private javax.swing.JButton esqButton;
    private javax.swing.JLabel explorarBox;
    private javax.swing.JLabel filmePoster;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton likeButton;
    private javax.swing.JLabel logoMini;
    private javax.swing.JLabel nomeFilme;
    private javax.swing.JLabel notaFilme;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
