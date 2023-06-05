package Apps.GitHub.Info1.uebung07;
import edu.princeton.cs.introcs.StdRandom;


public class Fractal {
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

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        randomSequence(k);
    }
}
