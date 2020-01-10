package encryptdecrypt.Decryptors;

public class UnicodeDecryptor implements Decryptor {
    @Override
    public String decrypt(String str, int key) {
        String decrStr = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            currentChar -= key;
            decrStr += currentChar;
        }
        return decrStr;
    }
}
