package org.delta.serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;

public class BankJsonDataSerializationService {
    @Inject
    private Gson gson;

    public String serialize(BankJsonData data) {
        return gson.toJson(data);
    }
}
