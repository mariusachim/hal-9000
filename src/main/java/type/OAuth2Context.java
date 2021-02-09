package type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuth2Context {

    private String csrf;
    private String transId;
    private String sessionCookie;

    public OAuth2Context(String csrf, String transId, String sessionCookie) {
        super();
        this.csrf = csrf;
        this.transId = transId;
        this.sessionCookie = sessionCookie;
    }
}
