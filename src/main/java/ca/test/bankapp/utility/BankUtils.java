package ca.test.bankapp.utility;

import ca.test.bankapp.config.BjftTranslator;

public abstract class BankUtils {

    public static String clearExceptionMessage(String exceptionMessage) {
        if(exceptionMessage == null || exceptionMessage.contains("WriteConflict")
                || exceptionMessage.contains("::") || exceptionMessage.contains("Query failed")) {
            return trans("exception.service-not-available");
        }
        else {
            return exceptionMessage;
        }
    }

    public static String trans(String key) {
        return BjftTranslator.toLocale(key);
    }

}
