import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import encode.Alphanumerical;
import java.io.IOException;
import type.AuthTuple;
import type.BearerRequest;
import type.OAuth2Context;

public class Main {

    private static final String FORM_URL_ENCODEDED_MEDIA = "application/x-www-form-urlencoded";
    private static final MediaType MEDIA_TYPE = MediaType.parse(FORM_URL_ENCODEDED_MEDIA);
    private static final AuthTuple AUTH_TUPLE = new Alphanumerical().generateCodeChallenge();
    private static final String URL_AUTH_BASE = "https://auth.tesla.com/oauth2/v3/authorize?";
    public static final String REDIRECT_URI = "https://auth.tesla.com/void/callback";

    public static final String FOR_BEARER_TOKEN = "https://auth.tesla.com/oauth2/v3/token";


    private static final String BASE_URL_WITH_PARAMS = URL_AUTH_BASE +
            "client_id=ownerapi" +
            "&code_challenge=" + AUTH_TUPLE.getCodeChallenge() +
            "&code_challenge_method=S256" +
            "&redirect_uri=" + REDIRECT_URI +
            "&response_type=code" +
            "&scope=openid email offline_access" +
            "&state=123456";

    public static void main(String[] args) throws IOException {
        OAuth2Context ctx = formLogin();
        System.out.println(ctx);
        String authCode = obtainAuthorizationCode(ctx, args[0], args[1]);
        System.out.println("code URL = " + authCode);
    }

    private static OAuth2Context formLogin() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL_WITH_PARAMS)
                .method("GET", null)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        String sessionCookie = response.header("Set-Cookie");
        String bodyString = response.body().string();
        String csrf = new ResponseBodyParser().extractCSRF(bodyString);
        String transId = new ResponseBodyParser().extractTransactionId(bodyString);
        return new OAuth2Context(csrf, transId, sessionCookie);
    }

    private static String obtainAuthorizationCode(OAuth2Context ctx, String user, String pass) throws IOException {
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
        return response.priorResponse().header("Location");
    }

    private static void getBearerTokenFromAuthorizationCode() throws Exception {
        var bearerRequest = new BearerRequest(AUTH_TUPLE.getCodeChallenge(), AUTH_TUPLE.getCodeVerifier());
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), new ObjectMapper().writeValueAsString(bearerRequest));
        Request request = new Request.Builder()
                .url(FOR_BEARER_TOKEN)
                .method("POST", body)
                .build();
        new OkHttpClient().newCall(request).execute();
    }

}
