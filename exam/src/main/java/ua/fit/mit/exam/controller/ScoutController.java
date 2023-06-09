package ua.fit.mit.exam.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import ua.fit.mit.exam.entity.Scout;
import ua.fit.mit.exam.repository.ScoutRepository;

import java.util.List;

@RestController
@RequestMapping("/api/scout")
@Slf4j
@CrossOrigin(origins = "*")
public class ScoutController
{
    @Autowired
    ScoutRepository scoutRepository;

    @PostMapping("/create")                             // create Scout
    @ResponseStatus(HttpStatus.CREATED)
    public Scout postScout(@RequestBody Scout scout)
    {
        log.info("SCOUT CONTROLLER | POST method started");
        scoutRepository.save(scout);
        log.info("[SCOUT CONTROLLER] After POST method, Scout {} was added", scout.getName());
        return scout;
    }

    @GetMapping("/retrieve")                            // retrieve all Scouts from db
    public List<Scout> getScouts()
    {
        List<Scout> list;
        log.info("SCOUT CONTROLLER | GET method started, list created");
        list = scoutRepository.findAll();
        log.info("[SCOUT CONTROLLER] After GET method, Scout {} was added", list.size());
        return list;
    }

    @PutMapping("/update/{id}")                         // update Scout
    public Scout putScout(@PathVariable (name="id") long id, @RequestBody Scout newScout){
        log.info("SCOUT CONTROLLER | PUT method started");
        Scout updatedScout = scoutRepository.findById(id)
                .orElseThrow(()-> {
                    log.error("[SCOUT CONTROLLER] | PUT method failed: not found Scout with {} id", id);
                    return new ResourceAccessException("not found Scout with id: "+id);
                });

        updatedScout.setName(newScout.getName());
        updatedScout.setGoal(newScout.getGoal());
        updatedScout.setDuration(newScout.getDuration());
        updatedScout.setMembers(newScout.getMembers());
        scoutRepository.save(updatedScout);
        log.info("[SCOUT CONTROLLER] after PUT method: Scout with {} id was changed", id);
        return updatedScout;
    }

    @DeleteMapping("/delete/{id}")                     // delete Scout
    public void deleteScout(@PathVariable(name="id") long id){
        log.info("SCOUT CONTROLLER | DELETE method started");
        Scout deleteScout = scoutRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[SCOUT CONTROLLER] | DELETE method failed: not found Scout with {} id", id);
                    return new ResourceAccessException("Not found Scout with id: "+ id);
                });
        scoutRepository.deleteById(id);
        log.info("[SCOUT CONTROLLER] after DELETE method: {} Scout with {} id was deleted",deleteScout.getName(), id);
    }



}
