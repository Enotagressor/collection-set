package pro.sky.collectionset.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.collectionset.empl.Employee;
import pro.sky.collectionset.exception.EmployeeAlreadyAddedException;
import pro.sky.collectionset.exception.EmployeeNotFoundException;
import pro.sky.collectionset.exception.EmployeeStoragesFullException;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final List<Employee> employee;
    private static final Integer integer = 10;

    public EmployeeService() {
        this.employee = new ArrayList<>(List.of());
    }

    public String hello() {
        return "Добро пожаловать в базу данных сотрудников ООО <<РОГА И КОПЫТА>>";
    }


    public void addEmployee(Employee empl) {
        Integer index = null;
        if (employee.contains(empl)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            index = employee.size();
        }
        if (index >= integer) {
            throw new EmployeeStoragesFullException();
        } else employee.add(empl);
    }

    public void removeEmployee(Employee empl) {
        if (!employee.contains(empl)) {
            throw new EmployeeNotFoundException();
        } else employee.remove(empl);
    }

    public String findEmployee(Employee empl) {
        if (employee.contains(empl)) {
            return empl.getLastName() + " " + empl.getFirstName();
        } else throw new EmployeeNotFoundException();
    }
}
