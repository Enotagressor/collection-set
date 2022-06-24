package pro.sky.collectionset.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.collectionset.empl.Employee;
import pro.sky.collectionset.exception.EmployeeAlreadyAddedException;
import pro.sky.collectionset.exception.EmployeeNotFoundException;
import pro.sky.collectionset.exception.EmployeeStoragesFullException;

import java.util.Objects;

@Service
public class EmployeeService {
    private final Employee[] employee;

    public EmployeeService() {
        this.employee = new Employee[10];
    }

    public String hello() {
        return "Добро пожаловать в базу данных сотрудников ООО <<РОГА И КОПЫТА>>";
    }


    public void addEmployee(Employee empl) {
       Integer index = null;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && Objects.equals(empl, employee[i])) {
                throw new EmployeeAlreadyAddedException();
            } else if(employee[i] == null){
                index = i;
                employee[i] = empl;
                break;
            }
        }if(index == null){
            throw new EmployeeStoragesFullException();
        }
    }

    public void removeEmployee(Employee empl) {
        Integer index = null;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && Objects.equals(empl, employee[i])) {
                employee[i] = null;
                index = i;
            }
        }if (index == null){
            throw new EmployeeNotFoundException();
        }
    }

    public String findEmployee(Employee empl) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && Objects.equals(empl, employee[i])) {
                return  employee[i].getFirstName() + " " + employee[i].getLastName();
            }
        }
        throw new EmployeeNotFoundException();
    }
}
