package designPattern.behavioral.strategyPattern.encryptor.solution2;

public interface Encryptor {
    String encrypt(String fileName);

    Encryptor AESEncryptor = (String fileName)-> {
        return "encrypting the file " + fileName + " with AES encryption";
    };

    Encryptor RSAEncryptor = (String fileName)-> {
        return "encrypting the file " + fileName + " with RSA encryption";
    };

}
