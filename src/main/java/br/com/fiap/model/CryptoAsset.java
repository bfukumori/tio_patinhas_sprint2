package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.UUID;

public class CryptoAsset {
    private final UUID id;
    private final String assetName;
    private final String symbol;
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

    public String getAssetName() {
        return assetName;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
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
