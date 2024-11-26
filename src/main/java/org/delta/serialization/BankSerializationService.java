package org.delta.serialization;

import com.google.inject.Inject;
import org.delta.storage.FileSystemStorage;

public class BankSerializationService {
    @Inject
    private BankJsonDataFacade bankJsonDataFacade;

    @Inject
    private BankJsonDataSerializationService bankJsonDataSerializationService;

    @Inject
    private FileSystemStorage fileSystemStorage;

    public String serialize() {
        BankJsonData data = bankJsonDataFacade.createBankJsonDataFromGlobalStorages();

        return bankJsonDataSerializationService.serialize(data);
    }

    public void serializeAndWriteToFile() {
        String data = serialize();

        fileSystemStorage.write("bank.json", data);
    }
}
