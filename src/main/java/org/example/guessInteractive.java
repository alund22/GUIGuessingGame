package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guessInteractive extends JFrame {
    private JPanel AudreysHiLoGuessingGame; // Main panel
    private JTextField txtGuess; // Text field for user input
    private JButton btnGuess; // Button for submitting the guess
    private JLabel lblOutput; // Label for displaying feedback
    private JLabel txtPrmpt; // Label for instructions
    private int theNumber; // Random number

    public guessInteractive() {
        // Initialize the game with a new random number
        newGame();

        // Add action to the Guess button
        btnGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        getRootPane().setDefaultButton(btnGuess);

        // JFrame setup
        setTitle("Audrey's Hi-Lo Guessing Game");
        setContentPane(AudreysHiLoGuessingGame);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Adjust size to fit components
        setVisible(true);
    }

    public void checkGuess() {
        try {
            // Get the user's guess
            String guessText = txtGuess.getText();
            int guess = Integer.parseInt(guessText);
            String message;

            // Compare guess with the generated number
            if (guess < theNumber) {
                message = guess + " is too low. Try again.";
            } else if (guess > theNumber) {
                message = guess + " is too high. Try again.";
            } else {
                message = "DING DING DING!! " + guess + " is correct! You win!";
                newGame(); // Start a new game after a correct guess
            }

            // Update the label with feedback
            lblOutput.setText(message);
        } catch (NumberFormatException e) {
            lblOutput.setText("Please enter a valid number.");
        }
    }

    public void newGame() {
        // Generate a new random number between 1 and 100
        theNumber = (int) (Math.random() * 100 + 1);
    }

    public static void main(String[] args) {
        // Create and display the game window
        new guessInteractive();
    }
}
