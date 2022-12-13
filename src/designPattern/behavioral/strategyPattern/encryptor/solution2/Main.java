package designPattern.behavioral.strategyPattern.encryptor.solution2;

public class Main {

    public static void main(String[] args) {
        File file = new File("Adhar deTails");
        file.encrypt(Encryptor.RSAEncryptor);
    }

}
