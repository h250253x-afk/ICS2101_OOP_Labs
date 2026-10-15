public class Temperature2 {
    // Internal representation stored strictly in Kelvin
    private double kelvin;

    // Constructor enforcing absolute zero boundary
    public Temperature2(double kelvin) {
        setKelvin(kelvin);
    }

    public void setKelvin(double kelvin) {
        if (kelvin < 0.0) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero (0 K). Received: " + kelvin + " K");
        }
        this.kelvin = kelvin;
    }

    public double getKelvin() { return kelvin; }

    // Public exposure in Celsius
    public double getCelsius() { return kelvin - 273.15; }
    public void setCelsius(double celsius) {
        setKelvin(celsius + 273.15);
    }

    // Public exposure in Fahrenheit
    public double getFahrenheit() { return (kelvin - 273.15) * 9 / 5 + 32; }
    public void setFahrenheit(double fahrenheit) {
        setKelvin((fahrenheit - 32) * 5 / 9 + 273.15);
    }

    public static void main(String[] args) {

        Temperature2 temp = new Temperature2(300.0); // 300 K
        System.out.printf("Initial Kelvin: %.2f K | Celsius: %.2f °C | Fahrenheit: %.2f °F%n",
                temp.getKelvin(), temp.getCelsius(), temp.getFahrenheit());

        temp.setCelsius(25.0);
        System.out.printf("Updated to 25 °C: Kelvin: %.2f K | Fahrenheit: %.2f °F%n",
                temp.getKelvin(), temp.getFahrenheit());

        // Testing absolute zero violation check
        System.out.println("\n--- Testing Absolute Zero Protection ---");
        try {
            temp.setCelsius(-300.0); // Below -273.15 °C
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
