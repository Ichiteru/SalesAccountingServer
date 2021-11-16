package com.grakovich.salesaccountingserver.controller;

import com.grakovich.salesaccountingserver.model.Client;
import com.grakovich.salesaccountingserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping("/client")
    public Boolean save(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("/client")
    public Boolean update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/client/{id}")
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }
}
