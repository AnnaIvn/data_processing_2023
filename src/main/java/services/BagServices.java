package services;

import entity.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BagRepository;

import java.util.List;

// configuration of Bag. So we could get something back
@Service
public class BagServices
{
    @Autowired
    private BagRepository repo;     // configuring(making) bag

    public List<Bag> listAll(){      // return all
        return repo.findAll();
    }

    public void save(Bag bag){      // save bag
        repo.save(bag);
    }

    public Bag get(int id){        // find bag by id
        return repo.findById(id).get();
    }

    public void delete(int id){   // delete bag by id
        repo.deleteById(id);
    }
}
