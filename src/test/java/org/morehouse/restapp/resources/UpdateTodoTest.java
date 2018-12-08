package org.morehouse.restapp.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UpdateTodoTest {

	@Test
	public void testChangeAssignee() {
		//setup
				TodosResource resource = new TodosResource();
				Todo existing = new Todo();
				existing.setAssignee("someone");
				Todo update = new Todo();
				update.setAssignee("someone else");
				//execute
				boolean isValid = resource.validateUpdate(existing, update);
				
				//validate
				assertTrue(isValid);
	}
	
	@Test
	public void testSetAsignee() {
		//setup
				TodosResource resource = new TodosResource();
				Todo existing = new Todo();
				existing.setAssignee(null);
				Todo update = new Todo();
				update.setAssignee("new person");
				
				boolean isValid = resource.validateUpdate(existing, update);
				
				//validate
				assertTrue(isValid);
	}
	
	@Test
	public void testRemoveAssignee() {
		//setup
		TodosResource resource = new TodosResource();
		Todo existing = new Todo();
		existing.setAssignee("someone");
		Todo update = new Todo();
		update.setAssignee(null);
		
		boolean isValid = resource.validateUpdate(existing, update);
		
		//validate
		assertFalse(isValid);
	}
	
	@Test
	public void testLeaveAssigneeBlank() {
		//setup
		TodosResource resource = new TodosResource();
		Todo existing = new Todo();
		existing.setAssignee(null);
		Todo update = new Todo();
		update.setAssignee(null);
		
		boolean isValid = resource.validateUpdate(existing, update);
		
		//validate
		assertTrue(isValid);
	}


	//testChangeAssignee +
	//testSetAsignee +
	//testRemoveAssignee +
	//testLeaveAssigneeBlank + started null and leaving null
}
