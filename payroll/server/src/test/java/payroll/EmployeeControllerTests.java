package payroll;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class EmployeeControllerTests extends AbstractTest {
	
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }

	@Test
	public void getEmployees_Test_1() throws Exception {
		String uri = "/employees";
	    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaTypes.HAL_JSON_VALUE)).andReturn();
	      
	    String content = mvcResult.getResponse().getContentAsString();
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	}
	
// 	@Test
// 	public void getEmployees_Test_2() throws Exception {
		
// 		mvc.perform(get("/employees").accept(MediaTypes.HAL_JSON_VALUE))
// 		.andDo(print())
// 		.andExpect(status().isOk())
// 		.andExpect(jsonPath("$._embedded.employeeList[0].id", is(1)))
// 		.andExpect(jsonPath("$._embedded.employeeList[0].firstName", is("Bilbo")))
// 		.andExpect(jsonPath("$._embedded.employeeList[0].lastName", is("Baggins")))
// 		.andExpect(jsonPath("$._embedded.employeeList[0].role", is("ring bearer")))
// 		//.andExpect(jsonPath("$._embedded.employeeList[0]._links.self.href", is("http://localhost/employees/1")))
// 		.andExpect(jsonPath("$._embedded.employeeList[0]._links.employees.href", is("http://localhost/employees")))
// 		.andExpect(jsonPath("$._embedded.employeeList[1].id", is(2)))
// 		.andExpect(jsonPath("$._embedded.employeeList[1].firstName", is("Fodo")))
// 		.andExpect(jsonPath("$._embedded.employeeList[1].lastName", is("Baggins")))
// 		.andExpect(jsonPath("$._embedded.employeeList[1].role", is("burglar")))
// 		//.andExpect(jsonPath("$._embedded.employeeList[1]._links.self.href", is("http://localhost/employees/2")))
// 		.andExpect(jsonPath("$._embedded.employeeList[1]._links.employees.href", is("http://localhost/employees")))
// 		.andExpect(jsonPath("$._links.self.href", is("http://localhost/employees"))) //
// 		.andReturn();
// 	}
	
// 	@Test
// 	public void getEmployees_Test_3() throws Exception {

// //		given(repository.findAll()).willReturn( //
// //		Arrays.asList( //
// //				new Employee("Frodo1", "Baggins", "ring bearer"), //
// //				new Employee("Bilbo1", "Baggins", "burglar")));
		
// 		mvc.perform(get("/employees").accept(MediaTypes.HAL_JSON_VALUE))
// 		.andDo(print())
// 		.andExpect(status().isOk())
// 		//.andExpect(jsonPath("$._embedded.employeeList[0].id", is(1)))
// 		.andExpect(jsonPath("$._embedded.employeeList[0].firstName", is("Frodo1")))
// 		.andExpect(jsonPath("$._embedded.employeeList[0].lastName", is("Baggins")))
// 		.andExpect(jsonPath("$._embedded.employeeList[0].role", is("ring bearer")))
// 		//.andExpect(jsonPath("$._embedded.employeeList[0]._links.self.href", is("http://localhost/employees/1")))
// 		.andExpect(jsonPath("$._embedded.employeeList[0]._links.employees.href", is("http://localhost/employees")))
// 		//.andExpect(jsonPath("$._embedded.employeeList[1].id", is(2)))
// 		.andExpect(jsonPath("$._embedded.employeeList[1].firstName", is("Bilbo1")))
// 		.andExpect(jsonPath("$._embedded.employeeList[1].lastName", is("Baggins")))
// 		.andExpect(jsonPath("$._embedded.employeeList[1].role", is("burglar")))
// 		//.andExpect(jsonPath("$._embedded.employeeList[1]._links.self.href", is("http://localhost/employees/2")))
// 		.andExpect(jsonPath("$._embedded.employeeList[1]._links.employees.href", is("http://localhost/employees")))
// 		.andExpect(jsonPath("$._links.self.href", is("http://localhost/employees"))) //
// 		.andReturn();
// 	}
}