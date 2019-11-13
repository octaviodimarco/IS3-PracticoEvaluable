package payroll;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTest {

    @Test
    public void TestBasic() {
    	Employee alex = new Employee("octavio", "test", "test");
    	assertEquals(alex.getName(), "octavio test");
    }
}