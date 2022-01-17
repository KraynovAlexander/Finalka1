import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        try {
            while (true) {
                printMenu();
                int command = scanner.nextInt();
                if (command == 1) {
                    System.out.println("Введите количество пройденных шагов за день:");
                    int steps = scanner.nextInt();
                    if (steps > 0) {
                        System.out.println("Введите месяц в котором шаги были пройдены:");
                        int month = scanner.nextInt();
                        if (month > 0 && month <= 12) {
                            System.out.println("Введите день месяца в котором шаги были пройдены:");
                            int day = scanner.nextInt();
                            if (day > 0 && day <= 30) {
                                stepTracker.saveSteps(month, day, steps);
                            } else {
                                System.out.println("Не правильно ввели день.");
                            }
                        } else {
                            System.out.println("Не правильно ввели месяц.");
                        }
                    } else {
                        System.out.println("Не правильно ввели шаги.");
                    }
                } else if (command == 2) {
                    System.out.println("Введите месяц за который нужна статистика:");
                    int monthOfStatistics = scanner.nextInt();
                    stepTracker.statisticsByDay(monthOfStatistics);
                    stepTracker.sumOfSteps(monthOfStatistics);
                    stepTracker.averageNumberSteps(monthOfStatistics);
                    converter.distance(monthOfStatistics, stepTracker.maxSteps(monthOfStatistics));
                    converter.calorieСalculation(monthOfStatistics, stepTracker.maxSteps(monthOfStatistics));
                    stepTracker.maximumSet(monthOfStatistics);
                } else if (command == 3) {
                    System.out.println("Введите целевое количество шагов:");
                    int steps = scanner.nextInt();
                    stepTracker.targetSteps(steps);
                    System.out.println("Шаги сохранены.");

                } else if (command == 0) {

                    System.out.println("Выход");
                    break;
                } else {
                    System.out.println("Такой команды нет");
                }
            }
        } catch (
                Exception e) {
            System.out.println("Вы некорректно ввели данные. Пожалуйста, попробуйте заново"); // Здесь я обработал сра
        } // Обработал exceptions в случае некорректного ввода любой команды и данных в меню

    }

    static void printMenu() {
        System.out.println("Вы запустили счетчик калорий! Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}