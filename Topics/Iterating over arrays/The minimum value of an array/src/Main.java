import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        /* read an array of integers from standard input */
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        int min;
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        /* initialize the min variable */
        min = numbers[0];
        for (int i = 1; i < size; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        System.out.println(min);
    }
}