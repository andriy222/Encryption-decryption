package encryptdecrypt;

class ShiftStrategy implements EncryptionStrategy {
    @Override
    public String encrypt(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char)('a' + (c - 'a' + key) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char)('A' + (c - 'A' + key) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char)('a' + (c - 'a' - key + 26) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char)('A' + (c - 'A' - key + 26) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}