package sample;

public class Test {
    public static void main(String[] args) {
        double y = 40;
        double x = 43;

        double a = 1.5;
        double b = 1;
        double c = 1;
        double d = 3;

        double t0 = 0;
        double tk = 100;
        double dt = 0.25;

        CalkaLotkiVolterry populacja = new CalkaLotkiVolterry(dt, t0, tk, x, y, a, b, c, d);
        System.out.println(populacja.getEulerX().length);
        populacja.calkowanie();

    }


}
