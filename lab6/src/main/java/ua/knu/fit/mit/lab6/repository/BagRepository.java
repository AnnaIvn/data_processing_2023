package ua.knu.fit.mit.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.knu.fit.mit.lab6.entity.Bag;

@Repository
public interface BagRepository extends JpaRepository<Bag, Integer>
{

}
