package org.delta.people;

import com.google.gson.Gson;
import java.util.HashMap;

public class OwnerJsonSerializationService {
    private Gson gson;
    
    public OwnerJsonSerializationService(Gson gson) {
        this.gson = gson;
    }

    public String serializeOwner(Owner owner) {
        return gson.toJson(owner);
    }
}
