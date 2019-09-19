package com.demo.advsearchfiql;

import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.ContextProvider;
import org.apache.cxf.jaxrs.ext.search.SearchContext;
import org.apache.cxf.jaxrs.ext.search.SearchContextImpl;
import org.apache.cxf.message.Message;

@Provider
public class SearchContextProvider implements ContextProvider<SearchContext> {

	public SearchContext createContext(Message message) {
		return new SearchContextImpl(message);
	}
}
