package encryptdecrypt;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
//https://www.geeksforgeeks.org/caesar-cipher-in-cryptography/
//https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

public class Main {
    public static void main(String[] args) {
        //String inputString = "we found a treasure!";
        //reverseAlphabetEncrypt(inputString);
        //String inputToShift = "Welcome to hyperskill!";
        //String crypt = "\\jqhtrj%yt%m~ujwxpnqq&";
        // int shift = 5;
        // System.out.println(inputToShift);
        //shiftEncrypt(inputToShift, shift);
        // Scanner sc = new Scanner(System.in);
        //String command = sc.nextLine();
        // String inputString = sc.nextLine();
        // int shift = sc.nextInt();
        String mode = "enc";
        int key = 0;
        String data = "";
        String fileNameIn = "";
        String fileNameOut = "";
        for (int i = 0; i < args.length; i = i + 2) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-in")) {
                fileNameIn = args[i + 1];
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            } else if (args[i].equals("-out")) {
                fileNameOut = args[i + 1];
            }
        }
        if (mode.equals("enc") == true) {
            encrypt(!data.isEmpty() ? data : !fileNameIn.isEmpty() ? readFromFile(fileNameIn) : data, key, fileNameOut);
        } else if (mode.equals("dec") == true) {
            decrypt(!data.isEmpty() ? data : !fileNameIn.isEmpty() ? readFromFile(fileNameIn) : data, key, fileNameOut);
        }


    }

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
            sc.close();
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
