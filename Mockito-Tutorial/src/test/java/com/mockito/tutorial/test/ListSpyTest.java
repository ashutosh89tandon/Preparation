package com.mockito.tutorial.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class ListSpyTest {

	@Test
	public void test() {
		ArrayList listSpy=spy(ArrayList.class);
		listSpy.add("1");
		assertEquals(1, listSpy.size());
		verify(listSpy).add("1");
		verify(listSpy,never()).remove("1");
		//verify(listSpy).remove("1");
		when(listSpy.size()).thenReturn(2);
		assertEquals(2, listSpy.size());
	}
	
	@Test(expected=RuntimeException.class)
	public void test1() {
		List listSpy=spy(List.class);
		when(listSpy.get(anyInt())).thenThrow(new RuntimeException("Exception"));
		listSpy.get(0);
	}

}
