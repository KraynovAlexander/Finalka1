public class Converter {
    int steps = 75;
    int calories = 50;

    public void calorieСalculation(int month, int maxSteps) {    // Метод выщитывает количесто колории соженых при ходьбе
        int calorrieСalculation = maxSteps * calories;
        if (calorrieСalculation > 1000) {
            calorrieСalculation = calorrieСalculation / 1000;
            System.out.println("За месяц сожгли: " + calorrieСalculation + " килокалорий");
        } else {
            System.out.println("За месяц сожгли: " + calorrieСalculation + " калорий");
        }
    }

    public void distance(int month, int maxSteps) {       // Метод переводит шаги в км за месяц
        int distanceSteps = (maxSteps * steps) / 100000;
        System.out.println("За месяц пройдено: " + distanceSteps + " км");

    }
}