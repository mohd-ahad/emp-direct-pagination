package io.ahad.Service;

import io.ahad.Service.NotFoundException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.ahad.Entity.Employee;

@Service
public interface Emp_Service {
	 public List<Employee> getAll();
	// public EmployeeResponse getAll();
	 public EmployeeDTO findByName(String name);
	 public Page<Employee> findEmployeeWithPagination(int offset,int pageSize);
	// public Employee findByAccountName(String accountName);
	 
	// public Page<Employee> findEmployeeWithPagination(String name,int offset,int pageSize);
	//public List<Employee> findAll(String keyword);
	// public Employee findById(int id , Pageable pageable);
}
