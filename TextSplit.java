import java.util.Scanner;

public class TextSplit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = input.nextLine();
        input.close();

        // Validate input
        if (text.isEmpty()) {
            System.out.println("Input cannot be empty.");
            return;
        }

        // Initialize a StringBuilder to store the current word
        StringBuilder currentWord = new StringBuilder();

        // Iterate through each character in the input text
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(character)) {
                currentWord.append(character);
            }
            // Handle apostrophes within valid word boundaries
            else if (character == '\'' && currentWord.length() > 0 && i + 1 < text.length() &&
                    Character.isLetter(text.charAt(i + 1))) {
                currentWord.append(character);
            }
            // If the character is not part of a word, print it
            else if (currentWord.length() > 0) {
                System.out.println(currentWord);
                currentWord.setLength(0); // Reset the StringBuilder for the next word
            }
        }

        // Print the last word, if there is one
        if (currentWord.length() > 0) {
            System.out.println(currentWord);
        }
    }
}
