package encode;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import type.AuthTuple;

public class Alphanumerical {

    public AuthTuple generateCodeChallenge() {
        String generatedString = RandomStringUtils.randomAlphabetic(86);
        System.out.println("code_verifier = " + generatedString);
        String sha256hex = Hashing.sha256()
                .hashString(generatedString, StandardCharsets.UTF_8)
                .toString();
        String padded = new String(Base64.getEncoder().encode(sha256hex.getBytes()));
        String codeChallenge = padded.substring(0, padded.length() - 2);
        String codeVerifier = generatedString;
        return new AuthTuple(codeChallenge, codeVerifier);
    }

}
