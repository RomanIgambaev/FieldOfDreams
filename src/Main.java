import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int correctLetter = 0;
    static int sumPoints = 0;
    static String[] answer;

    static void searchCorrectLetter(String[] answer) {
        String[] scoreboard = new String[answer.length];
        Arrays.fill(scoreboard, "_");

        while (correctLetter < answer.length) {
            int points = random.nextInt(100, 1000);
            System.out.println("На барабане " + points + " очков. Назовите букву:");
            String letPlayer = scanner.next();
            String copyCorrectLetter = "p";

            for (int j = 0; j < answer.length; j++) {
                if (letPlayer.equals(answer[j])) {
                    correctLetter++;
                    sumPoints += points;
                    scoreboard[j] = letPlayer;
                    copyCorrectLetter = letPlayer;
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
                String[] scoreboard = new String[answer.length];
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
                answer = new String[]{"с", "к", "о", "в", "о", "р", "д", "а"};
                searchCorrectLetter(answer);
                break;
        }
    }
}