import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true){
            PrintMenu();
            int command = scanner.nextInt();
            if(command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 0){
                System.out.println("Выход.");
                break;
            } else {
                System.out.println("Извините, такой команды нет");
            }
        }
    }
    public static void PrintMenu(){
        System.out.println();
        System.out.println("Что вы хотите сделать ?");
        System.out.println("1 - ввести количество шагов за определённый день.");
        System.out.println("2 - изменить цель по количеству шагов в день.");
        System.out.println("3 - напечатать статистику за определённый месяц.");
        System.out.println("0 - выйти из приложения.");
    }
}