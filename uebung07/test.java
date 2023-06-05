public static void main(String args[]){
        int k = StdIn.readInt();
        char c = StdIn.readChar();

        if (c == 'R' || c == 'r'){
                if(k > 100000 || k < 0 ){
                        StdOut.println("ungültige Zahl");
                }
                else{
                        String randomKette = zeichenkette(k);
                        StdOut.println(randomKette);
                }
        }
        else{
                if(c == 'D' || c == 'd'){
                        if(k > 20 || k < 0){
                                StdOut.println("ungültige Zahl");
                        else{
                                int length = (int) (Math.pow(2, k + 1) - 1);
                                char[] charArray = new char[length];

                                String drachenkette = drachenkurve(k);

                                StdOut.println(drachenkette);
