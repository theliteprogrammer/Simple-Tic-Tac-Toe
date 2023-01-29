import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        /* read in the size of the matrix */
        Scanner scanner = new Scanner(System.in);
        int oneDimension = scanner.nextInt();
        int[][] twoDArray = new int[oneDimension][oneDimension];
        if (oneDimension <= 100) {
            /* fill the main diagonal with zeros */
            for (int i = 0; i < twoDArray.length; i++) {
                for (int j = 0; j < twoDArray[i].length; j++) {
                    if (i == j) {
                        twoDArray[i][j] = 0;
                        for (int k = 1; k < twoDArray.length; k++) {
                            if (j + k < twoDArray.length) {
                                twoDArray[i][j + k] = k;
                            }
                        }
                        for (int k = 1; k < twoDArray.length; k++) {
                            if (i + k < twoDArray.length) {
                                twoDArray[i + k][j] = k;
                            }
                        }
                    } else if (i == 0) {
                        twoDArray[i][j] = j;
                    } else if (j == 0) {
                        twoDArray[i][j] = i;
                    }
                }
            }
        }
        /* print out the array */
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}