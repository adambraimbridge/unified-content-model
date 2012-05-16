package com.ft.unifiedContentModel.model.aspect;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import com.ft.unifiedContentModel.model.ArticleEntity;
import com.ft.unifiedContentModel.model.ContentEntity;
import com.ft.unifiedContentModel.model.SlideshowArticleEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TypeBasedAspectSetSelectionPolicyTest {


    @Mock private Set<AspectSet> mockAspectSets;
	@Mock private AspectSet article;
	@Mock private AspectSet slideshow;
	@Mock private AspectSet defaultSet;

    private static final String ARTICLE_CLASS_NAME = "com.ft.unifiedContentModel.model.ArticleEntity";
    private static final String SS_ARTICLE_CLASS_NAME = "com.ft.unifiedContentModel.model.SlideshowArticleEntity";
    private Map aspectSetMap;
	private TypeBasedAspectSetSelectionPolicy instance;

    @Before
    public void setUp() throws Exception {
        aspectSetMap = new HashMap();
        aspectSetMap.put(ARTICLE_CLASS_NAME, article);
        aspectSetMap.put(SS_ARTICLE_CLASS_NAME , slideshow);
        aspectSetMap.put("default", defaultSet);
        instance = new TypeBasedAspectSetSelectionPolicy(defaultSet,aspectSetMap);
    }

    @Test
	public void shouldThrowExceptionIfAspectSetsIsNull() {
		try{
            instance.match(null, SlideshowArticleEntity.class);
            fail("Should throw IllegalArgumentException");
        }
        catch(IllegalArgumentException iae){
            assertThat("aspectSet is null", iae.getMessage(), equalTo("aspectSets cannot be null"));
        }

	}

    @Test
	public void shouldThrowExceptionIfClassIsNull() {
		try{
            instance.match(mockAspectSets , null);
            fail("Should throw IllegalArgumentException");
        }
        catch(IllegalArgumentException iae){
            assertThat("type is null", iae.getMessage(), equalTo("type cannot be null"));
        }
	}

    @Test
    public void shouldFindArticleAspectSet() throws Exception {
        AspectSet aspectSet = instance.match(mockAspectSets, ArticleEntity.class);
        assertThat("aspectSet is not article", aspectSet, sameInstance(article));
    }

    @Test
    public void shouldFindSlideshowAspectSet() throws Exception {
        AspectSet aspectSet = instance.match(mockAspectSets, SlideshowArticleEntity.class);
        assertThat("aspectSet is not Slideshow", aspectSet, sameInstance(slideshow));
    }

    @Test
    public void shouldFindDefaultAspectSet() throws Exception {
        AspectSet aspectSet = instance.match(mockAspectSets, ContentEntity.class);
        assertThat("aspectSet is not default", aspectSet, sameInstance(defaultSet));
    }
}
