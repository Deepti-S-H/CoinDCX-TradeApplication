package com.example.mavenproject;
import java.util.Scanner;

import com.example.TradeManager;

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter trigger buy price: ");
        double triggerBuyPrice = scanner.nextDouble();

        System.out.print("Enter trigger sell price: ");
        double triggerSellPrice = scanner.nextDouble();

        TradeManager tradeManager = new TradeManager(triggerBuyPrice, triggerSellPrice);

        // Simulate market data (this would be replaced by actual WebSocket data)
        double[] marketPrices = {45000, 47000, 48000, 44000, 46000}; // Simulated prices

        for (double price : marketPrices) {
            System.out.println("Current market price: " + price);
            tradeManager.handleMarketPrice(price);
        }

        scanner.close();
    }
    
}
