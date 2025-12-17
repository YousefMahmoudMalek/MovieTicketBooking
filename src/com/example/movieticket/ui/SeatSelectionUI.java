package com.example.movieticket.ui;

import com.example.movieticket.controller.BookingController;
import com.example.movieticket.model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SeatSelectionUI extends JFrame {
    private final String user;
    private final Show show;
    private final BookingController controller = new BookingController();
    private final JToggleButton[][] seatButtons;
    private final JButton completeBtn = new JButton("Complete Booking");

    public SeatSelectionUI(String user, Show show) {
        this.user = user; this.show = show;
        setTitle("Choose Seats - " + show.getMovie().getTitle());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        int rows = show.getRows();
        int cols = show.getCols();
        JPanel grid = new JPanel(new GridLayout(rows, cols, 10, 10));
        seatButtons = new JToggleButton[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String label = "" + (char)('A' + r) + (c+1);
                JToggleButton b = new JToggleButton(label);
                if (show.isReserved(r,c)) { b.setEnabled(false); b.setText(label + " (X)"); }
                seatButtons[r][c] = b;
                grid.add(b);
            }
        }
        add(grid, BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.add(completeBtn);
        add(bottom, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);

        completeBtn.addActionListener(e -> onComplete());
    }

    private void onComplete() {
        List<int[]> selected = new ArrayList<>();
        for (int r = 0; r < seatButtons.length; r++) {
            for (int c = 0; c < seatButtons[0].length; c++) {
                if (seatButtons[r][c].isSelected()) selected.add(new int[]{r,c});
            }
        }
        if (selected.isEmpty()) { JOptionPane.showMessageDialog(this, "Select at least one seat"); return; }
        boolean ok = controller.reserveTickets(user, show, selected);
        if (ok) {
            JOptionPane.showMessageDialog(this, "Booking complete!");
            new HomeUI(user).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Booking failed (maybe seats taken or not logged in).");
        }
    }
}
