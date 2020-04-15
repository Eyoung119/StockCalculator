import org.json.simple.JSONObject;

public class Trades {

    private String type;
    private String symbol;
    private String pricePerShare;
    private long shares;
    private int totalAmount;

    public Trades(JSONObject stockTrade) {
        this.setType((String) stockTrade.get("type"));
        this.setSymbol((String) stockTrade.get("stock_symbol"));
        this.setShares((long) stockTrade.get("count_shares"));
        this.setPricePerShare((String) stockTrade.get("price_per_share"));
    }

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

    public long getShares() {
        return shares;
    }

    public void setShares(long shares) {
        this.shares = shares;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
