package encryptdecrypt;

import encryptdecrypt.Factories.DecryptorFactory;
import encryptdecrypt.Factories.EncryptorFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    static String resultString = "";
    static String mode = "";
    static int key = 0;
    static String data = "";
    static String inPath = "";
    static String outPath = "";
    static String alg = "shift";

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i = i + 2) {
            String parameter = args[i];
            if ("-mode".equals(parameter)) {
                mode = args[i + 1];
            } else if ("-data".equals(parameter)) {
                data = args[i + 1];
            } else if ("-key".equals(parameter)) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-in".equals(parameter)) {
                inPath = args[i + 1];
            } else if ("-out".equals(parameter)) {
                outPath = args[i + 1];
            } else if ("-alg".equals(parameter)) {
                alg = args[i + 1];
            }
        }

        data = getInputStringData(data, inPath);

        modificateData(mode, alg, data,key);

        outputData(inPath, outPath);

    }

    private static String getInputStringData(String data, String inPath) {
        if (data.isEmpty() && !inPath.isEmpty()) {
            try {
                data = new String(Files.readAllBytes(Paths.get(inPath)));
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        return data;
    }

    private static String modificateData(String mode, String alg, String data, int key) {
        if (mode.isEmpty()) {
            System.out.println("Unknown operation");
        } else if ("enc".equals(mode)) {
            resultString = new EncryptorFactory().getEncryptor(alg).encrypt(data, key);
        } else {
            resultString = new DecryptorFactory().getDecryptor(alg).decrypt(data, key);
        }
        return resultString;
    }

    private static void outputData(String inPath, String outPath) {
        if (inPath.isEmpty()) {
            System.out.println(resultString);
        } else {
            File outPut = new File(outPath);
            try (FileWriter writer = new FileWriter(outPut)) {
                writer.write(resultString);
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }


}
