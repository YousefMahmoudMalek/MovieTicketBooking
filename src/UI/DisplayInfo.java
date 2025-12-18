/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import model.Show;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author youse
 */
public class DisplayInfo extends javax.swing.JFrame {

    private String user;
    private Show show;
    private List<int[]> selectedSeats;

    public DisplayInfo() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public DisplayInfo(String user, Show show, List<int[]> selectedSeats) {
        this();
        this.user = user;
        this.show = show;
        this.selectedSeats = selectedSeats;
        displayBookingInfo();
    }

    private void displayBookingInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Booking Confirmed!\n\n");
        info.append("User: ").append(user).append("\n");
        info.append("Movie: ").append(show.getMovie().getTitle()).append("\n");
        info.append("Genre: ").append(show.getMovie().getGenre()).append("\n");
        info.append("Theater: ").append(show.getTheater().getName()).append("\n");
        info.append("Time: ").append(show.getTime()).append("\n");
        info.append("Seats: ");
        for (int i = 0; i < selectedSeats.size(); i++) {
            int[] seat = selectedSeats.get(i);
            info.append((char)('A' + seat[0])).append(seat[1] + 1);
            if (i < selectedSeats.size() - 1) info.append(", ");
        }
        info.append("\n");
        info.append("Price per ticket: $").append(show.getPrice()).append("\n");
        info.append("Total: $").append(show.getPrice() * selectedSeats.size());

        infoTextArea.setText(info.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        bookAgainButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Booking Information");

        infoTextArea.setEditable(false);
        infoTextArea.setColumns(20);
        infoTextArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        infoTextArea.setRows(5);
        jScrollPane1.setViewportView(infoTextArea);

        bookAgainButton.setBackground(new java.awt.Color(100, 149, 237));
        bookAgainButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bookAgainButton.setForeground(new java.awt.Color(255, 255, 255));
        bookAgainButton.setText("Book Again");
        bookAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAgainButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(220, 53, 69));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bookAgainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookAgainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void bookAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenuFrame frame = new MainMenuFrame(user);
        this.dispose();
        frame.setVisible(true);
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        model.SessionManager.getInstance().logout(user);
        LoginFrame frame = new LoginFrame();
        this.dispose();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookAgainButton;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    // End of variables declaration//GEN-END:variables
}
