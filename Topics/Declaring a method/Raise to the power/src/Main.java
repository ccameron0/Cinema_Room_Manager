import java.util.Scanner;

public class Main {

    public static long power(int n, int m) {
        long power = 1;
        if(m == 0)
            return 1;
        else
            for(int i = m; i > 0; i--) {
                power *= n;

            }
        return power;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        System.out.println(power(n, m));
    }
}
