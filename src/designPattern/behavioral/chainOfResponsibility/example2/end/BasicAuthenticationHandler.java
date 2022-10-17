package designPattern.behavioral.chainOfResponsibility.example2.end;

public class BasicAuthenticationHandler extends AuthenticationHandler {

  public BasicAuthenticationHandler(AuthenticationHandler next) {
    super(next);
  }

  public void handleRequest(String requestType) {
    if(requestType.equalsIgnoreCase("basicAuth")){
      System.out.println("basicAuth applying");
    }else{
      super.handleRequest(requestType);
    }
  }

}
