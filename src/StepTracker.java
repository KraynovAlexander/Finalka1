import java.util.HashMap;

public class StepTracker {

    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    Integer targetSteps = 1000;

    public StepTracker() {
        for (int i = 0; i <= 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    class MonthData {
        int[] stepPerDay = new int[30];
    }

    public void saveSteps(int month, int day, int steps) {     // Метод saveSteps сохраняя шаги
        if (monthToData.containsKey(month)) {
            monthToData.get(month).stepPerDay[day - 1] = steps;
            System.out.println("Шаги за день сохранены");
        }

    }

    public void statisticsByDay(int monthOfStatistics) {    // Метод statisticsByDay обходит HashMap и воводит даные за месяц
        for (int i = 0; i < monthToData.get(monthOfStatistics).stepPerDay.length; i++) {
            System.out.print("  " + (i + 1) + " День: " + monthToData.get(monthOfStatistics).stepPerDay[i] + ",");
        }
    }

    public void sumOfSteps(int month) {               // Метод sumOfSteps складывает все шаги за месец
        int summa = 0;
        for (int i = 0; i < monthToData.get(month).stepPerDay.length; i++) {
            summa += monthToData.get(month).stepPerDay[i];
        }
        System.out.println("\nМаксимальное количество шагов за " + month + " месец: " + summa);
    }

    public int maxSteps(int month) {                // Метод maxSteps ищет за месяц максимальное количество шагов
        int maxSumma = 0;
        for (int i = 0; i < monthToData.get(month).stepPerDay.length; i++) {
            if (maxSumma < monthToData.get(month).stepPerDay[i]) {
                maxSumma = monthToData.get(month).stepPerDay[i];
            }
        }
        return maxSumma;
    }

    public void averageNumberSteps(int month) {     //Метод averageNumberSteps считает среднее количество шагов за месяц
        int averageSteps = 0;
        int maxSumma = 0;
        for (int i = 0; i < monthToData.get(month).stepPerDay.length; i++) {
            if (maxSumma < monthToData.get(month).stepPerDay[i]) {
                maxSumma = monthToData.get(month).stepPerDay[i];
            }
            averageSteps = maxSumma / 30;
        }
        System.out.println("Средние колчество шагов за " + month + " месяц: " + averageSteps);
    }

    // Метод  maximumSet ищет максимальное количество подряд идущих дней,
    // в течение которых количество шагов за день было выше целевого.
    public void maximumSet(int month) {
        int maximumSeries = 0;
        int currentSeries = 0;
        for (int i = 0; i < monthToData.get(month).stepPerDay.length; i++) {
            if (monthToData.get(month).stepPerDay[i] > targetSteps) {
                currentSeries++;
            } else {
                if (currentSeries > maximumSeries) {
                    maximumSeries = currentSeries;
                    currentSeries = 0;
                }
            }
        }
        System.out.println("Лучший сет: " + maximumSeries);
    }

    public void targetSteps(int steps) {    // Метод  targetSteps изменяет целевое количесто шагов
        if (steps > 0) {
            targetSteps = steps;
        } else {
            System.out.println("Количество шагов не может быть отрицательное!");
        }
    }
}
