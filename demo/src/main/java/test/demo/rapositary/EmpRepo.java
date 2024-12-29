package test.demo.rapositary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.demo.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
	
}
