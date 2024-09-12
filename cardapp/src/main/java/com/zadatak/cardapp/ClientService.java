package com.zadatak.cardapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client findClientByOib(String oib) {
        return clientRepository.findByOib(oib);
    }

    public boolean deleteClientByOib(String oib) {
        Client client = clientRepository.findByOib(oib);
        if (client != null) {
            clientRepository.deleteByOib(oib);
            return true;
        }
        return false;
    }

    public void sendClientDataToApi(Client client) {

        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://example.com/api/client";
        restTemplate.postForEntity(apiUrl, client, String.class);
    }
}
