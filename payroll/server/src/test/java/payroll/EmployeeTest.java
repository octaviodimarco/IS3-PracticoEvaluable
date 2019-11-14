package payroll;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTest {

    @Test
    public void TestBasic() {
    	Employee octavio = new Employee("octavio", "di marco", "test");
    	assertEquals(octavio.getName(), "octavio di marco");
    }

    @Test
    public void TestRole(){
        Employee octavio = new Employee("octavio", "di marco", "Full Stack Developer");
        assertEquals(octavio.getRole(), "Full Stack Developer");
    }
}