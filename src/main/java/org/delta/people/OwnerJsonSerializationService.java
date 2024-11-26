package org.delta.people;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.HashMap;

@Singleton
public class OwnerJsonSerializationService {
    @Inject
    public Gson gson;
    
    public String serializeOwner(Owner owner) {
        return gson.toJson(owner);
    }
}
