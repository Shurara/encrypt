package encryptdecrypt.oldversions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OldEncription {
    public static String reverseAlphabetEncrypt(String inputString) {
        StringBuilder output = new StringBuilder();
        Character[] alphabetArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Character[] reverseAlphabetArray = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        for (int i = 0; i < inputString.length(); i++) {
            Character toCheckValue = inputString.toLowerCase().charAt(i);
            if (Character.isLetter(toCheckValue)) {
                int index = Arrays.asList(alphabetArray).indexOf(toCheckValue);
                output.append(reverseAlphabetArray[index]);
            } else {
                output.append(toCheckValue);
            }
        }
        System.out.println(output.toString());
        String outputString = output.toString();
        return outputString;
    }
    public static String shiftEncrypt(String str, int shift) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            if (!Character.isLetter(symbol)) {
                output.append(symbol);
            } else {
                System.out.println((int) symbol);
                System.out.println((int) symbol);
                output.append((char) (((int) symbol +
                        shift - 97) % 26 + 97));
            }
        }
        String outputString = output.toString();
        System.out.println(outputString);
        return outputString;
    }

    public static void encrypt(String str, int shift, String fileNameOut) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            output.append((char) (((int) symbol +
                    shift - 33) % 94 + 33));
        }
        String outputString = output.toString();
        if (fileNameOut.isEmpty()) {
            System.out.println(outputString);
        } else {
            writeToFile(fileNameOut, outputString);
        }
    }

    public static void decrypt(String str, int shift , String fileNameOut) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            output.append((char) (((int) symbol -
                    shift - 33) % 94 + 33));
        }
        String outputString = output.toString();
        if (fileNameOut.isEmpty()) {
            System.out.println(outputString);
        } else {
            writeToFile(fileNameOut, outputString);
        }
    }

    public static String readFromFile(String inputFileName) {
        String textFromFile = "";
        try {
            FileReader reader = new FileReader(inputFileName);
            Scanner sc = new Scanner(reader);
            textFromFile = sc.nextLine();
            return textFromFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return textFromFile;
    }

    public static void writeToFile(String outputFileName, String text) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(outputFileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
