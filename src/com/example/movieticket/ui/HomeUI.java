package com.example.movieticket.ui;

import com.example.movieticket.controller.BookingController;
import com.example.movieticket.model.Show;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class HomeUI extends JFrame {
    private final BookingController controller = new BookingController();
    private final String user;
    private final JComboBox<String> genreBox = new JComboBox<>(new String[]{"Action","Comedy"});
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> showList = new JList<>(listModel);
    private final JButton continueBtn = new JButton("Continue");
    private List<Show> currentShows;

    public HomeUI(String user) {
        this.user = user;
        setTitle("Movie Ticket Booking - " + user);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.add(new JLabel("Genre:")); top.add(genreBox);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(showList), BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.add(continueBtn);
        add(bottom, BorderLayout.SOUTH);
        setSize(500,400);
        setLocationRelativeTo(null);

        genreBox.addActionListener(e -> refreshShows());
        continueBtn.addActionListener(e -> openSeatSelection());
        refreshShows();
    }

    private void refreshShows() {
        String g = (String) genreBox.getSelectedItem();
        currentShows = controller.searchShowsByGenre(g);
        listModel.clear();
        for (Show s : currentShows) listModel.addElement(s.getMovie().getTitle() + " @ " + s.getTime() + " (" + s.getTheater().getName() + ")");
    }

    private void openSeatSelection() {
        int idx = showList.getSelectedIndex();
        if (idx < 0) { JOptionPane.showMessageDialog(this, "Select a show"); return; }
        Show show = currentShows.get(idx);
        new SeatSelectionUI(user, show).setVisible(true);
        dispose();
    }
}
