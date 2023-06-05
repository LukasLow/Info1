//javac -classpath .:stdlib.jar Fractal.java
//java -classpath .:stdlib.jar Fractal.java 5

public class Fractal {
    public static String dragonCurve(int k) {
        if (k < 0 || k > 20) {
            System.out.println("Invalid order");
            return "";
        }

        String dragon = "F";

        for (int i = 0; i < k; i++) {
            StringBuilder sb = new StringBuilder(dragon);
            sb.reverse();
            String reverse = sb.toString();
            reverse = reverse.replace('R', 't');
            reverse = reverse.replace('L', 'R');
            reverse = reverse.replace('t', 'L');

            dragon = dragon + "R" + reverse;
        }

        return dragon;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        System.out.println(dragonCurve(k));
    }
}
