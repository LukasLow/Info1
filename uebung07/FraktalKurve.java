//javac -classpath .:stdlib.jar FraktalKurve.java
//java -classpath .:stdlib.jar FraktalKurve

public class FraktalKurve{
 public static void main(String args[]){
        int k = StdIn.readInt();
        if(k > 100000 || k < 0 ){
                StdOut.println("ungültige Zahl");
        }
        else{
                String randomKette = zeichenkette(k);
                StdOut.println(randomKette);
        }

 }
 public static String zeichenkette(int k){
        StringBuilder sb = new StringBuilder();
        String FRL = "FRL";

        StdOut.println(k);

        for (int i = 0; i < k; i++){
                int index = StdRandom.uniform(FRL.length());
                char randomFRL = FRL.charAt(index);
                sb.append(randomFRL);
        }
        return sb.toString();
 }

}
