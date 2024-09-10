package vm.techmaster.springboothazelcast.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vm.techmaster.springboothazelcast.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
