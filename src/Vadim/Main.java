package Vadim;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker =new StepTracker();
        Scanner scanner =new Scanner(System.in);
        int x;
        printMenu();
        int q = scanner.nextInt();
        while (q != 4) {

            if (q == 1) {
                System.out.print("введите номер месяца: ");
                int month;
                while ((month = scanner.nextInt()) < 0 || month > 11) {
                    System.out.print("введите от 0 до 11: ");
                }

                System.out.print("введите день: ");
                int day1;
                while ((day1 = scanner.nextInt()) < 1 || day1 > 30) {
                    System.out.print("введите от 1 до 30: ");
                }
                int day = day1 - 1;

                System.out.print("введите количество шагов: ");
                int steps;
                while ((steps = scanner.nextInt()) < 0) {
                    System.out.print("введите положительное значение: ");
                }

                stepTracker.months[month].days[day].steps = steps;
                System.out.print("записано!"+ "\n");

            } else if (q == 2) {
                System.out.println("введите номер месяца: ");
                int num =scanner.nextInt();
                stepTracker.statMonths(num);
                System.out.println("общее кол-во шагов: " + stepTracker.sumSteps(num));
                stepTracker.maxSteps(num);
                stepTracker.mediane(num);
                Converter converter = new Converter();
                System.out.println("кол-во соженных ккал: "+converter.kkal(stepTracker.sumSteps(num)));
                System.out.println("лучшая серия длится "+ stepTracker.bestDays(num)+ " дней. Начиная с "+stepTracker.day+" дня");


            } else if (q == 3) {
                int num;
                System.out.print("введите новую цель: ");
                while ((num = scanner.nextInt()) < 0){
                    System.out.println("введите не отрицательное число: ");
                }
                stepTracker.changeTarget(num);
                System.out.print("новая цель в "+ num + " шагов задана" +"\n");
            }
            printMenu();
            q = scanner.nextInt();
        }

    }
    public static void printMenu() {
        System.out.println("1. ввести кол-во шагов за определенный день" +"\n"+
                "2. напечатать статистику за определенный месяц" +"\n"+
                "3. изменить цель по кол-ву шагов в день" +"\n"+
                "4. выйти из приложения");
    }
}