package encryptdecrypt;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


//TODO: Refactor using Strategy pattern
public class Main {
    public static void main(String[] args) {
        HashMap<String, String> arguments = parseArgs(args);

        String mode = arguments.get("-mode");
        String key = arguments.get("-key");
        String data = arguments.get("-data");
        String in = arguments.get("-in");
        String out = arguments.get("-out");
        String alg = arguments.get("-alg");
        performAction(alg, mode, key, data, in, out);
    }


    public static void performAction(String algorithm, String mode, String key, String data, String in, String out) {
        if (algorithm.equals("unicode")) {
            performUnicodeAction(mode, data, key, in, out);
        } else if (algorithm.equals("shift")) {
            performShiftAction(mode, key, data, in, out);
        }
    }

    private static void performShiftAction(String mode, String key, String data, String in, String out) {
        switch (mode) {
            case "enc":
                try (Scanner reader = new Scanner(new File(in)); FileWriter writer = new FileWriter(out)) {
                    if (out.equals("stdout")) {
                        if (!in.equals("readFromDataArg")) {
                            data = reader.nextLine();
                        }
                        System.out.println(new CaesarEncrypt(data, Integer.parseInt(key)).encryptAction(data, Integer.parseInt(key)));
                        break;
                    } else {
                        if (!in.equals("readFromDataArg")) {
                            data = reader.nextLine();
                        }
                        writer.write(new CaesarEncrypt(data, Integer.parseInt(key)).encryptAction(data, Integer.parseInt(key)));
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            case "dec":
                try (FileWriter writer = new FileWriter(out); Scanner reader = new Scanner(new File(in))) {
                    if (out.equals("stdout")) {
                        if (!in.equals("readFromDataArg")) {
                            data = reader.nextLine();
                        }
                        System.out.println(new CaesarDecrypt(data, Integer.parseInt(key)).decryptAction(data, Integer.parseInt(key)));
                        break;
                    } else {
                        if (!in.equals("readFromDataArg")) {
                            data = reader.nextLine();
                        }
                        writer.write(new CaesarDecrypt(data, Integer.parseInt(key)).decryptAction(data, Integer.parseInt(key)));
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            default:
                System.out.println("Error: Unknown action");
                break;
        }
    }

    private static void performUnicodeAction(String mode, String data, String key, String in, String out) {
        switch (mode) {
            case "enc":
                try (Scanner reader = new Scanner(new File(in)); FileWriter writer = new FileWriter(out)) {
                    if (out.equals("stdout")) {
                        if (!in.equals("readFromDataArg")) {
                            data = reader.nextLine();
                        }
                        System.out.println(new UnicodeEncrypt(data, Integer.parseInt(key)).encryptAction(data, Integer.parseInt(key)));
                        break;
                    } else {
                        if (!in.equals("readFromDataArg")) {
                            data = reader.nextLine();
                        }
                        writer.write(new UnicodeEncrypt(data, Integer.parseInt(key)).encryptAction(data, Integer.parseInt(key)));
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            case "dec":
                try (FileWriter writer = new FileWriter(out); Scanner reader = new Scanner(new File(in))) {
                    if (out.equals("stdout")) {
                        if (!in.equals("readFromDataArg")) {
                            data = reader.nextLine();
                        }
                        System.out.println(new UnicodeDecrypt(data, Integer.parseInt(key)).decryptAction(data, Integer.parseInt(key)));
                        break;
                    } else {
                        if (!in.equals("readFromDataArg")) {
                            data = reader.nextLine();
                        }
                        writer.write(new UnicodeDecrypt(data, Integer.parseInt(key)).decryptAction(data, Integer.parseInt(key)));
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            default:
                System.out.println("Error: Unknown action");
                break;
        }

    }

    public static HashMap<String, String> parseArgs(String[] args) {
        HashMap<String, String> arguments = new HashMap<>();

        for (int i = 0; i < args.length; i += 2) {
            String key = args[i];
            String value = (i + 1 < args.length) ? args[i + 1] : null;
            arguments.put(key, value);
        }
        if (!arguments.containsKey("-alg")) {
            arguments.put("-alg", "shift");
        }
        if (!arguments.containsKey("-mode")) {
            arguments.put("-mode", "enc");
        } else if (!arguments.containsKey("-key")) {
            arguments.put("-key", "0");
        } else if (!arguments.containsKey("-data") && !arguments.containsKey("-in")) {
            arguments.put("-data", "");
        } else if (!arguments.containsKey("-in")) {
            arguments.put("-in", "readFromDataArg");
        } else if (!arguments.containsKey("-out")) {
            arguments.put("-out", "stdout");
        }
        for (String key : arguments.keySet()) {
            if (!key.equals("-mode") && !key.equals("-key") && !key.equals("-data") && !key.equals("-in") && !key.equals("-out") && !key.equals("-alg")) {
                System.out.println("Error: Unknown argument: " + key);
                break;
            }
        }
        return arguments;
    }

}
