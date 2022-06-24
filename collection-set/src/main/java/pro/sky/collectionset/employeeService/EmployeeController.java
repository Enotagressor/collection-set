package pro.sky.collectionset.employeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collectionset.empl.Employee;
import pro.sky.collectionset.exception.EmployeeAlreadyAddedException;
import pro.sky.collectionset.exception.EmployeeStoragesFullException;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String hello() {
        return employeeService.hello();
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.addEmployee(employee);
            return "Employee added";
        } catch (EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже существует!";
        } catch (EmployeeStoragesFullException e) {
            return "Рабочих мест больше нет, увольте самого бесполезного!";
        }
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.removeEmployee(employee);
        return "Employee removed";
    }

    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.findEmployee(employee);
    }
    @GetMapping("/list")
    public List<Employee> listEmployee() {
        return employeeService.listEmployee();
    }
}
