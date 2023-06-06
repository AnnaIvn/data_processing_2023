package com.fit.mit.lab8.controller;

import com.fit.mit.lab8.entity.Bag;
import com.fit.mit.lab8.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api/bags")
@Slf4j
@CrossOrigin(origins = "*")
public class BagController
{
    @Autowired
    BagRepository bagRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Bag postBags(@RequestBody Bag bag){
        log.info("BAG CONTROLLER | POST method started");
        bagRepository.save(bag);
        log.info("[BAG CONTROLLER] After POST method, bag {} was added", bag.getName());
        return bag;
    }

    @GetMapping("/retrieve")
    public List<Bag> getBags(){
        List<Bag> list;
        log.info("BAG CONTROLLER | GET method started, list created");
        list = bagRepository.findAll();
        log.info("[BAG CONTROLLER] After GET method, bag {} was added", list.size());
        return bagRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Bag putBag(@PathVariable (name="id") long id, @RequestBody Bag newBag){
        log.info("BAG CONTROLLER | PUT method started");
        Bag updatedBag = bagRepository.findById(id)
                .orElseThrow(()-> {
                    log.error("[BAG CONTROLLER] | PUT method failed: not found bag with {} id", id);
                    return new ResourceAccessException("not found Bag entity with id: "+id);
                });

        updatedBag.setName(newBag.getName());
        updatedBag.setLength(newBag.getLength());
        updatedBag.setTemperature(newBag.getTemperature());
        updatedBag.setPhoto(newBag.getPhoto());
        bagRepository.save(updatedBag);
        log.info("[BAG CONTROLLER] after PUT method: bag with {} id was changed", id);
        return updatedBag;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBag(@PathVariable(name="id") long id){
        log.info("BAG CONTROLLER | DELETE method started");
        Bag deleteBag = bagRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[BAG CONTROLLER] | DELETE method failed: not found bag with {} id", id);
                    return new ResourceAccessException("Not found bag with id: "+ id);
                });
        bagRepository.deleteById(id);
        log.info("[BAG CONTROLLER] after DELETE method: {} bag with {} id was deleted",deleteBag.getName(), id);
    }

}
