import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** A program than takes a given number and generate the Fibonacci sequence to that number */

class Fibonacci_Sequence {

    public static void main(String[] args) throws Exception {

        String first;
        String second;
        int[] resultBA = {};
        int[] resultSequenceA = {};
        int[] resultSequenceB = {};


        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

        System.out.println("Enter A value");
        first = reader.readLine();
        System.out.println("Enter B value");
        second = reader.readLine();
        /** Run integers through validation */
        NumberValidator(first, second);

        System.out.println("How many sequences?");
        int amount = Integer.parseInt(reader.readLine());
        System.out.println("");
        
        /** If all was correct, return the new values A & B */
        int A = Validator.getA();
        int B = Validator.getB();
        int beforeA = Validator.getA();
        
        /** Start the algorithm to calculate fibonacci sequence using golden ratio */
        for(int i = 0; i < amount; i++){
            resultSequenceA = Arrays.copyOf(resultSequenceA, resultSequenceA.length + 1);
            resultSequenceB = Arrays.copyOf(resultSequenceB, resultSequenceB.length + 1);
            resultBA = Arrays.copyOf(resultBA, resultBA.length + 1);
            resultBA[resultBA.length - 1] = A / B;
            resultSequenceA[resultSequenceA.length - 1] = A;
            resultSequenceB[resultSequenceB.length - 1] = B;

            A = B;
            resultSequenceA[resultSequenceA.length - 1] = A;
            B = beforeA + A;
            beforeA = A;
            resultSequenceB[resultSequenceB.length - 1] = B;

            System.out.println("");
            System.out.println(A);
            System.out.println(B);
            
        }

        /**
         * resultSequenceA returns array list of all A numbers
         * resultSequenceB returns array list of all B numbers
         * resultBA returns array list of all A/B numbers
         */

        
    }
    
    public static Validator NumberValidator(String first, String second) throws Exception{
        String[] args = null;
        int A = 0;
        int B = 0;
        if(!first.matches("^[0-9]+$") || !second.matches("^[0-9]+$")){
            System.out.println("Invalid A/B value");
            Thread.sleep(1000);
            Fibonacci_Sequence.main(args);
        } 
        A = Integer.parseInt(first);
        B = Integer.parseInt(second);
        return new Validator(A, B);
    }
}

class Validator {
    private static int A;
    private static int B;

    public Validator(int A, int B){
        Validator.A = A;
        Validator.B = B;
    }

    public static int getA(){
        return A;
    }

    public static int getB(){
        return B;
    }
}