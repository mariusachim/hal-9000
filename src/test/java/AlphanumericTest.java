import com.google.common.hash.Hashing;
import encode.Alphanumerical;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AlphanumericTest {

    @Test
    public void givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect() {
        String sha256hex = Hashing.sha256()
                .hashString("rezfdtlkuwfmsykcxhchgilixmwhgtyaszbnpjmhkzimozrfzp", StandardCharsets.UTF_8)
                .toString();
        String actualCodeChallenge = new String(Base64.getEncoder().encode(sha256hex.getBytes()));
        actualCodeChallenge = actualCodeChallenge.substring(0, actualCodeChallenge.length() - 2);
        Assert.assertEquals("no match",
                "OGQwMTRmNWUyZTAwNmNmZmIyMzA5N2MzOGVlYzQ5YThmMTY3NTc5YjBhNDU3Y2E2OThiYjU5NDRhZTYzN2E5Mg",
                actualCodeChallenge);
    }

    @Test
    public void givenUsingOwnImplementation() {
        String generated = new Alphanumerical().generateCodeChallenge();
        System.out.println(generated);
        Assert.assertNotNull("should not be null", generated);
    }

}
