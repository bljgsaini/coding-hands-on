package designPattern.behavioral.chainOfResponsibility.example2.end;

public class ClientCertificateAuthenticationHandler extends AuthenticationHandler {


  public ClientCertificateAuthenticationHandler(AuthenticationHandler next) {
    super(next);
  }

  public void handleRequest(String requestType) {
    if(requestType.equalsIgnoreCase("clientCertificate")){
      System.out.println("clientCertificate applying");
    }else{
      super.handleRequest(requestType);
    }
  }

}
