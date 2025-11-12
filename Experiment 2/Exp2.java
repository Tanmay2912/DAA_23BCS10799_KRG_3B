package DAA;

public class Exp2 {
    public static double power(double x, int y) {
        if (y == 0)
            return 1;
        double temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else {
            if (y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

    public static void main(String[] args) {
        double x = 2.0;
        int y = 3;
        System.out.println(x + " raised to power " + y + " is: " + power(x, y));
    }
}
