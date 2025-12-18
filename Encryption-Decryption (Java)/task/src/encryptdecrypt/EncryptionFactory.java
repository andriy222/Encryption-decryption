package encryptdecrypt;

class EncryptionFactory {
    public static EncryptionStrategy createStrategy(String algorithmType) {
        switch (algorithmType.toLowerCase()) {
            case "unicode":
                return new UnicodeStrategy();
            case "shift":
                return new ShiftStrategy();
            default:
                return new ShiftStrategy();
        }
    }

}