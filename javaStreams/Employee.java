import java.math.BigDecimal;

/**
 * Employee
 */
public class Employee {

    private Integer id;
    private String name;
    private BigDecimal salary;
    private Integer departmentId;

    public Integer getId() {
        return id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee(Integer id, String name, BigDecimal salary, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [departmentId=");
        builder.append(departmentId);
        builder.append(", id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", salary=");
        builder.append(salary);
        builder.append("]");
        return builder.toString();
    }

    
}