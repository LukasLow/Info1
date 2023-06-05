//javac -classpath .:stdlib.jar Fractale.java
//java -classpath .:stdlib.jar Fractale

public class Fractale {
    // Generierung einer zufälligen Zeichenkette aus F, L und R
    public static void randomSequence(int k) {
        if (k < 0 || k > 100000) {
            System.out.println("Invalid length");
            return;
        }

        String alphabet = "FLR";
        StringBuilder result = new StringBuilder(k);

        for (int i = 0; i < k; i++) {
            char randomChar = alphabet.charAt(StdRandom.uniform(alphabet.length()));
            result.append(randomChar);
        }

        System.out.println(result.toString());
    }

    // Erzeugung der Drachenkurve
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

    // Erzeugung der Lévy-C-Kurve
    public static String levyCurve(int k) {
        if (k < 0 || k > 20) {
            System.out.println("Invalid order");
            return "";
        }

        String levy = "F";

        for (int i = 0; i < k; i++) {
            String temp = levy.replace('F', 't');
            temp = temp.replace('+', 'F');
            temp = temp.replace('-', '+');
            temp = temp.replace('t', '-');
            levy = "+" + levy + "--" + levy + "+";
            levy = levy.replace('F', 't');
            levy = levy.replace('+', 'F');
            levy = levy.replace('-', '+');
            levy = levy.replace('t', '-');
        }

        levy = levy.replace('F', 't');
        levy = levy.replace('+', 'F');
        levy = levy.replace('-', 'R');
        levy = levy.replace('t', 'L');

        return levy;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        System.out.println("Random sequence:");
        randomSequence(k);
        System.out.println("\nDragon curve:");
        System.out.println(dragonCurve(k));
        System.out.println("\nLevy C curve:");
        System.out.println(levyCurve(k));
    }
}
