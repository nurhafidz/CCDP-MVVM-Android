package ac.id.unikom.challenge;

public class Meter {
    private static Meter instance;
    private double meter;

    private Meter() {
        this.meter = 0;
    }

    public static synchronized Meter getInstance() {
        if (instance == null) {
            instance = new Meter();
        }
        return instance;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public String toKilometer() {
        return String.valueOf(meter / 1000);
    }

    public String toCentimeter() {
        return String.valueOf(meter * 100);
    }
}
