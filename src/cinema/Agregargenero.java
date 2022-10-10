/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Axel
 */
public class Agregargenero extends javax.swing.JFrame {

    /**
     * Creates new form Agregargenero
     */
    FondoPanel fondo = new FondoPanel();
    public Agregargenero() {
       this.setContentPane(fondo);

        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Bienvenido");
     ImageIcon ImageIcon = new ImageIcon(getClass().getResource("/Img/icon.png"));
        Image Image = ImageIcon.getImage();
        this.setIconImage(Image);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltitulog = new javax.swing.JLabel();
        lblgenero = new javax.swing.JLabel();
        txtgenero = new javax.swing.JTextField();
        btnañadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbltitulog.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lbltitulog.setForeground(new java.awt.Color(255, 255, 255));
        lbltitulog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitulog.setText("Añadir genero");

        lblgenero.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblgenero.setForeground(new java.awt.Color(255, 255, 255));
        lblgenero.setText("Genero:");

        btnañadir.setBackground(new java.awt.Color(102, 255, 102));
        btnañadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        btnañadir.setText("Añadir");
        btnañadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblgenero)
                .addGap(18, 18, 18)
                .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnañadir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(lbltitulog, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulog, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(btnañadir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnañadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnañadirActionPerformed
  String genero = txtgenero.getText();
        DBGenero c1 = new DBGenero();
        Encapsulamientogenero e1 = new Encapsulamientogenero();
        e1.setGenero(genero);
        c1.agregargenero(e1);
    }//GEN-LAST:event_btnañadirActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Agregargenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregargenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregargenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregargenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregargenero().setVisible(true);
            }
        });
    }
 class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Img/cartelera.jpg")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnañadir;
    private javax.swing.JLabel lblgenero;
    private javax.swing.JLabel lbltitulog;
    private javax.swing.JTextField txtgenero;
    // End of variables declaration//GEN-END:variables
}