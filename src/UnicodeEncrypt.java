package encryptdecrypt;

public class UnicodeEncrypt implements Encrypt {
    @Override
    public String encrypt(String str, int key) {
        String encrStr = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            currentChar += key;
            encrStr += currentChar;
        }
        return encrStr;
    }
}
