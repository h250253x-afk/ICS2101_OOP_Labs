import java.util.ArrayList;
import java.util.List;

enum Coin {
    QUARTER(25), DIME(10), NICKEL(5), PENNY(1);

    private final int value;
    Coin(int value) { this.value = value; }

    public static List<Coin> getMinimumCoins(int cents) {
        List<Coin> result = new ArrayList<>();
        for (Coin c : values()) {
            while (cents >= c.value) {
                result.add(c);
                cents -= c.value;
            }
        }
        return result;
    }
}