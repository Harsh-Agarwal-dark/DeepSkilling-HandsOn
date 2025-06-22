package Exercise7;

import java.util.ArrayList;
import java.util.List;

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(String stockName, double stockPrice);
}

class StockMarket implements Stock {
    List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();  // Trigger update
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }
}

class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println(" [Mobile] " + user + ": " + stockName + " is now $" + stockPrice);
    }
}

class WebApp implements Observer {
    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println("[Web] " + user + ": " + stockName + " is now $" + stockPrice);
    }
}   

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        market.registerObserver(mobileUser);
        market.registerObserver(webUser);

        System.out.println("Updating Stock Price: TCS");
        market.setStock("TCS", 3550.75);

        System.out.println("\nUnsubscribing Web User...");
        market.removeObserver(webUser);

        System.out.println("\nUpdating Stock Price: INFY");
        market.setStock("INFY", 1480.25);
    }   
}
