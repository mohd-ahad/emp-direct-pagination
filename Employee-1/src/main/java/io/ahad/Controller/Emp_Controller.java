package io.ahad.Controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.ahad.Entity.Employee;
import io.ahad.Service.AppConstants;
import io.ahad.Service.Emp_Service;
import io.ahad.Service.EmployeeDTO;


@RestController
@RequestMapping("/emp")
public class Emp_Controller {

	
	    @Autowired
	    private Emp_Service service;

	    
//	    @GetMapping
//	    public List<Employee> getAll(){
//	        return this.service.getAll();
//	    }
	    
	    @GetMapping("/{name}")
	      public ResponseEntity<EmployeeDTO> getEmployeeByName(@PathVariable("name") String name) {
	   EmployeeDTO response=service.findByName(name);	
	          return ResponseEntity.ok(response);
	    }
	    
//	    @GetMapping("/{keyword}")
//	      public List<Employee> getEmployeeByKeyword(@PathVariable("keyword") String keyword)  {
//	          return this.service.findAll(keyword);	
//	    }
	    @GetMapping()
	    //("/pagination/{offset}/{pageSize}")
	    private List<Employee> getEmployeesWithPagination(
	    		@RequestParam(value = "offset", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int offset,
	            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize) {
	        Page<Employee> employeesWithPagination = service.findEmployeeWithPagination(offset, pageSize);
	        List<Employee> emp=employeesWithPagination.getContent();
	        return  emp;
	    }
}
