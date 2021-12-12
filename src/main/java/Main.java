import com.squareup.okhttp.*;
import encode.Alphanumerical;
import type.Form;
import type.OAuth2Context;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


//POST /oauth2/v1/authorize?redirect_uri=https://www.tesla.com/teslaaccount/owner-xp/auth/callback&response_type=code&client_id=ownership&scope=offline_access%20openid%20ou_code%20email&audience=https%3A%2F%2Fownership.tesla.com%2F&locale=en-US HTTP/2
//        Host: auth.tesla.com
//        User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:90.0) Gecko/20100101 Firefox/90.0
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//Accept-Language: en-US,en;q=0.5
//Accept-Encoding: gzip, deflate, br
//Content-Type: application/x-www-form-urlencoded
//Content-Length: 141
//Origin: https://auth.tesla.com
//Connection: keep-alive
//Referer: https://auth.tesla.com/oauth2/v1/authorize?redirect_uri=https://www.tesla.com/teslaaccount/owner-xp/auth/callback&response_type=code&client_id=ownership&scope=offline_access%20openid%20ou_code%20email&audience=https%3A%2F%2Fownership.tesla.com%2F&locale=en-US
//Cookie: _ga_KFP8T9JWYJ=GS1.1.1639238086.5.1.1639238111.0; _ga=GA1.2.987118571.1639166971; _gid=GA1.2.1386152639.1639166971; tesla-auth.sid=s%3Ayx-comB7JrT_Hu9i_6jquaN2zKIbl-Xr.j8ezs3mcL8B3ty2PITFKXlYidz7xuhEsLzcLFyka1pY; _abck=9744CB8F9B5F44F4659D0E0F9920F757~0~YAAQPEx1aKlr+qd9AQAALNw0qgcFEpLbHSKdlBemHq/3bXJZu6tpiG1XV3YhjICdgmtWTFx7bEPAyaElimK3V5XzmDAi62XhJLXFy7nNlNzGQDXcWz63TbVDbOoN6DCGlkhLluQqVpnrgBXKcBkhRw1QBUyr2cro6jqWM5dItdLX1FmPdRCPPGch+bE53+l4FYFJEftMDfW77ZBfCBv500ND0QztPrZvU/0E5asESQ44rT1fiU+2QIRnxu2x/457kIvfWGgpHLahaorVsBWx9B8a4d1pX7omLiB0xuWBO/Lehdkvu/B3oLDvF5rnmmY+g7gCqNGzof00kHdhtvxeL5zGaLS4Zr30GlxfhcTIqiXxGytYZF1NmYcmzwN5iPSB8n0EqVwIQ24WHaeRD/tSPOSbUiVaHbg=~-1~-1~-1; RT="z=1&dm=tesla.com&si=o7hada2987b&ss=kx0tqb2k&sl=0&tt=0"; i18next=en-US
//Upgrade-Insecure-Requests: 1
//Sec-Fetch-Dest: document
//Sec-Fetch-Mode: navigate
//Sec-Fetch-Site: same-origin
//Sec-Fetch-User: ?1


public class Main {

    private static final String FORM_URL_ENCODEDED_MEDIA = "application/x-www-form-urlencoded";
    private static final MediaType MEDIA_TYPE = MediaType.parse(FORM_URL_ENCODEDED_MEDIA);
    private static final String CODE_CHALLENGE = Alphanumerical.generateCodeChallenge();
    private static final String STATE = Alphanumerical.generateState();
    private static final String URL_AUTH_BASE = "https://auth.tesla.com/oauth2/v3/authorize?";
    public static final String REDIRECT_URI = "https://auth.tesla.com/void/callback";


    private static final String BASE_URL_WITH_PARAMS = URL_AUTH_BASE +
            "client_id=ownerapi" +
            "&code_challenge=" + CODE_CHALLENGE +
            "&code_challenge_method=S256" +
            "&redirect_uri=" + REDIRECT_URI +
            "&response_type=code" +
            "&scope=openid email offline_access" +
            "&state=" + STATE;

    public static void main(String[] args) throws IOException {
        OAuth2Context ctx = codeChallenge();
        String authCode = authenticate(ctx, args[0], args[1]);
        System.out.println("code = " + authCode);
    }


    private static String authenticate(OAuth2Context ctx, String user, String pass) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MEDIA_TYPE,
                "identity=" + user +
                        "&credential=" + pass +
                        "&_csrf=" + ctx.getForm().getCsrf() +
                        "&_phase=" + ctx.getForm().getPhase() +
                        "&_process=" + ctx.getForm().getProcess() +
                        "&transaction_id=" + ctx.getForm().getTransactionId() +
                        "&cancel=" + ctx.getForm().getCancel());
        Request request = new Request.Builder()
                .url(BASE_URL_WITH_PARAMS)
                .method("POST", body)
                .addHeader("Content-Type", FORM_URL_ENCODEDED_MEDIA)
                .addHeader("Cookie", String.join("; ", ctx.getSessionCookies()))
                .addHeader("Content-Length", String.valueOf(body.contentLength()))
                .addHeader("Accept", "application/json, text/plain, */*")
                .build();
        Response response = client.newCall(request).execute();
/*        String locationUrl = response.priorResponse().priorResponse().header("Location");
        int indexOfState = locationUrl.indexOf("&state");
        int indexOfCode = locationUrl.indexOf("code=");
        return locationUrl.substring(indexOfCode + 5, indexOfState);*/
        System.out.println(response.toString());
        System.out.println(response.body().string());
        return "authCodeHardCoded";
    }

    private static OAuth2Context codeChallenge() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL_WITH_PARAMS)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        List<String> sessionCookies = response.headers("Set-Cookie").stream()
                .map(s -> s.substring(0, s.indexOf(";")))
                .collect(Collectors.toList());
        String bodyString = response.body().string();
        Form hiddenHtmlForm = ResponseBodyParser.getHtmlForm(bodyString);

        return OAuth2Context.builder()
                .sessionCookies(sessionCookies)
                .form(hiddenHtmlForm)
                .build();
    }

}
