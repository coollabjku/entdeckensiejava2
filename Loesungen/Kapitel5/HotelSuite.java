package Loesungen.Kapitel5;

// Aufgabe 12
public class HotelSuite extends HotelRoom implements Safe {

    private int moneyInSafe;

    public HotelSuite(boolean doubleBed, int roomNo, int floorNo, int moneyInSafe) {
        super(doubleBed, roomNo, floorNo);
        this.moneyInSafe = moneyInSafe;
    }

    @Override
    public int getMoney(int amount) throws Exception {
        if (amount >= this.moneyInSafe) {
            throw new Exception("Not enough money in safe!");
        }
        this.moneyInSafe -= amount;
        return this.moneyInSafe;
    }

    @Override
    public void putMoney(int money) {
        this.moneyInSafe += money;
    }

    public int getMoneyInSafe() {
        return moneyInSafe;
    }

    public static void main(String[] args) {
        HotelSuite room = new HotelSuite(true, 13, 2, 200);
        room.putMoney(120);
        try {
            room.getMoney(30);
            System.out.println("Money currently in Safe: " + room.getMoneyInSafe());
            room.getMoney(40);
            System.out.println("Money currently in Safe: " + room.getMoneyInSafe());
            room.getMoney(830);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Money currently in Safe: " + room.getMoneyInSafe());
    }
}