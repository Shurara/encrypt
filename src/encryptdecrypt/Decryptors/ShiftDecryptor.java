package encryptdecrypt.Decryptors;

import encryptdecrypt.Encryptors.ShiftEncryptor;

public class ShiftDecryptor implements Decryptor {

    @Override
    public String decrypt(String str, int key) {
    ShiftEncryptor encrypt = new ShiftEncryptor();
        return encrypt.encrypt(str, 26 - (key % 26));
    }
}




