import com.squareup.okhttp.*;
import encode.Alphanumerical;
import type.OAuth2Context;

import java.io.IOException;

public class Main {

    private static final String FORM_URL_ENCODEDED_MEDIA = "application/x-www-form-urlencoded";
    private static final MediaType MEDIA_TYPE = MediaType.parse(FORM_URL_ENCODEDED_MEDIA);
    private static final String CODE_CHALLENGE = new Alphanumerical().generateCodeChallenge();
    private static final String URL_AUTH_BASE = "https://auth.tesla.com/oauth2/v3/authorize?";
    public static final String REDIRECT_URI = "https://auth.tesla.com/void/callback";


    private static final String BASE_URL_WITH_PARAMS = URL_AUTH_BASE +
            "client_id=ownerapi" +
            "&code_challenge=" + CODE_CHALLENGE +
            "&code_challenge_method=S256" +
            "&redirect_uri=" + REDIRECT_URI +
            "&response_type=code" +
            "&scope=openid email offline_access" +
            "&state=123456";

    public static void main(String[] args) throws IOException {
        OAuth2Context ctx = call1();
        String authCode = call2(ctx, args[0], args[1]);
        System.out.println("code = " + authCode);
    }

    private static String call2(OAuth2Context ctx, String user, String pass) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MEDIA_TYPE,
                "identity=" + user +
                        "&credential=" + pass +
                        "&_csrf=" + ctx.getCsrf() +
                        "&_phase=authenticate" +
                        "&_process=1" +
                        "&transaction_id=" + ctx.getTransId() +
                        "&cancel=");
        Request request = new Request.Builder()
                .url(BASE_URL_WITH_PARAMS)
                .method("POST", body)
                .addHeader("Content-Type", FORM_URL_ENCODEDED_MEDIA)
                .addHeader("Cookie", ctx.getSessionCookie())
                .build();
        Response response = client.newCall(request).execute();
        String locationUrl = response.priorResponse().priorResponse().header("Location");
        int indexOfState = locationUrl.indexOf("&state");
        int indexOfCode = locationUrl.indexOf("code=");
        return locationUrl.substring(indexOfCode + 5, indexOfState);
    }

    private static OAuth2Context call1() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL_WITH_PARAMS)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String sessionCookie = response.header("Set-Cookie");
        String bodyString = response.body().string();
        String csrf = new ResponseBodyParser().extractCSRF(bodyString);
        String transId = new ResponseBodyParser().extractTransactionId(bodyString);
        return new OAuth2Context(csrf, transId, sessionCookie);
    }

}
