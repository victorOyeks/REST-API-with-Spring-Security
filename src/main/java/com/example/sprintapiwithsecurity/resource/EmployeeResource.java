package com.example.sprintapiwithsecurity.resource;

import com.example.sprintapiwithsecurity.model.Employee;
import com.example.sprintapiwithsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeResource {
    @Qualifier(value = "mySQLEmployeeService")
    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "mySQLEmployeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getALlEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee) {
        //employee.setId(employeeService.getALlEmployees().size() + 1L);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

//    @PutMapping("{id}")
//    public ResponseEntity<Boolean> editEmployee () {
//        return null;
//    }
//
    protected static URI getLocation(Long id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
