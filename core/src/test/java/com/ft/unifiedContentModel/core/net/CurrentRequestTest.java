package com.ft.unifiedContentModel.core.net;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.util.UrlPathHelper;

import com.ft.unifiedContentModel.core.net.CurrentRequest;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CurrentRequestTest {

    private CurrentRequest currentRequestFormat;

    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private UrlPathHelper urlPathHelper;

    private final String requestUrl = "http://localhost/structure/pages/0d19f22d-9946-44a5-9198-9f181b195e99";

    @Before
	public void setup() {
		currentRequestFormat = new CurrentRequest();
        currentRequestFormat.setRequest(httpServletRequest);
        currentRequestFormat.setUrlPathHelper(urlPathHelper);
	}

	@Test
	public void testToString_xml() {
        String s = requestUrl + ".xml";
        when(urlPathHelper.getRequestUri(httpServletRequest)).thenReturn(s);
        String actual = currentRequestFormat.getFormat();
        Assert.assertEquals("xml", actual);
	}

    @Test
	public void testToString_json() {
        String s = requestUrl + ".json";
        when(urlPathHelper.getRequestUri(httpServletRequest)).thenReturn(s);
        String actual = currentRequestFormat.getFormat();
        Assert.assertEquals("json", actual);
	}

    @Test
	public void testToString_default() {
        when(urlPathHelper.getRequestUri(httpServletRequest)).thenReturn(requestUrl);
        String actual = currentRequestFormat.getFormat();
        Assert.assertNull(actual);
	}
}