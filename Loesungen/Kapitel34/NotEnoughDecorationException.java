package Loesungen.Kapitel34;

public class NotEnoughDecorationException extends IllegalArgumentException {
    private int balls;
    private int stars;

    public NotEnoughDecorationException(int balls, int stars) {
        super();
        this.balls = balls;
        this.stars = stars;
    }

    @Override
    public String getMessage() {
        String str = "";
        if (balls <= 0) {
            str += balls + " balls are not enough";
        }
        if (stars <= 0) {
            if (!str.equals("")) {
                str = str + " and ";
            }
            str += stars + " stars are not enough";
        }
        return str;
    }
}
