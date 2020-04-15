import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName;
    private String lastName;
    private String ssn;
    private String email;
    private String phone;
    private long accountNumber;
    private String balance;

    private List<Trades> stockTrades = new ArrayList<Trades>();

    public Person(JSONObject person) {
        this.setFirstName((String)person.get("first_name"));
        this.setLastName((String)person.get("last_name"));
        this.setSsn((String)person.get("ssn"));
        this.setEmail((String)person.get("email"));
        this.setPhone((String)person.get("phone"));
        this.setAccountNumber((long)person.get("account_number"));
        this.setBalance((String)person.get("beginning_balance"));
        JSONArray countShares = (JSONArray) person.get("stock_trades");
        countShares.forEach( trades -> stockTrades.add(new Trades((JSONObject) trades)));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public List<Trades> getStockTrades() {
        return stockTrades;
    }

    public void setStockTrades(List<Trades> stockTrades) {
        this.stockTrades = stockTrades;
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName + " lastName: " + lastName;
    }

}
