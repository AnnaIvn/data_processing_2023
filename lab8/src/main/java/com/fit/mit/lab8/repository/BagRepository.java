package com.fit.mit.lab8.repository;

import com.fit.mit.lab8.entity.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "bags", path = "bags")
public interface BagRepository extends JpaRepository<Bag, Long>
{

}
