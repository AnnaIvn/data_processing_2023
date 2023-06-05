package ua.knu.fit.mit.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import ua.knu.fit.mit.lab6.entity.Bag;
import ua.knu.fit.mit.lab6.repository.BagRepository;

import java.util.List;

@RestController
@RequestMapping("/lab6/api/bags")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class BagController
{
    @Autowired
    BagRepository bagRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Bag postBags(@RequestBody Bag bag){
        return bagRepository.save(bag);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/retrieve")
    public List<Bag> getBags(){
        return bagRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Bag putBag(@PathVariable Integer id, @RequestBody Bag newBag){
        Bag updatedBag = bagRepository.findById(id)
        .orElseThrow(()-> new ResourceAccessException("not found Bag entity with id: "+id));
        updatedBag.setName(newBag.getName());
        updatedBag.setLength(newBag.getLength());
        updatedBag.setPhoto(newBag.getPhoto());
        return bagRepository.save(updatedBag);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBag(@PathVariable Integer id){
        bagRepository.deleteById(id);
    }

}
