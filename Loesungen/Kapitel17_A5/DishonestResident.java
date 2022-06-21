package Loesungen.Kapitel17_A5;

// Aufgabe 48
public class DishonestResident implements Taxpayer {
    private float declaredEarnings;
    private float dirtyMoney;
    private boolean willEvadeTax;

    public DishonestResident() {
        // pro-forma, float by default 0.0
        declaredEarnings = 0;
        dirtyMoney = 0;
        willEvadeTax = false;
    }

    public void earnMoney(float amount) {
        if (willEvadeTax) {
            declaredEarnings += amount;
        } else {
            dirtyMoney += amount;
        }
        willEvadeTax = !willEvadeTax;
    }

    public float getDeclaredEarnings() {
        return declaredEarnings;
    }

    public float payTax() {
        float tax = declaredEarnings * 0.2f;
        // subtract the tax from the declared earnings
        declaredEarnings -= tax;
        return tax;
    }
}
