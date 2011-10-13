package com.ft.unifiedContentModel.model.aspect;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.model.aspect.Assignable;
import com.ft.unifiedContentModel.model.aspect.UnanimousAssignableVoter;
import com.google.common.collect.Sets;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import static org.mockito.Mockito.when;

import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class UnanimousAssignableVoterTest {

	@Mock private Assignable assignable;
	@Mock private Assignable anotherAssignable;

	private UnanimousAssignableVoter instance;
	private Set<Assignable> assignables;
	
	@Before
	public void setUp() throws Exception {
		instance = new UnanimousAssignableVoter();
		assignables = Sets.newHashSet(assignable, anotherAssignable);
	}
	
	@Test
	public void voteFailsIfNotAllAssignablesAgree() {
		when(assignable.assignableFrom(any())).thenReturn(false);
		when(anotherAssignable.assignableFrom(any())).thenReturn(true);
		
		assertFalse(instance.vote(assignables, new Object()));
	}
	
	@Test
	public void votePassesIfAllAssignablesAgree() {
		when(assignable.assignableFrom(any())).thenReturn(true);
		when(anotherAssignable.assignableFrom(any())).thenReturn(true);

		assertTrue(instance.vote(assignables, new Object()));
	}

}
