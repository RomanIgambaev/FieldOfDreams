import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
gi
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int correctLetter = 0;
    static int sumPoints = 0;
    static String[] answer;

    static void searchCorrectLetter(String[] answer) {
        String[] scoreboard = new String[answer.length];
        Arrays.fill(scoreboard, "_");
        String[] guessedLetters = new String[32];
        System.out.println(String.join(" ", scoreboard));


        while (correctLetter < answer.length) {
            int min = 50;
            int step = 50;
            int points = min + step * random.nextInt(19);
            System.out.println("На барабане " + points + " очков. Назовите букву:");
            String letPlayer = scanner.next().toLowerCase();

            if (letPlayer.length() != 1) {
                System.out.println("Пожалуйста, введите только одну букву.");
                continue;
            }

            char letter = letPlayer.charAt(0);
            if (letter < 'а' || letter > 'я') {
                System.out.println("Пожалуйста, введите букву из русского алфавита.");
                continue;
            }

            if (guessedLetters[letter - 'а'] != null) {
                System.out.println("Вы уже вводили эту букву. Попробуйте другую.");
                continue;
            }

            for (int j = 0; j < answer.length; j++) {
                if (letter == answer[j].charAt(0)) {
                    correctLetter++;
                    sumPoints += points;
                    scoreboard[j] = String.valueOf(letter);
                    guessedLetters[letter - 'а'] = String.valueOf(letter);
                }
            }
            System.out.println(String.join(" ", scoreboard));

            if (correctLetter == answer.length) {
                System.out.println("Вы победили, отгадав все буквы, ваши очки: " + sumPoints);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Добрый вечер, здравствуйте, уважаемые дамы и господа.Пятница.В эфире капитал шоу: Поле чудес");
        String[] question = new String[4];
        question[0] = "Как у западных и южных славян назывались селение, деревня, курень?";
        question[1] = "Польский ученый-математик Гуго Дионисий Штейнгауз, прославившийся также своими афоризмами, говорил: «Комплимент женщине должен быть правдивее, чем...»";
        question[2] = "В Швеции существует налог на собак, от которого многие пытаются уклониться. В налоговой инспекции в Стокгольме придумали забавный способ борьбы с неплательщиками: сотрудница службы Эльфрида Карлсон ходит по домам и делает это";
        question[3] = "Что использовали в Китае для глажки белья вместо утюга?";

        int questCount = random.nextInt(question.length);

        switch (questCount) {
            case 0:
                System.out.println(question[questCount]);
                answer = new String[]{"ж", "у", "п", "а"};
                searchCorrectLetter(answer);
                break;
            case 1:
                System.out.println(question[questCount]);
                answer = new String[]{"п", "р", "а", "в", "д", "а"};
                searchCorrectLetter(answer);
                break;
            case 2:
                System.out.println(question[questCount]);
                answer = new String[]{"г", "а", "в", "к", "а", "е", "т"};
                searchCorrectLetter(answer);
                break;
            case 3:
                System.out.println(question[questCount]);
                answer = new String[]{"с", "к", "о", "в", "о", "р","о", "д", "а"};
                searchCorrectLetter(answer);
                break;
        }
    }
}