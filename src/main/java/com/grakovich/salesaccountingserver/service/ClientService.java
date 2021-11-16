package com.grakovich.salesaccountingserver.service;

import com.grakovich.salesaccountingserver.model.Client;
import com.grakovich.salesaccountingserver.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public List<Client> getAll() {
        return clientRepo.findAll();
    }

    public Boolean save(Client client) {
        if (clientRepo.existsByEmail(client.getEmail()))
            return false;
        else{
            clientRepo.save(client);
            return true;
        }
    }

    public Boolean update(Client client) {
        if (clientRepo.findById(client.getId()).get().getEmail().equals(client.getEmail())
        || !clientRepo.existsByEmail(client.getEmail())){
            clientRepo.save(client);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        clientRepo.deleteById(id);
    }
}
