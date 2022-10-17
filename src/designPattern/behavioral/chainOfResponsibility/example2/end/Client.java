package designPattern.behavioral.chainOfResponsibility.example2.end;

public class Client {

  public static void main(String[] args) {
    AuthenticationHandler authenticationHandler = new BasicAuthenticationHandler(new ClientCertificateAuthenticationHandler(new DigestAuthenticationHandler(null)));
    authenticationHandler.handleRequest("basicAuth");
    authenticationHandler.handleRequest("clientCertificate");
    authenticationHandler.handleRequest("digestAuth");
  }

}
