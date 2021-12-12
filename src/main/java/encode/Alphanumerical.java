package encode;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Alphanumerical {

    public static String generateCodeChallenge() {
        String generatedString = RandomStringUtils.randomAlphabetic(86);
        System.out.println("code_verifier = " + generatedString);
        String sha256hex = Hashing.sha256()
                .hashString(generatedString, StandardCharsets.UTF_8)
                .toString();
        String padded = new String(Base64.getEncoder().encode(sha256hex.getBytes()));
        return padded.substring(0, padded.length() - 2);
    }

    public static String generateState() {
        String generatedString = RandomStringUtils.randomAlphabetic(16);
        String padded = new String(Base64.getEncoder().encode(generatedString.getBytes()));
        return padded.substring(0, padded.length() - 2);
    }

}
