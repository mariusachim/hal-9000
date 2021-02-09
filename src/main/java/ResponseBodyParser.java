
public class ResponseBodyParser {


    /*
    					<form method="post" id="form" class="sso-form sign-in-form">
						<input type="hidden" name="_csrf" value="o0frWGSe-iTb6WVNM7ZatGD4e7Fg5wbCH9Mw" />
						<input type="hidden" name="_phase" value="authenticate" />
						<input type="hidden" name="_process" value="1" />
						<input type="hidden" name="transaction_id" value="OoJkhnu2" />
						<input type="hidden" name="cancel" value="" id="form-input-cancel" />
     */

    public String extractCSRF(String responseBody) {
        String prefix = "input type=\"hidden\" name=\"_csrf\" value=\"";
        int index = responseBody.indexOf(prefix);
        return responseBody.substring(index + 40, index + 76);
    }

    public String extractTransactionId(String responseBody) {
        String prefix = "input type=\"hidden\" name=\"transaction_id\" value=\"";
        int index = responseBody.indexOf(prefix);
        return responseBody.substring(index + 49, index + 57);
    }

}
