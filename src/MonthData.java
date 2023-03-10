public class MonthData {
    int[] days = new int[30];

    int sumStepsFromMonth(){ // сумма шагов за месяц
        int sumSteps = 0;
        for (int day : days) {
            sumSteps = sumSteps + day;
        }
        return sumSteps;

    }
    int maxSteps() { //Максимальное кол-во шагов.
        int maxSteps = 0;
        for (int day : days) {
            if (maxSteps < day) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) { //лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day : days) {
            if (goalByStepsPerDay <= day) {
                currentSeries += 1;
            }
            else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        return Math.max(currentSeries, finalSeries);
    }

    void printDaysAndStepsFromMonth(){
        for (int i = 0; i < days.length; i++){
            System.out.println((i + 1) + " день: " + days[i] + " шагов.");
        }
    }

}
