package com.management.employee.service;

import com.management.employee.model.Employee;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    ReactiveMongoTemplate employeeRepository;

    public void create(Employee employee) {
        employeeRepository.save(employee).subscribe();
    }

    public Mono<Employee> findById(String id) {
        return employeeRepository.findById(id, Employee.class);
    }

    public Flux<Employee> findByName(String name) {
        return employeeRepository.find(new Query(Criteria.where("name").is(name)), Employee.class);
    }

    public Flux<Employee> findAll() {
        return employeeRepository.findAll(Employee.class);
    }

    public Mono<Employee> update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Mono<DeleteResult> delete(String id) {
        return employeeRepository.remove(findById(id));
    }

}