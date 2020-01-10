package encryptdecrypt.Encryptors;

public class UnicodeEncryptor implements Encryptor {
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
