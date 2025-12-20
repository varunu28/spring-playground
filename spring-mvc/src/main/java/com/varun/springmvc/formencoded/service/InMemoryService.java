package com.varun.springmvc.formencoded.service;

import com.varun.springmvc.formencoded.model.Employee;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class InMemoryService {

    private final Map<UUID, Employee> storage;

    public InMemoryService() {
        this.storage = new HashMap<>();
    }

    public UUID saveEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        storage.put(employee.getUuid(), employee);
        return employee.getUuid();
    }

    public void updateLastName(UUID uuid, String lastName) {
        Employee employee = storage.get(uuid);
        if (employee != null) {
            employee.setLastName(lastName);
        }
    }
}

