package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.UUID;

public class CryptoAsset {
    private UUID id;
    private String assetName;
    private String symbol;
    private BigDecimal currentPrice;

    public CryptoAsset(UUID id, String assetName, String symbol, BigDecimal currentPrice) {
        this.id = id;
        this.assetName = assetName;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    public CryptoAsset(String assetName, String symbol, BigDecimal currentPrice) {
        this.id = UUID.randomUUID();
        this.assetName = assetName;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void updatePrice(BigDecimal newPrice) {
        this.currentPrice = newPrice;
    }

    @Override
    public String toString() {
        return "CryptoAsset{" +
                "id=" + id +
                ", assetName='" + assetName + '\'' +
                ", symbol='" + symbol + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
