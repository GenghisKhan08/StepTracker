package Vadim;

import java.util.Scanner;

public class StepTracker {
    Month[] months;
    private int target = 10000;
    int day;

    public StepTracker(){
        months = new Month[12];
        for (int i = 0; i < months.length; i++){
            months[i] = new Month();
        }
    }


    public void statMonths(int num) {
        for (int i = 0; i < months[num].days.length; i++) {
            System.out.println(i + 1 + " день: " + months[num].days[i].steps);
        }
    }
    public int sumSteps(int num) {
        int sum = 0;
        for (int i = 0; i < months[num].days.length; i++) {
            sum = sum + months[num].days[i].steps;
        }
        return sum;
    }
    public void maxSteps(int num){
        int max = 0;
        int c = 0;
        for (int i = 0; i < months[num].days.length; i++) {
            if (months[num].days[i].steps > max){
                max = months[num].days[i].steps;
                c = i;
            }
        }
        System.out.println("максимальное кол-во шагов было в " + (c + 1) +" день: " + max+ " шагов!");
    }
    public void mediane(int num){
        int m = 0;
        for (int i = 0; i < months[num].days.length; i++) {
            m = m + months[num].days[i].steps;
        }
        System.out.println("среднее кол-во шагов: " + m/30);
    }
    public int bestDays(int num){
        int q = 0;
        int max = 0;

        for (int i = 0; i < months[num].days.length; i++) {
            if (months[num].days[i].steps >= target){
                max++;
                if (max > q){
                    q = max;
                    day = i - max + 2; //день начала лучшей серии
                }
            } else {
                max = 0;
            }
        } return q;
    }

    public void changeTarget(int num){
        target = num;
    }
}
