package gameapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        
        // Add some sample questions to the quiz
        quiz.addQuestion(new Question("What is the capital of India?", 
                new String[]{"a) Delhi", "b) Kolkata", "c) Mumbai", "d) Chennai"}, "a"));
        quiz.addQuestion(new Question("What is 15 + 7?", 
                new String[]{"a) 20", "b) 21", "c) 22", "d) 23"}, "c"));
        quiz.addQuestion(new Question("Who wrote 'Harry Potter'?", 
                new String[]{"a) Harper Lee", "b) J.K. Rowling", "c) Mark Twain", "d) Ernest Hemingway"}, "b"));
        quiz.addQuestion(new Question("Who is the father of programming language?", 
                new String[]{"a) Dennis Ritchie", "b) James Gosling", "c) Guido van Rossum", "d) Charles Babbage"}, "a"));
        quiz.addQuestion(new Question("What is the extension of java code file?", 
                new String[]{"a) .py", "b) .txt", "c) .c", "d) .java"}, "d"));

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz!");
        
        for (int i = 0; i < quiz.size(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println(question.getText());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            while (!isValidOption(answer)) {
                System.out.print("Invalid input. Please enter a valid option (a, b, c, d): ");
                answer = scanner.nextLine();
            }

            if (question.isCorrect(answer)) {
                score++;
            }
        }

        System.out.println("Quiz over! Your score: " + score + "/" + quiz.size());
        scanner.close();
    }

    private static boolean isValidOption(String answer) {
        return answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("b") || 
               answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("d");
    }
}