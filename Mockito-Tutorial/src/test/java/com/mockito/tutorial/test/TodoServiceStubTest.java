package com.mockito.tutorial.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mockito.tutorial.TodoBusinessImpl;
import com.mockito.tutorial.TodoService;

public class TodoServiceStubTest {

	@Test
	public void test() {
		TodoService todoService=new TodoServiceStub();
		TodoBusinessImpl impl=new TodoBusinessImpl(todoService);
		List<String> list=impl.getTodosForSpring("ABC");
		assertTrue(list.contains("Spring"));
		assertEquals(1, list.size());
	}

}
