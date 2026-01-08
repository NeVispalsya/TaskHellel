import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число подходов: ");
        int attempt = scanner.nextInt();
        int pushupTime = 5;
        int rest = 60;
        double restCoef = 1.2;
        int totalTime = 0;
        int totalPushup = 0;

        for(int i = 1; i<=attempt; i++){
            totalPushup+=i;
            totalTime+=pushupTime*i;
            if(i<attempt){
                totalTime+=rest;
                rest*=restCoef;
            }
        }
        int minutes = totalTime / 60;
        int seconds = totalTime % 60;
        String time = String.format("%02d:%02d", minutes, seconds);

                System.out.println(
                        "Итоговое количество поддтягиваний: "+totalPushup
                        +", количество подходов: "+attempt
                        +", времени потрачено на тренировку: "+time);

        scanner.close();
    }
}