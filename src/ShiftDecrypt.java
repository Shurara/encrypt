package encryptdecrypt;

public class ShiftDecrypt implements Decrypt {

    @Override
    public String decrypt(String str, int key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            if (!Character.isLetter(symbol)) {
                output.append(symbol);
            } else if (Character.isUpperCase(symbol)) {
                output.append((char) (((int) symbol +
                        key + 65) % 26 - 65));
            } else {
                output.append((char) (((int) symbol +
                        key + 97) % 26 - 97));
            }
        }
        //System.out.println(outputString);
        return output.toString();
    }
}

