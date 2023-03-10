import java.util.Scanner;
public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }


    void changeStepGoal() {
        System.out.println("Введите количество шагов: ");
        int newGoalSteps = scanner.nextInt();
        if (newGoalSteps != goalByStepsPerDay & newGoalSteps < 0) {
            goalByStepsPerDay = newGoalSteps;
            System.out.println("Новая цель по шагам " + goalByStepsPerDay);
        }
        else if(newGoalSteps == goalByStepsPerDay){
            System.out.println("Эта цель уже установлена!");
        }
        else {
            System.out.println("Ошибка ввода.");
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        System.out.println("Введите день от 1 до 30 (включительно):");
        int day = scanner.nextInt();
        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();

        if (month > 0 & month <= 12 & day > 0 & day <= 30 & steps > 0) { // проверка необходимых условий
            MonthData monthData = monthToData[month - 1]; //сохранение введеного месяца
            monthData.days[day - 1] = steps;    //сохранение введеного кол-во шагов за определенный день.
        } else {
            System.out.println("Ошибка ввода.");
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца:");
        int dayOfTheMonth = scanner.nextInt();

        if (dayOfTheMonth > 0 & dayOfTheMonth <= 12) { // проверка номера месяца
            monthData = monthToData[dayOfTheMonth - 1];
            monthData.printDaysAndStepsFromMonth(); // печатаем день и шаги за день.
            System.out.println("Общеее количество шагов за месяц: " + monthData.maxSteps());// печатаем сумму шагов за месяц
            System.out.println("Пройдено шагов за месяц: " + monthData.sumStepsFromMonth());// печатаем максимальное пройденное количества шагов за месяц
            System.out.println("Среднее количество шагов в день пройденные в этом месяце: " + (monthData.sumStepsFromMonth() / 30));
            System.out.println("Пройденная дистанция: " + converter.convertToKm(monthData.maxSteps()) + " км");
            System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(monthData.maxSteps()));
            System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));

        } else {
            System.out.println("Ошибка ввода.");
        }
    }
}