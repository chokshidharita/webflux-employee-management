package com.management.employee.service;

import com.management.employee.model.Employee;
import com.mongodb.client.result.DeleteResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {

    void create(Employee e);

    Mono<Employee> findById(String id);

    Flux<Employee> findByName(String name);

    Flux<Employee> findAll();

    Mono<Employee> update(Employee e);

    Mono<DeleteResult> delete(String id);
}