package encryptdecrypt;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = null;
        String inputFile = null;
        String outputFile = null;
        String algorithm = "shift";

        for (int i = 0; i < args.length - 1; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inputFile = args[i + 1];
                    break;
                case "-out":
                    outputFile = args[i + 1];
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
            }
        }

        String message = "";
        if (data != null) {
            message = data;
        } else if (inputFile != null) {
            message = readFile(inputFile);
            if (message == null) return;
        }

        EncryptionContext context = new EncryptionContext();

        switch (algorithm) {
            case "unicode":
                context.setStrategy("unicode");
                break;
            case "shift":
            default:
                context.setStrategy("shift");
                break;
        }

        String result = mode.equals("dec") ?
                context.decrypt(message, key) :
                context.encrypt(message, key);

        if (outputFile != null) {
            writeFile(outputFile, result);
        } else {
            System.out.println(result);
        }
    }

    private static String readFile(String inputFile) {
        try {
            File file = new File(inputFile);
            Scanner scanner = new Scanner(file);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                if (scanner.hasNextLine()) sb.append("\n");
            }
            scanner.close();
            return sb.toString();
        } catch (IOException e) {
            System.out.println("Error: Cannot read file " + inputFile);
            return null;
        }
    }

    private static void writeFile(String outputFile, String data) {
        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: Cannot write file " + outputFile);
        }
    }
}