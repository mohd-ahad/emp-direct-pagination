package io.ahad.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.ahad.Entity.Employee;
import io.ahad.Service.EmployeeDTO;


@Repository
public interface Emp_Direct_Repo  extends JpaRepository<Employee, Long> {
Optional<Employee> findByName(String name);
	//public List<Employee> findByAccount(String account);
//	@Query("from Employee as e where e.id=:id")
//	public Page<Employee> findEmployeeById(@Param("id")int id,Pageable pageable);
//	List<Employee> findAll(String accountName);
	
}
