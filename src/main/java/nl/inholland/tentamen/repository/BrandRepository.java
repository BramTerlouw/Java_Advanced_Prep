package nl.inholland.tentamen.repository;

import nl.inholland.tentamen.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Brand b SET b.brandId = 5 WHERE b.brandId = 1")
    public void updateId();
}
