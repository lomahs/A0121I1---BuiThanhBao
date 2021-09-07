package repository;

import org.junit.Assert;
import org.junit.Test;
import repository.impl.EmployeeRepo;

public class EmployeeRepoTest {
    EmployeeRepo repo = new EmployeeRepo();

    @Test
    public void testCheckLogin() {
        boolean checkLogin = repo.checkLogin("thanhbao", "12345");

        Assert.assertTrue(checkLogin);
    }
}
