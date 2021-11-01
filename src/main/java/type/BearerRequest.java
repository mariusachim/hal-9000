package type;


public class BearerRequest {

    final String code;
    final String codeVerifier;
    String grantType;
    String clientId;
    String redirectUrl;

    public BearerRequest(String code, String codeVerifier) {
        super();
        this.code = code;
        this.codeVerifier = codeVerifier;
        this.grantType = "authorization_code";
        this.clientId = "ownerapi";
        this.redirectUrl = "https://auth.tesla.com/void/callback";
    }

}
