package encryptdecrypt.Factories;

import encryptdecrypt.Encryptors.Encryptor;
import encryptdecrypt.Encryptors.ShiftEncryptor;
import encryptdecrypt.Encryptors.UnicodeEncryptor;

public class EncryptorFactory {
    public Encryptor getEncryptor(String algName) {
        Encryptor encryptor = null;
        switch (algName) {
            case "unicode":
                encryptor = new UnicodeEncryptor();
                break;
            default:
                encryptor = new ShiftEncryptor();
        }
        return encryptor;
    }

}
