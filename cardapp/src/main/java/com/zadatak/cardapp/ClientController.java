package com.zadatak.cardapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client addedClient = clientService.addClient(client);
        return ResponseEntity.ok(addedClient);
    }

    @GetMapping("/search/{oib}")
    public ResponseEntity<Client> searchClient(@PathVariable String oib) {
        Client client = clientService.findClientByOib(oib);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{oib}")
    public ResponseEntity<String> deleteClient(@PathVariable String oib) {
        boolean deleted = clientService.deleteClientByOib(oib);
        if (deleted) {
            return ResponseEntity.ok("Client deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendClientToApi(@RequestBody Client client) {
        clientService.sendClientDataToApi(client);
        return ResponseEntity.ok("Client data sent to API successfully");
    }
}