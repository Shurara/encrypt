import java.util.Arrays;

//https://www.geeksforgeeks.org/caesar-cipher-in-cryptography/
//https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

public class Main {
    public static void main(String[] args) {
        //String inputString = "we found a treasure!";
        //reverseAlphabetEncrypt(inputString);
        String inputToShift = "welcome to hyperskill";
        int shift = 5;
        System.out.println(inputToShift);
        shiftEncrypt(inputToShift, shift);
    }
    public static String reverseAlphabetEncrypt(String inputString){
        StringBuilder output = new StringBuilder();
        Character[]alphabetArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Character[]reverseAlphabetArray = {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};
        for (int i = 0; i < inputString.length(); i++) {
            Character toCheckValue = inputString.toLowerCase().charAt(i);
            if(Character.isLetter(toCheckValue)) {
                int index = Arrays.asList(alphabetArray).indexOf(toCheckValue);
                output.append(reverseAlphabetArray[index]);
            }else{
                output.append(toCheckValue);
            }
        }
        System.out.println(output.toString());
        String outputString = output.toString();
        return outputString;
    }

    public static String shiftEncrypt(String str, int shift){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            if(!Character.isLetter(symbol)){
                output.append(symbol);
            }else{
                System.out.println((int)symbol);
                System.out.println((int)symbol);
                output.append((char)(((int)symbol +
                        shift - 97) % 26 + 97));
            }
        }
        String outputString = output.toString();
        System.out.println(outputString);
        return outputString;
    }

}