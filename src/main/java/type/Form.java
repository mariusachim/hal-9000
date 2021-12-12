package type;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Form {

    String csrf;
    String phase;
    String process;
    String transactionId;
    String cancel;
    String identity;
    String credential;

}
