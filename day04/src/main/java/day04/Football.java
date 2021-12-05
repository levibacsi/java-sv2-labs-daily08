package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Football {
    private List<String> file = new ArrayList<>();

    public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found", ioe);
        }
    }

    public int findDay(String line){
        if (Character.isDigit(line.charAt(3))) {
            return Integer.parseInt(line.substring(3, 5));
        } else if (Character.isDigit(line.charAt(4))) {
            return Integer.parseInt(line.substring(4, 5));
        }
        else return 0;
    }

    public int findMaxData(String line){
        return Integer.parseInt(line.substring(43, 45));
    }

    public int findMinData(String line){
        return Integer.parseInt(line.substring(50, 52));
    }

    public int findMaxDifference(){
        int dayOfMaximum = 0;
        int maximum = 0;
        for (int i = 2; i < file.size(); i++){
            if (Character.isDigit(file.get(i).charAt(4))){
                int difference = Math.abs(findMaxData(file.get(i)) - findMinData(file.get(i)));
                if (difference > maximum) {
                    maximum = difference;
                    dayOfMaximum = findDay(file.get(i));
                }
            }
        }
        return dayOfMaximum;
    }

    public int findMinDifference(){
        int dayOfMinimum = 0;
        int minimum = 1000;
        for (int i = 2; i < file.size(); i++){
            if (Character.isDigit(file.get(i).charAt(4))){
                int difference = Math.abs(findMaxData(file.get(i)) - findMinData(file.get(i)));
                if (difference < minimum) {
                    minimum = difference;
                    dayOfMinimum = findDay(file.get(i));
                }
            }
        }
        return dayOfMinimum;
    }

    public List<String> getFile() {
        return file;
    }

    public void setFile(List<String> file) {
        this.file = file;
    }

    public static void main(String[] args) {
        Football football = new Football();

        football.setFile(football.readFromFile(Paths.get("day04/src/main/resources/football.txt")));
        System.out.println(football.findMaxDifference());
        System.out.println(football.findMinDifference());
    }
}
