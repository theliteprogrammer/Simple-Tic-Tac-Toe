import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        /* read in an array of ints and an integer number n */
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        int howManyTimes = 0;
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        /* check how many times n occurs in the array */
        for (int i = 0; i < size; i++) {
            if (numbers[i] == n) {
                howManyTimes++;
            }
        }
        /* Output how many times n occurred */
        System.out.println(howManyTimes);
    }
}