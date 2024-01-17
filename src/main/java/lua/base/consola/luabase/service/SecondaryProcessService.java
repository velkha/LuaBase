package lua.base.consola.luabase.service;

import lua.base.consola.luabase.util.FileWrite;
import lua.base.consola.luabase.util.InputReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
public class SecondaryProcessService {
    public void init() {
        System.out.println("Testing Secondary process:");
        InputReader input = new InputReader();

        System.out.print("Type: ");
        String type = input.readLine();
        System.out.print("value: ");
        String value = input.readLine();
        String relativePath = type+ File.separator+value;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        CompletableFuture<ResponseEntity<String>> futuro = asyncService.asyncGetCall("https://www.dnd5eapi.co/api/spells/acid-arrow", null, headers);
        futuro.thenAccept(response -> {
            // Print the response body
            System.out.println("Response Body: " + response.getBody());

            // Optionally, print headers and status code
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Headers: " + response.getHeaders());
            try {
                FileWrite.writeStringToFile(relativePath+".json", response.getBody(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private final AsyncService asyncService;

    @Autowired
    public SecondaryProcessService (AsyncService asyncService){
        this.asyncService=asyncService;
    }

}
