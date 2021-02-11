import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Java Functional Programming Samples
 */
public class Sample {

    public static boolean checkStandard(Department department) {
        return (2 == department.getName().length());
    }

    public static BigDecimal applySalaryIncrement(BigDecimal salary, double increment) {
        return BigDecimal.valueOf(salary.doubleValue() + increment);
    }

    public static void main(String[] args) {

        List<Department> departments = List.of(new Department(1, "HR", "Recruiting"),
                new Department(2, "IT", "Technolgy"),
                new Department(3, "Financial", "Investments and finance controls"));

        List<Employee> employees = List.of(new Employee(1, "Galo", BigDecimal.valueOf(1029.40), 1),
                new Employee(1, "Galo", new BigDecimal(1600), 1),
                new Employee(3, "David", BigDecimal.valueOf(2029.40), 3),
                new Employee(4, "Jessy", new BigDecimal(900), 2), new Employee(5, "Kamala", new BigDecimal(5000), 3),
                new Employee(1, "Galo", BigDecimal.valueOf(244.40), 3),
                new Employee(6, "Tisha", new BigDecimal(600), 1));

        // How many departments
        Long total = departments.stream().count();
        System.out.println("Total Departments " + total);

        // Validate Standard Name - TWO Letters
        System.out.println("------------Bad Standard------------");
        departments.stream().filter(d -> !checkStandard(d)).forEach(System.out::println);

        // Select top 2 lowest
        System.out.println("------------Lowest salary employees------------");
        List<Employee> lowestSalaryEmployees = employees.stream()
                .sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary())).limit(2).collect(Collectors.toList());

        lowestSalaryEmployees.stream().forEach(System.out::println);

        // Select top 2 highest
        System.out.println("------------Highest salary employees------------");
        List<Employee> highestSalayEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).collect(Collectors.toList());
        highestSalayEmployees.stream().forEach(System.out::println);

        System.out.println("------------Salary increment------------");
        final double SALARY_INCREMENT = 150.20;
        List<Employee> newSalaryEmployees = lowestSalaryEmployees
                .stream().map(e -> new Employee(e.getId(), e.getName(),
                        applySalaryIncrement(e.getSalary(), SALARY_INCREMENT), e.getDepartmentId()))
                .collect(Collectors.toList());
        newSalaryEmployees.stream().forEach(System.out::println);

        System.out.println("------------Grouping by department id------------");
        Map<Integer, List<Employee>> employeeGroupByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));

        employeeGroupByDepartment.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);

        Map<String, List<Employee>> employeeGroupByName = employees.stream()
        .collect(Collectors.groupingBy(Employee::getName));

        employeeGroupByName.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);

        /*
                map Vs flatMap
                1) map example, crating a stream based on a list.
                2) Nested list in functional fashion
                3) Using flatMap to collect al nested list in a single level list
        */

        List<String> myList = Stream.of("a", "b").map(String::toUpperCase).collect(Collectors.toList());
        myList.stream().forEach(System.out::println);

        List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
        list.stream().collect(Collectors.toList()).forEach(System.out::println);;

        System.out.println(list.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        String gfg1 = String.join("\t\t", "Four", "Five", "Six", "Seven"); 
        System.out.println(gfg1);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers1 = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        String str =  numbers.stream().map(i->i.toString()).collect(Collectors.joining("\t"));
        System.out.println(str);


    }

}