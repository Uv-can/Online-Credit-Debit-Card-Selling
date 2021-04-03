package dbms.DBMSFinalProject.repository;
import dbms.DBMSFinalProject.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query("SELECT count(u) from Bank u where u.bank_id=(:bank_id)")
    long findCountByMovieId(@Param("bank_id") Long bank_id);

}
