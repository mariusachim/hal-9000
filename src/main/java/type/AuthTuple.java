package type;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthTuple {

    final String codeChallenge;
    final String codeVerifier;

}
