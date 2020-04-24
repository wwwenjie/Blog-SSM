package me.jinwenjie.util;

import net.sf.json.JSONObject;

public class JsonResult {
    // operation success but dose not return data
    public static JSONObject success() {
        JSONObject success = new JSONObject();
        success.put("success", true);
        return success;
    }

    // success and return single result
    public static JSONObject singleResult(Object key, Object value) {
        JSONObject singleResult = new JSONObject();
        singleResult.put(key, value);
        return singleResult;
    }
}
