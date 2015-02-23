package es.ffgiraldez.hmr.rest;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Arrays;

import retrofit.converter.ConversionException;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
/**
 *
 * @author Fernando Franco Giráldez
 */
public class OpenLibraGsonConverter extends GsonConverter {
    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public OpenLibraGsonConverter(Gson gson) {
        super(gson);
    }

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        byte[] content = null;
        try {
            content = readBytes(body.in());
            content = Arrays.copyOfRange(content, 1, content.length - 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TypedInput sanitized = new TypedByteArray(body.mimeType(), content);
        return super.fromBody(sanitized, type);
    }

    // ----------------------------------
    // PRIVATE
    // ----------------------------------
    private byte[] readBytes(InputStream inputStream) throws IOException {
        // this dynamically extends to take the bytes you read
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        // this is storage overwritten on each iteration with bytes
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        // we need to know how may bytes were read to write them to the byteBuffer
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        // and then we can return your byte array.
        return byteBuffer.toByteArray();
    }
}