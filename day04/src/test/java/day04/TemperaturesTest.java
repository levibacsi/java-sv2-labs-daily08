package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturesTest {
    @Test
    void findMinDifferenceTest(){
        Temperatures temperatures = new Temperatures();
        temperatures.setFile(temperatures.readFromFile(Paths.get("day04/src/main/resources/temps.txt")));
        assertEquals(14, temperatures.findMinDifference());
    }
}