package org.delta.serialization.adapters;

import com.google.gson.*;
import org.delta.accounts.BankAccount;
import org.delta.accounts.SavingsAccount;
import org.delta.investment.InvestmentAccount;

import java.lang.reflect.Type;

public class BankAccountAdapter implements JsonDeserializer<BankAccount>, JsonSerializer<BankAccount> {
    @Override
    public BankAccount deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String typeString = jsonObject.get("type").getAsString();

        if (typeString.equals("investment")) {
            return jsonDeserializationContext.deserialize(jsonObject, InvestmentAccount.class);
        } else if (typeString.equals("savings")) {
            return jsonDeserializationContext.deserialize(jsonObject, SavingsAccount.class);
        } else {
            return jsonDeserializationContext.deserialize(jsonObject, BankAccount.class);
        }
    }

    @Override
    public JsonElement serialize(BankAccount bankAccount, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = jsonSerializationContext.serialize(bankAccount).getAsJsonObject();

        if (bankAccount instanceof InvestmentAccount) {
            jsonObject.addProperty("type", "investment");
        } else if (bankAccount instanceof SavingsAccount) {
            jsonObject.addProperty("type", "savings");
        } else {
            jsonObject.addProperty("type", "base");
        }

        return jsonObject;
    }
}
