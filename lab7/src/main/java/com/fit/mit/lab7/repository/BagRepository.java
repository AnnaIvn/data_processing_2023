package com.fit.mit.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fit.mit.lab7.entity.Bag;

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "bags", path = "bags")
public interface BagRepository extends JpaRepository<Bag, Long>
{

}
