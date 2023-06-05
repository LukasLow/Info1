//javac -classpath .:stdlib.jar Fractale.java
//java -classpath .:stdlib.jar Fractale 6

public class Fractale {
    // Methode zur Generierung einer zufälligen Zeichenkette aus F, L und R
    public static void randomSequence(int k) {
        // Überprüft, ob der eingegebene Wert k im gültigen Bereich liegt
        if (k < 0 || k > 100000) {
            System.out.println("Invalid length");
            return;
        }

        // Definiert mögliche Buchstaben für die zufällige Zeichenkette
        String alphabet = "FLR";
        // Erstellt einen StringBuilder mit der Größe k
        StringBuilder result = new StringBuilder(k);

        // Schleife, die k-mal läuft, um k Zeichen zur Zeichenkette hinzuzufügen
        for (int i = 0; i < k; i++) {
            // Wählt einen zufälligen Buchstaben (F, L, oder R) aus
            char randomChar = alphabet.charAt(StdRandom.uniform(alphabet.length()));
            // Fügt den zufälligen Buchstaben zum StringBuilder hinzu
            result.append(randomChar);
        }

        // printet das Ergebnis
        System.out.println(result.toString());
    }

    // Methode zur Erzeugung der Drachenkurve
    public static String dragonCurve(int k) {
        // Überprüft, ob der eingegebene Wert k im gültigen Bereich liegt
        if (k < 0 || k > 20) {
            System.out.println("Invalid order");
            return "";
        }

        // Initialisiert die Drachenkurve der Ordnung 0
        String dragon = "F";

        // Schleife, die k-mal durchläuft, um die Drachenkurve zu generieren
        for (int i = 0; i < k; i++) {
            // Erstellt einen umgekehrten String der aktuellen Drachenkurve
            StringBuilder sb = new StringBuilder(dragon);
            sb.reverse();
            String reverse = sb.toString();
            // Ersetzt die Zeichen in der umgekehrten Drachenkurve gemäß den Regeln
            reverse = reverse.replace('R', 't'); //ersetzt alle Rs mit t
            reverse = reverse.replace('L', 'R'); //ersetzt alle Ls mit R
            reverse = reverse.replace('t', 'L'); //ersetzt alle ts mit L

            // Generiert die nächste Iteration der Drachenkurve
            dragon = dragon + "R" + reverse;
        }

        // Gibt die generierte Drachenkurve zurück
        return dragon;
    }

    // Methode zur Erzeugung der Levy C Kurve
    public static String levyCurve(int k) {
        // Überprüft, ob der eingegebene Wert k im gültigen Bereich liegt
        if (k < 0 || k > 20) {
            System.out.println("Invalid order");
            return "";
        }

        // Initialisiert die Levy C Kurve mit dem Zeichen F
        String levy = "F";

        // Schleife, die k-mal läuft, um die Levy C Kurve zu machen
        for (int i = 0; i < k; i++) {
            // Durchläuft einen Prozess zur Erzeugung der nächsten Iteration der Lévy-C-Kurve
            String temp = levy.replace('F', 't'); // ersetzt alle Fs durch temporäres Zeichen ts
            temp = temp.replace('+', 'F'); // ersetzt alle '+ surch's'
            temp = temp.replace('-', '+'); // ersetzt alle -s durch +s
            temp = temp.replace('t', '-'); // ersetzt das temporäre Zeichen ts (ursprünglich 'F') durch -s
            levy = "+" + levy + "--" + levy + "+"; // erzeugt die nächste Iteration der Lévy-C-Kurve
            levy = levy.replace('F', 't'); // ersetzt alle Fs durch temporäres Zeichen ts
            levy = levy.replace('+', 'F'); // ersetzt alle +s durch Fs
            levy = levy.replace('-', '+'); // ersetzt alle -s durch +s
            levy = levy.replace('t', '-'); // ersetzt das temporäre Zeichen ts (ursprünglich Fs) durch -s
        }

        // Ersetzt die Zeichen in der Levy-C Kurve gemäß den Regeln
        levy = levy.replace('F', 't'); // ersetzt alle Fs durch ts
        levy = levy.replace('+', 'F'); // ersetzt alle +s durch Fs
        levy = levy.replace('-', 'R'); // ersetzt alle -s durch Rs
        levy = levy.replace('t', 'L'); // ersetzt alle ts durch Ls

        // Ausgabe der Levy C Curve
        return levy;
    }

    // Hauptmethode; startet das Programm
    public static void main(String[] args) {
        // Konvertiert das erste Kommandozeilenargument in einen Int
        int k = Integer.parseInt(args[0]);

        // Methode zur Generierung einer zufälligen Zeichenkette und Printen des Ergebnis
        System.out.println("Random sequence:");
        randomSequence(k);

        // Methode zur Generierung der dragon curve und Printen des Ergebnis
        System.out.println("\nDragon curve:");
        System.out.println(dragonCurve(k));

        // Methode zur Generierung der Levy C Curece und Printen des Ergebnis
        System.out.println("\nLevy C curve:");
        System.out.println(levyCurve(k));
    }
}
