package com.aerolinea.aerolinea.repository;

import com.aerolinea.aerolinea.model.Base;
import com.aerolinea.aerolinea.model.Crew;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CrewRepository extends CrudRepository<Crew,Integer> {

    @Query("from Crew where name like %:name%")
    Iterable<Crew> getCrewByNameLike(@Param("name") String name);

    @Query("from Crew where base_code = :idBase_code")
    Iterable<Crew> getCrewByBaseCode(@Param("idBase_code") Integer base_code);
}
