import java.util.Scanner;

public class QuizGame {
    static String[] questions = {
        "Which of the following sorting algorithms is stable?",
        "What is the time complexity of deleting the first element from an array?",
        "Which data structure is used to implement BFS (Breadth-First Search) in a graph?",
        "What is the best-case time complexity of insertion sort?",
        "Which data structure is used for depth-first search (DFS) in a graph?",
        "What is the square root of 64?",
        " What is used to terminate a statement in C?",
        " Which of the following is the correct operator to compare two variables in C?",
        "In which continent is the Sahara Desert?",
        "Who developed the theory of relativity?",
        "What is the capital of Japan?",
        "How many continents are there on Earth?",
        " What is the chemical symbol for gold?"
    };
    static String[][] options = {
        {"a) Quick Sort","b) Heap Sort","c) Merge Sort","d) Selection Sort"},
        {"a) O(1)","b) O(n)","c) O(log n)","d) O(n log n)"},
        {"a) Stack","b) Queue","c) Tree","d) Graph"},
        {"a) O(n)","b) O(n log n)","c) O(n^2)","d) O(log n)"},
        {"a) Stack","b) Queue", "c) Tree","d) Graph"},
        {"a) 6", "b) 8", "c) 7", "d) 9"},
        {"a) Period (.)","b) Colon (:)","c) Semicolon (;)","d) Comma (,)"},
        {"a) =","b) ==","c) !=","d) <>"},
        {"a) Africa", "b) Asia", "c) Australia", "d) South America"},
        {"a) Isaac Newton", "b) Albert Einstein", "c) Nikola Tesla", "d) Galileo Galilei"},
        {"a) Beijing", "b) Seoul", "c) Tokyo", "d) Bangkok"},
        {"a) 5", "b) 6", "c) 7", "d) 8"},
        {"a) Au", "b) Ag", "c) Fe", "d) Pb"}
    };
    static String[] correctAnswers = {
        "c", "b", "b", "a", "a", "c", "a", "b", "a", "b", "c", "c", "a"
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println(options[i][j]);
            }
            System.out.print("Enter your answer (a/b/c/d): ");
            String answer = scanner.nextLine();
            if (answer.equals(correctAnswers[i])) {
                score++;
            }
        }
        System.out.println("Your total score is: " + score + "/" + questions.length);
        scanner.close();
    }
}
