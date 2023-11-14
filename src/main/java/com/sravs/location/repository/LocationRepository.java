package com.sravs.location.repository;

import com.sravs.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository

public interface LocationRepository extends JpaRepository<Location,Integer> {
    @Query("select type,count(type) from Location group by type")
    public List<Object[]> findTypeAndTypeCount();


}
