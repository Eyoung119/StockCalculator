public class Trades {

    private String type;
    private String symbol;
    private String pricePerShare;
    private int shares;
    private int totalAmount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(String pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
