package encryptdecrypt;

public class UnicodeEncrypt {
    private String message;
    private int key;

    public UnicodeEncrypt(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public String encryptAction(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            c = (char) (c + key);
            sb.append(c);
        }
        return sb.toString();
    }
}
