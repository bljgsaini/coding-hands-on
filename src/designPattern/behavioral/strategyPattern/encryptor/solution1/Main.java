package designPattern.behavioral.strategyPattern.encryptor.solution1;

public class Main {

    public static void main(String[] args) {
        File file = new File("Adhar deTails");
        Encryptor encryptor = new RSAEncryptor();
        file.encrypt(encryptor);
    }


}
