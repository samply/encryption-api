package de.samply.encryption.encryptionapi.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.samply.project.encryption.model.*;

public class EncryptionModelMapper {
    private static ObjectMapper mapper = new ObjectMapper();

    public static StringResponse stringToStringResponse(String publicKeyAsymmetric) {
        StringResponse stringResponse = new StringResponse();
        stringResponse.setString(publicKeyAsymmetric);
        return stringResponse;
    }

    public static String stringRequestToString(StringRequest request) {
        String string = request.getString();
        return string;
    }
}