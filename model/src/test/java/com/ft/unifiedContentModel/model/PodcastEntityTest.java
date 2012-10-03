package com.ft.unifiedContentModel.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.ft.unifiedContentModel.model.Podcast;
import com.ft.unifiedContentModel.model.PodcastEntity;

public class PodcastEntityTest {
	
	private static final String UUID = "123";
	private static final String ANOTHER_UUID = "123-456-789";
	
	private PodcastEntity instance;
	
	@Before
	public void setUp() {
		instance = new PodcastEntity(UUID);
	}

	@Test(expected=IllegalArgumentException.class)
	public void exceptionThrownWhenIdIsNull() {
		new PodcastEntity(null);
	}

	@Test
	public void podcastIsCreated() {
		assertEquals(UUID, instance.getId());
	}
	
	@Test
	public void twoPodcastsAreEqualIfTheyAreTheSame() {
		Podcast another = instance;
		assertThat(instance, equalTo(another));
		assertThat(instance.hashCode(), is(another.hashCode()));
	}
	
	@Test
	public void twoPodcastsAreNotEqualIfOneIsNull() {
		Podcast another = null;
		assertThat(instance, not(equalTo(another)));
	}
	
	@Test
	public void twoDifferentPodcastsAreNotEqual() {
		Podcast another = new PodcastEntity(ANOTHER_UUID);
		assertThat(instance, not(equalTo(another)));
	}
}