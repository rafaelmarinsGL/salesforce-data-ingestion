package com.gorillalogic.salesforce.repository;

import com.gorillalogic.salesforce.model.Employee;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
