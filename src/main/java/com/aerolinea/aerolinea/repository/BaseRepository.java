package com.aerolinea.aerolinea.repository;

import com.aerolinea.aerolinea.model.Base;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BaseRepository extends CrudRepository<Base,Integer> {

    @Query("from Base where city like %:city%")
    Iterable<Base> getBaseByCityLike(@Param("city") String city);
}
