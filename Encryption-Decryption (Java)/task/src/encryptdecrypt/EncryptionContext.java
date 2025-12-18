package encryptdecrypt;

class EncryptionContext {
    private EncryptionStrategy strategy;

    public void setStrategy(String strategy) {
        this.strategy = EncryptionFactory.createStrategy(strategy);
    }

    public String encrypt(String message, int key) {
        return strategy.encrypt(message, key);
    }

    public String decrypt(String message, int key) {
        return strategy.decrypt(message, key);
    }
}