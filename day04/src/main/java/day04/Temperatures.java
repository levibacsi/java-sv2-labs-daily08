package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Temperatures {

    private List<String> file = new ArrayList<>();

    public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found", ioe);
        }
    }

    public int findDay(String line){
        if (Character.isDigit(line.charAt(2))) {
            return Integer.parseInt(line.substring(2, 4));
        } else return Integer.parseInt(line.substring(3, 4));
    }

    public int findMaxData(String line){
        return Integer.parseInt(line.substring(6, 8));
    }

    public int findMinData(String line){
        return Integer.parseInt(line.substring(12, 14));
    }

    public int findMinDifference(){
        int dayOfMinimum = 0;
        int minumum = 1000;
        for (int i = 2; i < file.size()-1; i++){
            int difference = findMaxData(file.get(i)) - findMinData(file.get(i));
            if (difference < minumum){
                minumum = difference;
                dayOfMinimum = findDay(file.get(i));
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
        Temperatures temperatures = new Temperatures();

        temperatures.setFile(temperatures.readFromFile(Paths.get("day04/src/main/resources/temps.txt")));
        System.out.println(temperatures.findMinDifference());
    }
}
