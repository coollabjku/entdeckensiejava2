package Loesungen.Kapitel17_A5;

// Aufgabe 48
public class ResidentWithChildren implements Taxpayer {
    private float declaredEarnings;
    private float taxFreeEarnings;

    // TODO: no name for this variable specified
    private int childCount;

    public ResidentWithChildren(int childCount) {
        // pro-forma, float by default 0.0
        declaredEarnings = 0;
        taxFreeEarnings = 0;
        this.childCount = childCount;
    }

    public void earnMoney(float amount) {
        taxFreeEarnings += amount * childCount * 0.1;
        declaredEarnings += amount * (1 - childCount * 0.1);
    }

    public float getDeclaredEarnings() {
        return declaredEarnings;
    }

    public float payTax() {
        float tax = declaredEarnings * 0.18f;
        // subtract the tax from the declared earnings
        declaredEarnings -= tax;
        return tax;
    }
}
