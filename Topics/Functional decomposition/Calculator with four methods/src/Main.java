class SimpleCalculator {

    // Implement your methods here
    public static void subtractTwoNumbers (long n, long m){
        long result = n-m;
        System.out.println(result);
    }


    public static void sumTwoNumbers (long n, long m){
        long result = n+m;
        System.out.println(result);
    }


    public static void divideTwoNumbers (long n, long m){
        long result = 0;
        if(m == 0) {
            System.out.println("Division by 0!");
        }
        else {
            result = n / m;
            System.out.println(result);
        }


    }


    public static void multiplyTwoNumbers (long n, long m){
        long result = n*m;
        System.out.println(result);
    }

    // Implemented method
    public static void power(long n, long p) {
        long number = n;
        long power = p;
        long result = 1;
        while (power > 0) {
            if (power % 2 != 0) {
                result *= number;
            }
            power /= 2;
            number *= number;
        }
        System.out.println(result);
    }
}

public class Main {

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long num1 = scanner.nextLong();
        String operator = scanner.next();
        long num2 = scanner.nextLong();

        switch (operator) {
            case "^":
                SimpleCalculator.power(num1, num2);
                break;
            case "+":
                SimpleCalculator.sumTwoNumbers(num1, num2);
                break;
            case "-":
                SimpleCalculator.subtractTwoNumbers(num1, num2);
                break;
            case "/":
                SimpleCalculator.divideTwoNumbers(num1, num2);
                break;
            case "*":
                SimpleCalculator.multiplyTwoNumbers(num1, num2);
                break;
            default:
                break;
        }
    }
}