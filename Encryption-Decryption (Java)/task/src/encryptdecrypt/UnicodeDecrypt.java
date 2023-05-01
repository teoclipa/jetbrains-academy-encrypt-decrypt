package encryptdecrypt;

public class UnicodeDecrypt {
    private String message;
    private int key;

    public UnicodeDecrypt(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public String decryptAction(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            c = (char) (c - key);
            sb.append(c);
        }
        return sb.toString();
    }
}
