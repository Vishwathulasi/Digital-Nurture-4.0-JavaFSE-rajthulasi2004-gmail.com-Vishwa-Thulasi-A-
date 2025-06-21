package Exercise_7_Implementing_The_Observer_Pattern;

// import java.util.Observer;


import java.util.ArrayList;
import java.util.List;


interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer {
    void update(String stockName, double stockPrice);
}

class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName) {
        this.stockName = stockName;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double newPrice) {
        this.stockPrice = newPrice;
        System.out.println("\n[StockMarket] " + stockName + " price updated to ₹" + stockPrice);
        notifyObservers();
    }
}

class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("MobileApp - " + user + ": " + stockName + " is now ₹" + stockPrice);
    }
}

class WebApp implements Observer {
    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("WebApp - " + user + ": " + stockName + " is now ₹" + stockPrice);
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        StockMarket tcsStock = new StockMarket("TCS");

        Observer mobileUser = new MobileApp("Vishwa");
        Observer webUser = new WebApp("Thulasi");

        tcsStock.registerObserver(mobileUser);
        tcsStock.registerObserver(webUser);

        tcsStock.setStockPrice(3450.75);
        tcsStock.setStockPrice(3521.50);

        tcsStock.removeObserver(webUser);

        tcsStock.setStockPrice(3589.00);
    }
}
