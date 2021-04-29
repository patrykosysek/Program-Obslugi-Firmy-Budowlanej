package pl.mirbudpol.sklepbudowlany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.entities.Client;
import pl.mirbudpol.sklepbudowlany.repositories.ClientRepository;

@RestController
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class HelloController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ClientRepository clientRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Client n = new Client();
        n.setImie(name);
        n.setEmail(email);
        clientRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Client> getAllUsers() {
        // This returns a JSON or XML with the users
        return clientRepository.findAll();
    }
}
