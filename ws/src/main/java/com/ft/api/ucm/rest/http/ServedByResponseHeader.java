package com.ft.api.ucm.rest.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ft.api.ucm.core.net.Host;

/**
 * <p>A ResponseHeader that configures a custom 'X-Served-By' header to be added
 * to the response, specifying the host name of the application server that handled the request.</p>
 * 
 * @author andrew.winter
 */
public class ServedByResponseHeader implements ResponseHeader {

	static final String SERVED_BY_HEADER_NAME = "X-Served-By";
	
	private Host host;
	
	public ServedByResponseHeader(Host host) {
		this.host = host;
	}
	
	@Override
	public void setOn(HttpServletResponse response, HttpServletRequest request) {
		response.addHeader(SERVED_BY_HEADER_NAME, host.getHostName());
	}
}
