public class Temperature {
    private final double kelvin;

    private Temperature(double kelvin) {
        this.kelvin = kelvin;
    }

    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius + 273.15);
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) * 5 / 9 + 273.15);
    }

    public double getCelcius(){
        return kelvin - 273.15;
    }

    public double getFahrenheit() {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }   

    public static void main(String[] args) {
        Temperature tempC = Temperature.fromCelsius(25);
        System.out.println("Temperature in Celsius: " + tempC.getCelcius());
        System.out.println("Temperature in Fahrenheit: " + tempC.getFahrenheit());

        Temperature tempF = Temperature.fromFahrenheit(77.5);
        System.out.println("Temperature in Celsius: " + tempF.getCelcius());
        System.out.println("Temperature in Fahrenheit: " + tempF.getFahrenheit());
    }
}
