package Loesungen.Kapitel5;

public interface Safe {
    int getMoney(int amount) throws Exception;

    void putMoney(int money);
}