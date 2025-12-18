package encryptdecrypt;

class UnicodeStrategy implements EncryptionStrategy {
    @Override
    public String encrypt(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((char)(c + key));
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((char)(c - key));
        }
        return sb.toString();
    }
}