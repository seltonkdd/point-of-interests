package spring_boot.point_of_interest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_boot.point_of_interest.model.POI;

public interface POIRepository extends JpaRepository<POI, Long> {
    
}
