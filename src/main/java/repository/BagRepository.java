package repository;

import entity.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Bag
@Repository
public interface BagRepository extends JpaRepository<Bag, Integer> {
}
