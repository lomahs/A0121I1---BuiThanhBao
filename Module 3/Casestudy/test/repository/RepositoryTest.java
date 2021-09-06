package repository;

import bean.employee.EducationDegree;
import org.junit.Assert;
import org.junit.Test;
import repository.impl.CustomerRepo;
import repository.impl.EmployeeRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RepositoryTest {

    @Test
    public void testGetEducationDegree() {
        EmployeeRepo repository = new EmployeeRepo();

        EducationDegree educationDegree = repository.getEducationDegreeById(1);

        Assert.assertEquals("Intermediate", educationDegree.getName());
    }

    @Test
    public void testGetEducationDegree1() {
        EmployeeRepo repository = new EmployeeRepo();

        EducationDegree educationDegree = repository.getEducationDegreeById(2);

        Assert.assertEquals("Colleges", educationDegree.getName());
    }

    @Test
    public void testGetEducationDegree2() {
        EmployeeRepo repository = new EmployeeRepo();

        EducationDegree educationDegree = repository.getEducationDegreeById(3);

        Assert.assertEquals("University", educationDegree.getName());
    }

    @Test
    public void testReadEmployee() {
        EmployeeRepo repository = new EmployeeRepo();

        repository.readAllEmployees();
    }

    @Test
    public void testAddEmployee() {
        EmployeeRepo repository = new EmployeeRepo();

        try {
            Assert.assertEquals(9, repository.addEmployee("bao", new SimpleDateFormat("dd-MM-yyyy").parse("05-10-1999"), "123321123", 100, "0121-313-231", "ba@gmail.com", "dn", 1, 1, 2, "thanhbao"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomer() {
        CustomerRepo repo = new CustomerRepo();

        Assert.assertEquals("Male", repo.getCustomerById(101).getGender());
    }
}
