package pl.biblioteka.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import pl.biblioteka.model.Rent;
import pl.biblioteka.repository.RentRepository;


@RestController
public class RentEndpoint {
    
    private RentRepository rentRepository;
    
    @Autowired
    public RentEndpoint(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @GetMapping("/api/rents")
    public List<Rent> getAll() {return rentRepository.findAll();
    }

    @GetMapping("/api/rents/{id}")
    public ResponseEntity<Rent> getById(@PathVariable Long id) {
        Rent rent = rentRepository.findOne(id);
        if(rent != null) {
            return ResponseEntity.ok(rent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/rents")
    public ResponseEntity<?> save(@RequestBody Rent rent) {
        if(rent.getId() == null) {
            Rent saved = rentRepository.save(rent);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(saved.getId())
                    .toUri();
            return ResponseEntity.created(location).body(rent);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } 
    }
}