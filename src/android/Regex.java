package me.duras.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex extends CordovaPlugin {

    private static final String REGEX = "\\d(/?+ *+\d)++";

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("markPhoneNumbers")) {
            String text = data.getString(0);

            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(text);
            int offset = 0;

            while(m.find()) {
                // Can't be phone number, too short
                if (m.end() - m.start() < 8) {
                    continue;      
                }

                text = new StringBuilder(text).insert(m.start() + offset, "**S**").toString();
                offset = offset + 5;
                text = new StringBuilder(text).insert(m.end() + offset, "**E**").toString();
                offset = offset + 5;
            }

            callbackContext.success(text);
            return true;
        } else {
            return false;
        }
    }
}
