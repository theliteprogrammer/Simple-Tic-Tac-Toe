package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* create 2 dimensional array for storing symbols */
        char[][] characters = new char[3][3];

        /* boolean to store game state */
        boolean isPlaying = true;

        /* to count to 9 and use that as a way to exit game */
        int count = 0;

        /* int to store whether this is the first player or not: 1 - first player , > 0 for second then first etc... */
        int firstPlayer = 0;

        /* int to store whether there are three in a row or not, 0 - false, 1 - true */
        int hasThreeX = 0;
        int hasThreeO = 0;

        /* integer to count the number of X's */
        int[] numberOfXs = new int[8];
        int[] numberOfOs = new int[8];

        /* integer to store sum of X's and O's */
        int sumX = 0;
        int sumO = 0;

        /* instantiate the scanner */
        Scanner scanner = new Scanner(System.in);

        /* initialize the game with empty spaces */
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                characters[i][j] = ' ';
            }
        }

        /* display the symbols */
        System.out.println("---------");
        for (int i = 0; i < characters.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < characters[i].length; j++) {
                System.out.print(characters[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");

        /* prompt the user to make a move by taking in two coordinate numbers */

        int xCoordinate = 0;
        int yCoordinate = 0;

        /* game loop */
        while (isPlaying) {
            firstPlayer++;

            xCoordinate = 0;
            yCoordinate = 0;

            /* read the coordinates */
            xCoordinate = scanner.nextInt();
            yCoordinate = scanner.nextInt();


            /* check if the user input is a number */
            while (xCoordinate == 0 && yCoordinate == 0) {
                System.out.println("You should enter numbers!");
                xCoordinate = scanner.nextInt();
                yCoordinate = scanner.nextInt();
            }

            while (xCoordinate > 3 || yCoordinate > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                xCoordinate = scanner.nextInt();
                yCoordinate = scanner.nextInt();
            }

            if ((xCoordinate >= 1 && xCoordinate <= 3) && (yCoordinate >= 1 && yCoordinate <= 3)) {
                while (characters[xCoordinate - 1][yCoordinate - 1] == 'O' || characters[xCoordinate - 1][yCoordinate - 1] == 'X') {
                    /* check if cell is occupied */
                    System.out.println("This cell is occupied! Choose another one!");
                    xCoordinate = scanner.nextInt();
                    yCoordinate = scanner.nextInt();
                    while (xCoordinate > 3 || yCoordinate > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        xCoordinate = scanner.nextInt();
                        yCoordinate = scanner.nextInt();
                    }

                    while (xCoordinate > 3 && yCoordinate > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        xCoordinate = scanner.nextInt();
                        yCoordinate = scanner.nextInt();
                    }

                    while (xCoordinate > 3 && yCoordinate <= 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        xCoordinate = scanner.nextInt();
                        yCoordinate = scanner.nextInt();
                    }

                    while (xCoordinate <= 3 && yCoordinate > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        xCoordinate = scanner.nextInt();
                        yCoordinate = scanner.nextInt();
                    }
                }
            }

            while (xCoordinate > 3 && yCoordinate > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                xCoordinate = scanner.nextInt();
                yCoordinate = scanner.nextInt();
            }

            while (xCoordinate > 3 && yCoordinate <= 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                xCoordinate = scanner.nextInt();
                yCoordinate = scanner.nextInt();
            }

            while (xCoordinate <= 3 && yCoordinate > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                xCoordinate = scanner.nextInt();
                yCoordinate = scanner.nextInt();
            }

            xCoordinate--;
            yCoordinate--;

            /* place the character */
            if (firstPlayer == 1) {
                characters[xCoordinate][yCoordinate] = 'X';
                count++;
            } else {
                /* since X is the first move that means X plays when the current number of moves is odd */
                if (firstPlayer % 2 == 0) {
                    characters[xCoordinate][yCoordinate] = 'O';
                    count++;
                } else {
                    characters[xCoordinate][yCoordinate] = 'X';
                    count++;
                }
            }

            /* find the sum of three X's horizontally */
            numberOfXs[0] = checkIfCharAtHorizontally(characters, 0, 'X');
            numberOfXs[1] = checkIfCharAtHorizontally(characters, 1, 'X');
            numberOfXs[2] = checkIfCharAtHorizontally(characters, 2, 'X');
            /* find the sum of three O's horizontally */
            numberOfOs[0] = checkIfCharAtHorizontally(characters, 0, 'O');
            numberOfOs[1] = checkIfCharAtHorizontally(characters, 1, 'O');
            numberOfOs[2] = checkIfCharAtHorizontally(characters, 2, 'O');
            /* find the sum of three X's vertically */
            numberOfXs[3] = checkIfCharAtVertically(characters, 0, 'X');
            numberOfXs[4] = checkIfCharAtVertically(characters, 1, 'X');
            numberOfXs[5] = checkIfCharAtVertically(characters, 2, 'X');
            /* find the sum of three O's vertically */
            numberOfOs[3] = checkIfCharAtVertically(characters, 0, 'O');
            numberOfOs[4] = checkIfCharAtVertically(characters, 1, 'O');
            numberOfOs[5] = checkIfCharAtVertically(characters, 2, 'O');
            /* find the sum of three X's diagonally */
            numberOfXs[6] = checkIfCharAtDiagonally(characters, 0, 'X');
            numberOfXs[7] = checkIfCharAtDiagonally(characters, 2, 'X');
            /* find the sum of three O's diagonally */
            numberOfOs[6] = checkIfCharAtDiagonally(characters, 0, 'O');
            numberOfOs[7] = checkIfCharAtDiagonally(characters, 2, 'O');

            /* output the updated version of the game */
            /* display the symbols */
            System.out.println("---------");
            for (int i = 0; i < characters.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < characters[i].length; j++) {
                    System.out.print(characters[i][j] + " ");
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.println("---------");

            /* calculate find if there are three O's or X's or not */
            for (int i = 0; i < numberOfXs.length; i++) {
                if (numberOfXs[i] == 3) {
                    System.out.println("X wins");
                    hasThreeX = 1;
                    isPlaying = false;
                } else if (numberOfOs[i] == 3) {
                    System.out.println("O wins");
                    hasThreeO = 1;
                    isPlaying = false;
                }
            }

            if (count == 9) {
                isPlaying = false;
            }
        }

        /* output the game state */
        if (hasThreeX == 0 && hasThreeO == 0) {
            System.out.println("Draw");
        }

     }

     /* function to check if character exists in a string and increment by 1 **/

    /***
     *
     * @param characters - the array of game symbols
     * @param row
     * @param symbol
     * @return
     */
    public static int checkIfCharAtHorizontally(char[][] characters, int row, char symbol) {
        int sum = 0;
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                if (i == row) {
                    if (characters[i][j] == symbol) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    /***
     *
     * @param characters - the array of game symbols
     * @param column - the column I will sum from
     * @param character - the character I want to count
     * @return sum - the number of times symbol occurred
     */
    public static int checkIfCharAtVertically(char[][] characters, int column, char character) {
        int total = 0;
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                if (j == column) {
                    if (characters[i][j] == character) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    /***
     *
     * @param characters - the array of game symbols
     * @param start - where I should start counting from whether it is a row or column
     * @param symbol - the character I want to count
     * @return sum - the number of times symbol occurred
     */
    public static int checkIfCharAtDiagonally(char[][] characters, int start, char symbol) {
        int sum = 0;
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                if (start == 0) {
                    for (int k = start; k <= 8; k += 4) {
                        sum++;
                    }
                } else if (start == 2) {
                    for (int k = start; k <= 6; k += 2) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
