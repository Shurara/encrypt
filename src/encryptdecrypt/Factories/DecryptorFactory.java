package encryptdecrypt.Factories;

import encryptdecrypt.Decryptors.Decryptor;
import encryptdecrypt.Decryptors.ShiftDecryptor;
import encryptdecrypt.Decryptors.UnicodeDecryptor;

public class DecryptorFactory {
    public Decryptor getDecryptor(String algName) {
        Decryptor decryptor = null;
        switch (algName) {
            case "unicode":
                decryptor = new UnicodeDecryptor();
                break;
            default:
                decryptor = new ShiftDecryptor();
        }
        return decryptor;
    }
}
