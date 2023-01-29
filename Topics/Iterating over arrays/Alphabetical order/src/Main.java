import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        /* read in lowercase characters */
        Scanner scanner = new Scanner(System.in);
        String characters = scanner.nextLine();
        String[] words = characters.split(" ");
        int number = 0;
        for (int i = 0; i < words.length; i++) {
            if (i + 1 < words.length) {
                number = words[i].compareTo(words[i + 1]);
            }
        }
        if (number > 0) {
            System.out.println("false");
        } else if (number <= 0)  {
            System.out.println("true");
        }
    }
}