package pe.bconf.study.sample.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=JsonpWrappingSerializer.class)
public class JsonpWrapper {
    private String callbackName;
    private Object data;

    public JsonpWrapper(String callbackName, Object data) {
        this.callbackName = callbackName;
        this.data = data;
    }

    public String getCallbackName() {
        return callbackName;
    }

    public Object getData() {
        return data;
    }
}
