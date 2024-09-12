package com.zadatak.cardapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByOib(String oib);
    void deleteByOib(String oib);
}
