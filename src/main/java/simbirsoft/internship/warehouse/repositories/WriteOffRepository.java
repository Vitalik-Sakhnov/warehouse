package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import simbirsoft.internship.warehouse.entities.WriteOff;

import java.util.Date;
import java.util.List;

@Repository
public interface WriteOffRepository extends JpaRepository<WriteOff, Long> {

    @Query("SELECT w FROM WriteOff w WHERE w.isApproved=true AND w.writeOffDate BETWEEN :firstDate AND :secondDate")
    List<WriteOff> periodOfTime(@Param("firstDate") Date firstDate, @Param("secondDate")Date secondDate);
}
