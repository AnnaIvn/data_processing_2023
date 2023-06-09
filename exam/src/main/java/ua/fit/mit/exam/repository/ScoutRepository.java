package ua.fit.mit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import ua.fit.mit.exam.entity.Scout;

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "scout", path = "scout")
public interface ScoutRepository extends JpaRepository<Scout, Long>
{

}
