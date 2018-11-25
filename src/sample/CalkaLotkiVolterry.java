package sample;

public class CalkaLotkiVolterry {
    private double dt;
    private double t0;
    private double tk;
    private double x0;
    private double y0;
    private double a;
    private double b;
    private double c;
    private double d;

    double[] t;

    double[] eulerX;
    double[] eulerY;

    public CalkaLotkiVolterry(double dt, double t0, double tk, double x0, double y0, double a, double b, double c, double d) {
        this.dt = dt;
        this.t0 = t0;
        this.tk = tk;
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        this.eulerX = new double[(int) ((tk - t0) / dt) + 1];
        this.eulerY = new double[(int) ((tk - t0) / dt) + 1];
        this.t = new double[(int) ((tk - t0) / dt) + 1];
        this.t[0] = t0;
        for (int n = 1; n < ((tk - t0) / dt) + 1; n++) {
            this.t[n] = t[n - 1] + dt;
        }
    }


    public double[] getEulerX() {
        return eulerX;
    }

    public double[] getEulerY() {
        return eulerY;
    }

    private double calcdxValue(double x, double y) {
        return (a - (b * y)) * x;
    }

    private double calcdyValue(double x, double y) {
        return (c * x - d) * y;
    }


    public void calkowanie() {

        eulerX[0] = x0;
        System.out.println(eulerX[0]);
        eulerY[0] = y0;
        System.out.println(eulerY[0]);

        for (int n = 1; n < ((tk - t0) / dt) + 1; n++) {
            eulerX[n] = x0 / (1 - (a - b * eulerY[n - 1]) * t[n]);
            System.out.println(eulerX[n]);
            eulerY[n] = y0/(1-(c*eulerX[n-1]*t[n]));
            System.out.println(eulerY[n]);
        }

    }
}
