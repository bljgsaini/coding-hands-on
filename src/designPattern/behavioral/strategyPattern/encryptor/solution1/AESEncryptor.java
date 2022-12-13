package designPattern.behavioral.strategyPattern.encryptor.solution1;

public class AESEncryptor implements Encryptor{
    @Override
    public String encrypt(String fileName) {
        return "Encrypting the file " + fileName + " with AES Encryptor";
    }
}
