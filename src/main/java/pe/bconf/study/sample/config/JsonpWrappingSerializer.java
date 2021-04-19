package pe.bconf.study.sample.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class JsonpWrappingSerializer extends JsonSerializer<JsonpWrapper> {

    @Override
    public Class<JsonpWrapper> handledType() {
        return JsonpWrapper.class; }

    @Override
    public void serialize(JsonpWrapper wrapper, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        if (wrapper != null) {
            jsonGenerator.writeRaw("/**/");
            jsonGenerator.writeRaw(wrapper.getCallbackName());
            jsonGenerator.writeRaw("(");
            jsonGenerator.writeObject(wrapper.getData());
            jsonGenerator.writeRaw(");");
            System.out.println(jsonGenerator.toString());
        }
    }
}
