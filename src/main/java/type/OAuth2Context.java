package type;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OAuth2Context {

    String state;
    String codeChallenge;
    String codeVerifier;
    List<String> sessionCookies;
    Form form;

}
