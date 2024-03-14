import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Main {
  public static void main(String[] args) throws IOException {

    Day1TrebuchetPart2();
  }

  public static void Day1TrebuchetPart1() throws IOException {

    List<String> inputFile = Files.readAllLines(Paths.get("/Users/jdonohoe/Documents/GradBookClub/AOCday1InputPart1.txt"));
    List<String> validCodes = new ArrayList<>();
    List<Integer> finalCodes = new ArrayList<>();

    for (String line : inputFile)
    {
      for(char c : line.toCharArray()) {
        Boolean b = isDigit(c) ? validCodes.add(valueOf(c)) : null;
      }

      String concatCodes =  validCodes.get(0).toString() + validCodes.get(validCodes.size() - 1).toString();
      finalCodes.add(parseInt(concatCodes));
      validCodes.clear();
    }

    Integer sumOfCodes = finalCodes.stream()
        .mapToInt(Integer::intValue)
        .sum();

    System.out.println(sumOfCodes);
  }

  public static void Day1TrebuchetPart2() throws IOException {

    List<String> inputFile = Files.readAllLines(Paths.get("/Users/jdonohoe/Documents/GradBookClub/AOCday1InputPart2.txt"));
    List<String> validNumbers = new ArrayList<>();
    List<Integer> finalNumbers = new ArrayList<>();
    Map<String,String> wordNumbers = new HashMap<>();
    wordNumbers.put("one","1");
    wordNumbers.put("two","2");
    wordNumbers.put("three","3");
    wordNumbers.put("four","4");
    wordNumbers.put("five","5");
    wordNumbers.put("six","6");
    wordNumbers.put("seven","7");
    wordNumbers.put("eight","8");
    wordNumbers.put("nine","9");
    wordNumbers.put("eigh", "8");
    wordNumbers.put("ight", "8");
    wordNumbers.put("tw", "2");

    for (String line : inputFile) { // Iterate over each line
      for (var word : wordNumbers.entrySet()){ // Iterate over each wordNumber
        line = line.replace(word.getKey(), word.getValue()); // Replace any found wordNumber with the number
      }

      for(char c : line.toCharArray()) { // Iterate over each char in a line
        Boolean b = isDigit(c) ? validNumbers.add(valueOf(c)) : null; // if char is a number then add to list
      }

      String concatCodes = validNumbers.get(0) + validNumbers.get(validNumbers.size() - 1); // Concat the first and last value of the validCodes list
      finalNumbers.add(parseInt(concatCodes)); // Add the concat numbers to a list
      validNumbers.clear(); // Clear the list o
    }

    Integer sumOfNumbers = finalNumbers.stream()
        .mapToInt(Integer::intValue)
        .sum();

    System.out.println(sumOfNumbers);
  }
}