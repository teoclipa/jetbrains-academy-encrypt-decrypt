package encryptdecrypt;

public class CaesarEncrypt {
    private String message;
    private int key;

    public CaesarEncrypt(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public String encryptAction(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    c = (char) ('a' + (c - 'a' + key) % 26);
                } else {
                    c = (char) ('A' + (c - 'A' + key) % 26);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
