package com.mockito.tutorial.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class ListTest {

	@Test
	public void test() {
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test(expected=RuntimeException.class)
	public void test1() {
		List listMock=mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Exception"));
		listMock.get(0);
	}

}
