package org.delta.serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;

public class BankJsonDataSerializationService {
    @Inject
    private GsonFactory gsonFactory;

    public String serialize(BankJsonData data) {
        Gson gson = gsonFactory.create();

        return gson.toJson(data);
    }

    public BankJsonData deserialize(String data) {
        Gson gson = gsonFactory.create();

        return gson.fromJson(data, BankJsonData.class);
    }
}
