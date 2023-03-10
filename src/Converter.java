public class Converter {
    int convertToKm(int steps){
        int oneSteps = 75;
        int oneKm = 100000;
        return steps * oneSteps / oneKm;
    }
    int convertStepsToKilocalories(int steps){
        int calories = 50;
        int kilocalorie = 1000;
        return steps * calories / kilocalorie;
    }
}
