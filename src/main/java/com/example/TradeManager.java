package com.example;

public class TradeManager {
    private double triggerBuyPrice;
    private double triggerSellPrice;

    public TradeManager(double triggerBuyPrice, double triggerSellPrice) {
        this.triggerBuyPrice = triggerBuyPrice;
        this.triggerSellPrice = triggerSellPrice;
    }

    public void handleMarketPrice(double currentPrice) {
        if (currentPrice <= triggerBuyPrice) {
            prepareBuyOrder(currentPrice);
        } else if (currentPrice >= triggerSellPrice) {
            prepareSellOrder(currentPrice);
        }
    }

    private void prepareBuyOrder(double currentPrice) {
        System.out.println("Buy order prepared at price: " + currentPrice);
        // Simulate the payload for a buy order
        String payload = String.format("{ \"order\": \"buy\", \"price\": %.2f }", currentPrice);
        System.out.println("Payload: " + payload);
    }

    private void prepareSellOrder(double currentPrice) {
        System.out.println("Sell order prepared at price: " + currentPrice);
        // Simulate the payload for a sell order
        String payload = String.format("{ \"order\": \"sell\", \"price\": %.2f }", currentPrice);
        System.out.println("Payload: " + payload);
    }
}
