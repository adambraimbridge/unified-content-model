package com.ft.api.ucm.model.v1.aspect;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.api.ucm.model.v1.aspect.Field;
import com.ft.api.ucm.model.v1.aspect.FieldResolutionPolicy;
import com.ft.api.ucm.model.v1.aspect.ImmutableField;

@RunWith(MockitoJUnitRunner.class)
public class ImmutableFieldTest {
	
	private final static String NAME = "name";
	private final static String ANOTHER_NAME = "zzz";
	
	@Mock private FieldResolutionPolicy mockFieldResolutionPolicy;
	
	private Field instance;
	
	@Before
	public void setup() {
		instance = ImmutableField.valueOf(NAME, mockFieldResolutionPolicy);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructObjectWithNullNameRaisesException() {
		ImmutableField.valueOf(null, mockFieldResolutionPolicy);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructObjectWithNullResolutionPolicyRaisesException() {
		ImmutableField.valueOf(NAME, null);
	}
	
	@Test
	public void twoFieldsAreEqualIfTheyAreTheSame() {
		Field another = instance;
		assertThat(instance, equalTo(another));
		assertThat(instance.hashCode(), is(another.hashCode()));
	}
	
	@Test
	public void twoFieldsAreNotEqualIfOneIsNull() {
		Field another = null;
		assertThat(instance, not(equalTo(another)));
	}
	
	@Test
	public void twoDifferentFieldsAreNotEqual() {
		Field another = ImmutableField.valueOf(ANOTHER_NAME, mockFieldResolutionPolicy);
		assertThat(instance, not(equalTo(another)));
	}
	
	@Test
	public void aspectSetsAreComparableByName() {
		Field another = ImmutableField.valueOf(ANOTHER_NAME, mockFieldResolutionPolicy);
		assertThat(instance, lessThan(another));
	}
	
	@Test
	public void objectIsAssignableFrom() {
		Object test = new Object();
		when(mockFieldResolutionPolicy.hasField(instance, test)).thenReturn(Boolean.TRUE);
		assertThat(instance.assignableFrom(test), is(Boolean.TRUE));
	}

	@Test
	public void toStringReturnsName() {
		assertThat(instance, hasToString(equalTo(NAME)));
	}
}
