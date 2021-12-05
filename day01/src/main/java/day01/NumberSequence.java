package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numberList = new ArrayList<>();

    public NumberSequence(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public NumberSequence (int numberOfRnd, int min, int max){
        Random random = new Random();
        int counter = 0;
        while (counter < numberOfRnd){
            numberList.add(random.nextInt(min, max+1));
            counter++;
        }
    }

    public List<Integer> closeToAverage(int value){
        double sum = 0;
        for (int n: numberList){
            sum += n;
        }
        double avg = sum / numberList.size();

        List<Integer> close = new ArrayList<>();
        for (int i: numberList){
            if (Math.abs(i - avg) <= value){
                close.add(i);
            }
        }
        return close;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
