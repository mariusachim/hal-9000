import org.junit.Assert;
import org.junit.Test;

public class ResponseBodyParserTest {

    @Test
    public void testCsrf() {
        String actual = new ResponseBodyParser().extractCSRF(TEST_TEXT);
        Assert.assertEquals("nope", "o0frWGSe-iTb6WVNM7ZatGD4e7Fg5wbCH9Mw", actual);
    }

    @Test
    public void testTransactionId() {
        String actual = new ResponseBodyParser().extractTransactionId(TEST_TEXT);
        Assert.assertEquals("nope", "OoJkhnu2", actual);
    }

    public static final String TEST_TEXT = "<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
            "\t<title>Tesla SSO - Sign In</title>\n" +
            "\n" +
            "\n" +
            "\t<!-- Required meta tags -->\n" +
            "\t<meta charset=\"utf-8\" />\n" +
            "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
            "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n" +
            "\t<meta name=\"viewport\"\n" +
            "\t\tcontent=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0, viewport-fit=cover\" />\n" +
            "\n" +
            "\t<link rel=\"stylesheet\" href=\"/static/css/gotham-book.css\" />\n" +
            "\t<link rel=\"stylesheet\" href=\"/static/css/gotham-medium.css\" />\n" +
            "\t<link rel=\"stylesheet\" href=\"/static/css/minimal.bundle.css\" />\n" +
            "\t<link rel=\"stylesheet\" href=\"/static/css/shims.min.css\" />\n" +
            "\n" +
            "\t<script src=\"/static/js/i18next.bundle.min.js\"></script>\n" +
            "\t<script src=\"/static/js/i18n.js\"></script>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t<script type=\"text/javascript\" nonce=\"72466476f2dd83d735f1\">\n" +
            "\t\tdocument.addEventListener(\"DOMContentLoaded\", function(event) {\n" +
            "      applyDarkMode && applyDarkMode();\n" +
            "\n" +
            "      var messages = {};\n" +
            "\n" +
            "      for (var prop in messages) {\n" +
            "        addErrorMessage(messages[prop], prop);\n" +
            "      }\n" +
            "\n" +
            "      //  Auto-focus\n" +
            "      if (document.querySelector(\"#form-input-identity\").value) {\n" +
            "        document.querySelector(\"#form-input-credential\").focus();\n" +
            "      }\n" +
            "\n" +
            "      i18n().init([\"common\", \"login\"], function(err, t) {\n" +
            "        i18n().translate();\n" +
            "\n" +
            "        var form = document.getElementById(\"form\");\n" +
            "\n" +
            "        var cancel = form.querySelector(\"#form-submit-cancel\");\n" +
            "        if (cancel) {\n" +
            "          cancel.addEventListener(\"click\", function(event) {\n" +
            "            form.querySelector(\"#form-input-cancel\").value = \"1\";\n" +
            "            form.submit();\n" +
            "          });\n" +
            "        }\n" +
            "\n" +
            "        var submit = form.querySelector(\"#form-submit-continue\");\n" +
            "        submit.addEventListener(\"click\", function(event) {\n" +
            "          event.target.disabled = true;\n" +
            "          form.submit();\n" +
            "        });\n" +
            "\n" +
            "        //  Auto-focus\n" +
            "        if (form.querySelector(\"#form-input-identity\").value) {\n" +
            "          document.querySelector(\"#form-input-credential\").focus();\n" +
            "        }\n" +
            "        else {\n" +
            "          form.querySelector(\"#form-input-identity\").focus();\n" +
            "        }\n" +
            "      });\n" +
            "\n" +
            "    });\n" +
            "\t</script>\n" +
            "\n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<body class=\"tds-scrim--black tds-theme--palladium\">\n" +
            "\n" +
            "\t<div class=\"tmp-shell tds--fade-in-\">\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t<main id=\"main-content\" class=\"tmp-shell-row tmp-shell-row--stretch\">\n" +
            "\t\t\t<div class=\"tds-content_container tds-content_container--small\">\n" +
            "\n" +
            "\n" +
            "\t\t\t\t<h1 class=\"tds-text--h1-alt\" data-i18n-key=\"login:pageHeader\">Sign In</h1>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t<div class=\"tds-status_msg tds-status_msg--enclosed tds--is_hidden\" role=\"alert\" data-field=\"_\">\n" +
            "\t\t\t\t\t<svg class=\"tds-status_msg-icon\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "\t\t\t\t\t\t<title>Error Icon</title>\n" +
            "\t\t\t\t\t\t<description>A error icon, calling your attention to an issue preventing form submission.\n" +
            "\t\t\t\t\t\t</description>\n" +
            "\t\t\t\t\t\t<use xlink:href=\"#tds-error\"></use>\n" +
            "\t\t\t\t\t</svg>\n" +
            "\t\t\t\t\t<div class=\"tds-status_msg-text\">\n" +
            "\t\t\t\t\t\t<!--\n" +
            "    <div class=\"tds-status_msg-header\">\n" +
            "      <h6>Error</h6>\n" +
            "    </div>\n" +
            "    -->\n" +
            "\t\t\t\t\t\t<div class=\"tds-status_msg-body\">\n" +
            "\t\t\t\t\t\t\t<!--<p>Required information is not present in form: &lt;field name&gt;</p>-->\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</div>\n" +
            "\n" +
            "\n" +
            "\t\t\t\t<div class=\"single-column-form-wrapper\">\n" +
            "\t\t\t\t\t<form method=\"post\" id=\"form\" class=\"sso-form sign-in-form\">\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" name=\"_csrf\" value=\"o0frWGSe-iTb6WVNM7ZatGD4e7Fg5wbCH9Mw\" />\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" name=\"_phase\" value=\"authenticate\" />\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" name=\"_process\" value=\"1\" />\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" name=\"transaction_id\" value=\"OoJkhnu2\" />\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" name=\"cancel\" value=\"\" id=\"form-input-cancel\" />\n" +
            "\n" +
            "\t\t\t\t\t\t<div class=\"tds-form-item\">\n" +
            "\t\t\t\t\t\t\t<label class=\"tds-form-item-label\" for=\"form-input-identity\">\n" +
            "                <span data-i18n-key=\"login:formIdentityLabel1\">Email Address</span>\n" +
            "                <div class=\"tds-tooltip\">\n" +
            "                  <button type=\"button\" class=\"tds-tooltip-trigger\" aria-label=\"Email Address Tooltip\">\n" +
            "                    <i class=\"tds-tooltip-icon\"></i>\n" +
            "                  </button>\n" +
            "                  <div class=\"tds-tooltip-content\">\n" +
            "                    <p data-i18n-key=\"login:formIdentityTooltipText1\">\n" +
            "                      If your account is linked to an email address you no longer have access to, please sign into your account and update your email address under account settings\n" +
            "                    </p>\n" +
            "                    <p data-i18n-key=\"login:formIdentityTooltipText2\" data-i18n-data=\"{&#34;link&#34;:{&#34;start&#34;:&#34;&lt;a href=\\&#34;https://www.tesla.com/support/account-support\\&#34; target=\\&#34;_blank\\&#34;&gt;&#34;,&#34;end&#34;:&#34;&lt;/a&gt;&#34;}}\">\n" +
            "                      If you have trouble signing in, please visit our support page\n" +
            "                    </p>\n" +
            "                  </div>\n" +
            "                </div><!-- tds-tooltip -->\n" +
            "              </label>\n" +
            "\t\t\t\t\t\t\t<div class=\"tds-text-input--wrapper\" data-field=\"identity\">\n" +
            "\t\t\t\t\t\t\t\t<input class=\"tds-text-input\" id=\"form-input-identity\" type=\"text\"  name=\"identity\" value=\"\" autocomplete=\"username\" autocapitalize=\"none\" />\n" +
            "\t\t\t\t\t\t\t\t<div class=\"tds-form-item-feedback\"></div>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div><!-- tds-form-item -->\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\t<div class=\"tds-form-item tds-form-item--password\" data-showlabel=\"Show Password\"\n" +
            "\t\t\t\t\t\t\tdata-hidelabel=\"Hide Password\" data-showicon=\"tds-eye-show\" data-hideicon=\"tds-eye-hide\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<label class=\"tds-form-item-label\" for=\"password-input\">\n" +
            "                <span data-i18n-key=\"login:formPasswordLabel\">Password</span>\n" +
            "              </label>\n" +
            "\n" +
            "\t\t\t\t\t\t\t<div class=\"tds-text-input--wrapper\" data-field=\"password\">\n" +
            "\t\t\t\t\t\t\t\t<input class=\"tds-text-input\" id=\"form-input-credential\" type=\"password\"  name=\"credential\" autocomplete=\"current-password\" autocapitalize=\"none\" aria-label=\"credentials-input\" />\n" +
            "\t\t\t\t\t\t\t\t<button class=\"tds-password-input--toggle\" type=\"button\">\n" +
            "                  <svg class=\"tds-icon\">\n" +
            "                    <title>Show Password</title>\n" +
            "                    <desc>Click Icon to toggle password visibility</desc>\n" +
            "                    <use xlink:href=\"#tds-eye-show\"></use>\n" +
            "                  </svg>\n" +
            "                </button>\n" +
            "\t\t\t\t\t\t\t\t<div class=\"tds-form-item-feedback\"></div>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\t<button type=\"submit\" class=\"tds-btn tds-btn--blue tds-btn--full\" data-i18n-key=\"login:formSubmitLabel\" id=\"form-submit-continue\">\n" +
            "              Sign In\n" +
            "            </button>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\t<p class=\"need-help tds-text--center\">\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\t\t<a href=\"https://www.tesla.com/support/account-support\" target=\"_blank\" class=\"tds-link\"\n" +
            "\t\t\t\t\t\t\t\tdata-i18n-key=\"login:forgotSupportLinkLabel\">Forgot email?</a>\n" +
            "\t\t\t\t\t\t\t<span class=\"tmp-link-separator\">|</span>\n" +
            "\n" +
            "\t\t\t\t\t\t\t<a href=\"/user/password/forgot\" class=\"tds-link\"\n" +
            "\t\t\t\t\t\t\t\tdata-i18n-key=\"login:forgotPasswordLinkLabel\">Forgot password?</a>\n" +
            "\t\t\t\t\t\t</p>\n" +
            "\n" +
            "\t\t\t\t\t</form>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t</div>\n" +
            "\n" +
            "\n" +
            "\t\t\t</div>\n" +
            "\t\t</main>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t</div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t<dialog id=\"locale-modal\" class=\"tds-modal\">\n" +
            "\t\t<button type=\"button\" class=\"tds-modal-close\" aria-label=\"Close Locale Modal\" data-should-close=\"locale-modal\">\n" +
            "    <i class=\"tds-modal-close-icon\"></i>\n" +
            "  </button>\n" +
            "\n" +
            "\t\t<section class=\"tds-modal-container\">\n" +
            "\t\t\t<header class=\"tds-modal-header\">\n" +
            "\t\t\t\t<h2>Select Your Market</h2>\n" +
            "\t\t\t</header>\n" +
            "\n" +
            "\t\t\t<section class=\"tds-modal-content\">\n" +
            "\n" +
            "\n" +
            "\t\t\t\t<main class=\"tds-modal-body_content overflow-scroll-gradient\">\n" +
            "\t\t\t\t\t<div class=\"locale-list-container overflow-scroll-gradient__scroller\">\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\t<div class=\"locale-region--North America\">\n" +
            "\t\t\t\t\t\t\t<h4 class=\"tds-text--body_headline region-title notranslate\">North America</h4>\n" +
            "\t\t\t\t\t\t\t<ul class=\"region-list\">\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_us\" data-sublang=\"us\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--us\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_us\" title=\"United States\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-US\">United States</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_ca has_sublang\" data-sublang=\"ca\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ca\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_ca\" title=\"Canada\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-CA\">Canada</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_ca is-sublang-ca is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"ca\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ca\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_ca\" title=\"English\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-CA\">English</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_ca is-sublang-ca is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"ca\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ca\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"fr_ca\" title=\"Français\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"fr-CA\">Français</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-es_mx\" data-sublang=\"mx\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--mx\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"es_mx\" title=\"México\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"es-MX\">México</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<div class=\"locale-region--Europe\">\n" +
            "\t\t\t\t\t\t\t<h4 class=\"tds-text--body_headline region-title notranslate\">Europe</h4>\n" +
            "\t\t\t\t\t\t\t<ul class=\"region-list\">\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-nl_be has_sublang\" data-sublang=\"be\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--be\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"nl_be\" title=\"Belgium\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"nl-BE\">Belgium</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_be is-sublang-be is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"be\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--be\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"nl_be\" title=\"Nederlands\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"nl-BE\">Nederlands</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_be is-sublang-be is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"be\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--be\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"fr_be\" title=\"Français\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"fr-BE\">Français</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-cs_cz\" data-sublang=\"cz\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--cz\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"cs_cz\" title=\"Česko\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"cs-CZ\">Česko</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-da_dk\" data-sublang=\"dk\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--dk\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"da_dk\" title=\"Danmark\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"da-DK\">Danmark</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-de_de\" data-sublang=\"de\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--de\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"de_de\" title=\"Deutschland\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"de\">Deutschland</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-es_es\" data-sublang=\"es\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--es\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"es_es\" title=\"España\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"es\">España</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-fr_fr\" data-sublang=\"fr\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--fr\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"fr_fr\" title=\"France\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"fr\">France</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_gb\" data-sublang=\"gb\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--gb\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_gb\" title=\"United Kingdom\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-GB\">United Kingdom</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_ie\" data-sublang=\"ie\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ie\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_ie\" title=\"Ireland\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-IE\">Ireland</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-is_is\" data-sublang=\"is\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--is\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"is_is\" title=\"Iceland\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"is\">Iceland</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-it_it\" data-sublang=\"it\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--it\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"it_it\" title=\"Italia\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"it\">Italia</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-fr_lu has_sublang\" data-sublang=\"lu\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--lu\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"fr_lu\" title=\"Luxembourg\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"fr-LU\">Luxembourg</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_lu is-sublang-lu is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"lu\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--lu\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"fr_lu\" title=\"Français\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"fr-LU\">Français</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_lu is-sublang-lu is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"lu\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--lu\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"de_lu\" title=\"Deutsch\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"de-LU\">Deutsch</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-nl_nl\" data-sublang=\"nl\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--nl\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"nl_nl\" title=\"Nederland\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"nl\">Nederland</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-no_no\" data-sublang=\"no\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--no\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"no_no\" title=\"Norge\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"no\">Norge</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-de_at\" data-sublang=\"at\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--at\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"de_at\" title=\"Österreich\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"de-AT\">Österreich</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-pl_pl\" data-sublang=\"pl\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--pl\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"pl_pl\" title=\"Polska\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"pt\">Polska</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-pt_pt\" data-sublang=\"pt\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--pt\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"pt_pt\" title=\"Portugal\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"pt\">Portugal</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-fr_ch has_sublang\" data-sublang=\"ch\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ch\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"fr_ch\" title=\"Switzerland\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"fr-CH\">Switzerland</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_ch is-sublang-ch is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"ch\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ch\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"fr_ch\" title=\"Français\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"fr-CH\">Français</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_ch is-sublang-ch is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"ch\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ch\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"de_ch\" title=\"Deutsch\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"de-CH\">Deutsch</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_ch is-sublang-ch is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"ch\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ch\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"it_ch\" title=\"Italiano\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"it-CH\">Italiano</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-sv_se\" data-sublang=\"se\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--se\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"sv_se\" title=\"Sverige\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"sv-SE\">Sverige</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-fi_fi\" data-sublang=\"fi\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--fi\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"fi_fi\" title=\"Suomi\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"fi\">Suomi</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_eu\" data-sublang=\"eu\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--eu\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_eu\" title=\"Other Europe\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-EU\">Other Europe</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<div class=\"locale-region--Middle-East\">\n" +
            "\t\t\t\t\t\t\t<h4 class=\"tds-text--body_headline region-title notranslate\">Middle-East</h4>\n" +
            "\t\t\t\t\t\t\t<ul class=\"region-list\">\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_ae\" data-sublang=\"ae\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--ae\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_ae\" title=\"UAE\" class=\"region-link notranslate\" data-lang=\"en-AE\">UAE</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_jo\" data-sublang=\"jo\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--jo\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_jo\" title=\"Jordan\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-JO\">Jordan</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<div class=\"locale-region--Asia/Pacific\">\n" +
            "\t\t\t\t\t\t\t<h4 class=\"tds-text--body_headline region-title notranslate\">Asia/Pacific</h4>\n" +
            "\t\t\t\t\t\t\t<ul class=\"region-list\">\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-zh_cn\" data-sublang=\"cn\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--cn\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"zh_cn\" title=\"中国大陆\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"zh-CN\">中国大陆</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-zh_hk has_sublang\" data-sublang=\"hk\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--hk\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"zh_hk\" title=\"Hong Kong\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"zh-HK\">Hong Kong</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_hk is-sublang-hk is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"hk\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--hk\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"zh_hk\" title=\"中文\" class=\"region-link notranslate\" data-lang=\"zh-HK\">中文</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_hk is-sublang-hk is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"hk\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--hk\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_hk\" title=\"English\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-HK\">English</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_mo has_sublang\" data-sublang=\"mo\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--mo\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_mo\" title=\"Macau\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-MO\">Macau</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_mo is-sublang-mo is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"mo\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--mo\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_mo\" title=\"English\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-MO\">English</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_mo is-sublang-mo is-sublang tds--fade-in tds--is_hidden\"\n" +
            "\t\t\t\t\t\t\t\t\tdata-sublang=\"mo\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--mo\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"zh_mo\" title=\"中文\" class=\"region-link notranslate\" data-lang=\"zh-MO\">中文</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-zh_tw\" data-sublang=\"tw\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--tw\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"zh_tw\" title=\"台灣\" class=\"region-link notranslate\" data-lang=\"zh-TW\">台灣</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-ja_jp\" data-sublang=\"jp\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--jp\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"ja_jp\" title=\"日本\" class=\"region-link notranslate\" data-lang=\"ja-JP\">日本</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-ko_kr\" data-sublang=\"kr\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--kr\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"ko_kr\" title=\"대한민국\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"ko-KR\">대한민국</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_au\" data-sublang=\"au\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--au\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_au\" title=\"Australia\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-AU\">Australia</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t<li class=\"region-item i18n-en_nz\" data-sublang=\"nz\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"tds-icon tds-icon-flag--nz\"></i>\n" +
            "\t\t\t\t\t\t\t\t\t<a rel=\"en_nz\" title=\"New Zealand\" class=\"region-link notranslate\"\n" +
            "\t\t\t\t\t\t\t\t\t\tdata-lang=\"en-NZ\">New Zealand</a>\n" +
            "\t\t\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</main>\n" +
            "\n" +
            "\n" +
            "\t\t\t</section>\n" +
            "\t\t</section>\n" +
            "\t</dialog>\n" +
            "\n" +
            "\n" +
            "\t<div class=\"tds-modal-backdrop\" data-should-close=\"tds-modal-fullscreen-example\"></div>\n" +
            "\n" +
            "\n" +
            "\t<div id=\"spinner-modal\" class=\"tds-spinner tds-spinner--fade_out tds-spinner-fullscreen\"></div>\n" +
            "\n" +
            "\n" +
            "\t<!-- Animated Backdrop -->\n" +
            "\t<div class=\"tds-site-nav--flyout-backdrop\" data-tds-close=\"mobile-flyout\"></div>\n" +
            "\n" +
            "\n" +
            "\t<!-- SVG lookup table - Following pattern from design.tesla.com -->\n" +
            "\t<div class=\"tds--is_visually_hidden\">\n" +
            "\t\t<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
            "\t\t\t<symbol xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 30 30\" id=\"tds-eye-hide--inverted\">\n" +
            "\t\t\t\t<g fill=\"#fff\" fill-rule=\"evenodd\" transform=\"translate(6 7)\">\n" +
            "\t\t\t\t\t<path fill-rule=\"nonzero\"\n" +
            "\t\t\t\t\t\td=\"M17.51 7.81c0 1.48-4.1 5.75-8.77 5.75a8.5 8.5 0 01-2.49-.4l1.23-1.22c.42.08.84.12 1.26.12 1.8 0 3.62-.76 5.2-2.01 1.14-.9 2.04-2.05 2.04-2.24 0-.2-.89-1.34-2.02-2.24l-.06-.05 1.07-1.07c1.56 1.23 2.55 2.63 2.54 3.36zm-5.27 0a3.5 3.5 0 01-4.08 3.45l4.03-4.03c.04.19.05.38.05.58zm-3.5-5.75c.88 0 1.74.15 2.56.4L10.07 3.7a6.89 6.89 0 00-1.33-.13c-1.82 0-3.64.76-5.21 2-1.14.9-2 2.05-2 2.25 0 .19.87 1.34 2.01 2.24l.1.07-1.07 1.08C1 9.95 0 8.54 0 7.8c0-1.48 4.08-5.73 8.74-5.75zm0 2.25c.23 0 .44.02.65.06L5.3 8.46a3.52 3.52 0 013.44-4.15z\" />\n" +
            "\t\t\t\t\t<rect width=\"1.5\" height=\"19.62\" x=\"8.01\" y=\"-2\" rx=\".75\"\n" +
            "\t\t\t\t\t\ttransform=\"scale(-1 1) rotate(-45 0 28.95)\" />\n" +
            "\t\t\t\t</g>\n" +
            "\t\t\t</symbol>\n" +
            "\t\t\t<symbol xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 30 30\" id=\"tds-eye-hide\">\n" +
            "\t\t\t\t<g fill=\"#000\" fill-rule=\"evenodd\" transform=\"translate(6 7)\">\n" +
            "\t\t\t\t\t<path fill-rule=\"nonzero\"\n" +
            "\t\t\t\t\t\td=\"M17.51 7.81c0 1.48-4.1 5.75-8.77 5.75a8.5 8.5 0 01-2.49-.4l1.23-1.22c.42.08.84.12 1.26.12 1.8 0 3.62-.76 5.2-2.01 1.14-.9 2.04-2.05 2.04-2.24 0-.2-.89-1.34-2.02-2.24l-.06-.05 1.07-1.07c1.56 1.23 2.55 2.63 2.54 3.36zm-5.27 0a3.5 3.5 0 01-4.08 3.45l4.03-4.03c.04.19.05.38.05.58zm-3.5-5.75c.88 0 1.74.15 2.56.4L10.07 3.7a6.89 6.89 0 00-1.33-.13c-1.82 0-3.64.76-5.21 2-1.14.9-2 2.05-2 2.25 0 .19.87 1.34 2.01 2.24l.1.07-1.07 1.08C1 9.95 0 8.54 0 7.8c0-1.48 4.08-5.73 8.74-5.75zm0 2.25c.23 0 .44.02.65.06L5.3 8.46a3.52 3.52 0 013.44-4.15z\" />\n" +
            "\t\t\t\t\t<rect width=\"1.5\" height=\"19.62\" x=\"8.01\" y=\"-2\" rx=\".75\"\n" +
            "\t\t\t\t\t\ttransform=\"scale(-1 1) rotate(-45 0 28.95)\" />\n" +
            "\t\t\t\t</g>\n" +
            "\t\t\t</symbol>\n" +
            "\t\t\t<symbol xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 30 30\" id=\"tds-eye-show--inverted\">\n" +
            "\t\t\t\t<g fill=\"none\" fill-rule=\"evenodd\" stroke=\"#fff\" transform=\"translate(7 10)\">\n" +
            "\t\t\t\t\t<circle cx=\"8\" cy=\"5\" r=\"2.31\" stroke-width=\"2.37\" />\n" +
            "\t\t\t\t\t<path stroke-width=\"1.5\"\n" +
            "\t\t\t\t\t\td=\"M8 0c4.49 0 8 4.13 8 5 0 .87-3.56 5-8 5-4.44 0-8-4.12-8-5 0-.88 3.51-5 8-5z\" />\n" +
            "\t\t\t\t</g>\n" +
            "\t\t\t</symbol>\n" +
            "\t\t\t<symbol xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 30 30\" id=\"tds-eye-show\">\n" +
            "\t\t\t\t<g fill=\"none\" stroke=\"#000\" fill-rule=\"evenodd\" transform=\"translate(7 10)\">\n" +
            "\t\t\t\t\t<circle cx=\"8\" cy=\"5\" r=\"2.31\" stroke-width=\"2.37\" />\n" +
            "\t\t\t\t\t<path stroke-width=\"1.5\"\n" +
            "\t\t\t\t\t\td=\"M8 0c4.49 0 8 4.13 8 5 0 .87-3.56 5-8 5-4.44 0-8-4.12-8-5 0-.88 3.51-5 8-5z\" />\n" +
            "\t\t\t\t</g>\n" +
            "\t\t\t</symbol>\n" +
            "\t\t\t<symbol xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 20 20\" id=\"tds-error\">\n" +
            "\t\t\t\t<g fill=\"none\" fill-rule=\"evenodd\">\n" +
            "\t\t\t\t\t<circle cx=\"10\" cy=\"10\" r=\"10\" fill=\"#ED4E3B\" />\n" +
            "\t\t\t\t\t<path fill=\"#fff\"\n" +
            "\t\t\t\t\t\td=\"M10.075 4.5c.65 0 1.179.528 1.179 1.179v4.714a1.179 1.179 0 11-2.358 0V5.679A1.18 1.18 0 0110.075 4.5zm0 8.25a1.375 1.375 0 110 2.75 1.375 1.375 0 010-2.75z\" />\n" +
            "\t\t\t\t</g>\n" +
            "\t\t\t</symbol>\n" +
            "\t\t\t<symbol xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 20 18\" id=\"tds-warning\">\n" +
            "\t\t\t\t<g fill=\"none\" fill-rule=\"evenodd\">\n" +
            "\t\t\t\t\t<path d=\"M0-1h20v20H0z\" />\n" +
            "\t\t\t\t\t<path fill=\"#FBB01B\"\n" +
            "\t\t\t\t\t\td=\"M12.825 1.627l6.663 11.077C20.875 15.009 19.28 18 16.663 18H3.337C.72 18-.875 15.01.512 12.704L7.175 1.627a3.266 3.266 0 015.65 0z\" />\n" +
            "\t\t\t\t\t<path\n" +
            "\t\t\t\t\t\td=\"M10.075 4c.65 0 1.179.528 1.179 1.179v4.714a1.179 1.179 0 11-2.358 0V5.179A1.18 1.18 0 0110.075 4zm0 8.25a1.375 1.375 0 110 2.75 1.375 1.375 0 010-2.75z\"\n" +
            "\t\t\t\t\t\tfill=\"#FFF\" />\n" +
            "\t\t\t\t</g>\n" +
            "\t\t\t</symbol>\n" +
            "\t\t</svg>\n" +
            "\t</div>\n" +
            "\n" +
            "\n" +
            "\t<script src=\"/static/js/minimal.bundle.js\" type=\"application/javascript\"></script>\n" +
            "\t<script src=\"/static/scripts/utils.js\" type=\"application/javascript\"></script>\n" +
            "\t<script src=\"/static/js/site.js\" type=\"application/javascript\"></script>\n" +
            "\t<script src=\"/static/js/tds-text-inputs--password.js\" type=\"application/javascript\"></script>\n" +
            "\n" +
            "\t<!-- @todo rolling index crypto keys: http://bitly.com/2WXBRNp -->\n" +
            "</body>\n" +
            "\n" +
            "</html>";

}