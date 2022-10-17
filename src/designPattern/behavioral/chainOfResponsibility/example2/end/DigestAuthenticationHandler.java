package designPattern.behavioral.chainOfResponsibility.example2.end;

public class DigestAuthenticationHandler extends AuthenticationHandler {

  public DigestAuthenticationHandler(AuthenticationHandler next) {
    super(next);
  }

  public void handleRequest(String requestType) {
    if(requestType.equalsIgnoreCase("digestAuth")){
      System.out.println("digestAuth applying");
    }else{
      super.handleRequest(requestType);
    }
  }

}
