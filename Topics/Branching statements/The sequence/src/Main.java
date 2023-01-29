import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* read in a positive integer */
        int numberOfTerms = scanner.nextInt();
        int count = 0;
        /* output the terms */
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            for (int k = 1; k <= i; k++) {
                System.out.print(i + " ");
                count++;
                if (count == numberOfTerms) {
                    break;
                }
            }
            if (count == numberOfTerms) {
                break;
            }
        }
    }
}