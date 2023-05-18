package com.example;

import com.example.models.Filme;
import com.example.models.FilmeUsuario;
import com.example.models.Usuario;
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

public class Adicionar2 extends javax.swing.JFrame {
    
    Usuario user;
    Filme filme;
    boolean achou = false;
    
    List<FilmeUsuario> lista = new ArrayList<>();

    public Adicionar2() {
        initComponents();

    }

    public Adicionar2(Filme filme, Usuario user){
        initComponents();
        
        this.filme = filme;
        this.user = user;
        
        nomeFilme.setText(filme.getNomeFilme());
        anoFilme.setText(String.valueOf(filme.getAnoFilme()));
        filmePoster();
    }

    // Método para exibir filmes
    public void filmePoster() {
        try {

            nomeFilme.setText(filme.getNomeFilme());
            anoFilme.setText(Integer.toString(filme.getAnoFilme()));
            filmePoster.setIcon(poster(filme.getPosterFilme()));
            
        } catch (Exception ex) {
            Logger.getLogger(Filmes.class.getName()).log(Level.SEVERE, null, ex);
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
        voltarButton = new javax.swing.JButton();
        logoMini = new javax.swing.JLabel();
        anoFilme = new javax.swing.JLabel();
        nomeFilme = new javax.swing.JLabel();
        filmePoster = new javax.swing.JLabel();
        desc1 = new javax.swing.JLabel();
        likeButton = new javax.swing.JButton();
        notaSlider = new javax.swing.JSlider();
        desc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 50, -1));

        logoMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveLogoMini.png"))); // NOI18N
        jPanel1.add(logoMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 9, -1, -1));

        anoFilme.setFont(new java.awt.Font("Sansita One", 0, 32)); // NOI18N
        anoFilme.setForeground(new java.awt.Color(0, 0, 0));
        anoFilme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anoFilme.setText("ANO");
        anoFilme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(anoFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 98, 808, -1));

        nomeFilme.setFont(new java.awt.Font("Sansita One", 0, 32)); // NOI18N
        nomeFilme.setForeground(new java.awt.Color(0, 0, 0));
        nomeFilme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeFilme.setText("FILME");
        nomeFilme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nomeFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 58, 808, -1));
        jPanel1.add(filmePoster, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 140, 193, 255));

        desc1.setFont(new java.awt.Font("Sansita One", 0, 24)); // NOI18N
        desc1.setForeground(new java.awt.Color(0, 0, 0));
        desc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desc1.setText("Nota:");
        desc1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(desc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 808, -1));

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
        jPanel1.add(likeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 516, 808, -1));

        notaSlider.setForeground(new java.awt.Color(0, 0, 0));
        notaSlider.setMajorTickSpacing(1);
        notaSlider.setMaximum(5);
        notaSlider.setMinimum(1);
        notaSlider.setToolTipText("1 a 5");
        notaSlider.setValue(1);
        notaSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(notaSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 170, 20));
        notaSlider.getAccessibleContext().setAccessibleName("Nota");

        desc.setFont(new java.awt.Font("Sansita", 0, 20)); // NOI18N
        desc.setForeground(new java.awt.Color(0, 0, 0));
        desc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desc.setText("deseja adicionar esse filme à sua lista?");
        desc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 808, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeButtonActionPerformed
        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);

            Save stub = (Save) registry.lookup("Save");

            filme.setNotaFilme(notaSlider.getValue());

            lista = stub.getFilmeUsuario(user.getEmail());

            for (FilmeUsuario filmeUsuario : lista) {
                if (filmeUsuario.getNomeFilme().equals(filme.getNomeFilme())) {
                    achou = true;
                };
            }

            if (achou) {
                
                mensagemPopUp("Erro ao adicionar filme. Você já possue em seu Save!!!");
                this.dispose();

            } else {
                
                stub.adicionarFilme2(filme, user.getEmail());
                mensagemPopUp("Filme " + filme.getNomeFilme() + " adicionado com sucesso!");
                this.dispose();

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_likeButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
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
            java.util.logging.Logger.getLogger(Adicionar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adicionar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adicionar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adicionar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Adicionar2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anoFilme;
    private javax.swing.JLabel desc;
    private javax.swing.JLabel desc1;
    private javax.swing.JLabel filmePoster;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton likeButton;
    private javax.swing.JLabel logoMini;
    private javax.swing.JLabel nomeFilme;
    private javax.swing.JSlider notaSlider;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
