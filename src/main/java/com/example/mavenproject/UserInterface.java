package com.example.mavenproject;
import com.example.TradeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {

    private JFrame frame;
    private JTextField buyPriceField;
    private JTextField sellPriceField;
    private JTextArea outputArea;
    private TradeManager tradeManager;
    private double currentPrice = 45000.0;  // Simulate a starting market price

    public UserInterface() {
        // Initialize the frame
        frame = new JFrame("Trade Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create UI components
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel buyPriceLabel = new JLabel("Trigger Buy Price:");
        buyPriceField = new JTextField();
        JLabel sellPriceLabel = new JLabel("Trigger Sell Price:");
        sellPriceField = new JTextField();
        JButton startButton = new JButton("Start Trading");

        // Add components to the input panel
        inputPanel.add(buyPriceLabel);
        inputPanel.add(buyPriceField);
        inputPanel.add(sellPriceLabel);
        inputPanel.add(sellPriceField);
        inputPanel.add(startButton);

        // Output area to display the results
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add the input panel and output area to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button action to start trading
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double triggerBuyPrice = Double.parseDouble(buyPriceField.getText());
                    double triggerSellPrice = Double.parseDouble(sellPriceField.getText());
                    tradeManager = new TradeManager(triggerBuyPrice, triggerSellPrice);
                    outputArea.append("Trading started...\n");

                    // Simulate market price changes (for demonstration purposes)
                    simulateMarket();
                } catch (NumberFormatException ex) {
                    outputArea.append("Invalid input. Please enter valid numbers.\n");
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    private void simulateMarket() {
        // Simulate market prices and trading in a separate thread
        new Thread(() -> {
            for (int i = 0; i < 10; i++) { // Simulate 10 price changes
                currentPrice += (Math.random() * 1000 - 500); // Random price fluctuation
                double price = Math.round(currentPrice * 100.0) / 100.0; // Round to 2 decimals

                SwingUtilities.invokeLater(() -> {
                    outputArea.append("Current market price: " + price + "\n");
                    tradeManager.handleMarketPrice(price);
                });

                try {
                    Thread.sleep(2000); // Wait 2 seconds between updates
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInterface());
    }
}
