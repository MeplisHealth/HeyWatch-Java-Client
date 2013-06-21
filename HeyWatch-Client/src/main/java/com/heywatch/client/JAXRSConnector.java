package com.heywatch.client;

import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.client.apache.ApacheHttpClient;

public class JAXRSConnector<T> {

	private static final String	API_URL	= "https://heywatch.com/";

	private WebResource					wr;

	private Builder							builder;

	/**
	 * Construtor Padrao da Classe. Os metodos devem ser mantidos nessa ordem. Primeiro configuramos o path e em seguida os headers. Headers sao configurados no
	 * Builder e path no WebResource. O metodo HTTP (put, get, delete ou post) deve ser chamado atraves do builder.
	 */
	protected JAXRSConnector(final List<String> pathParams, String username, String password) {
		this.wr = ApacheHttpClient.create().resource(API_URL);
		this.wr.addFilter(new HTTPBasicAuthFilter(username, password));
		setPathParams(pathParams);
		this.builder = wr.accept(MediaType.APPLICATION_JSON);
	}

	protected JAXRSConnector(final List<String> pathParams, final MultivaluedMap<String, String> queryParams, String username, String password) {
		this.wr = ApacheHttpClient.create().resource(API_URL);
		this.wr.addFilter(new HTTPBasicAuthFilter(username, password));
		setPathParams(pathParams);
		setQueryParams(queryParams);
		this.builder = wr.accept(MediaType.APPLICATION_JSON);
	}
	
	protected void enableToDownload(String mediaType) {
		this.builder = wr.accept(mediaType).type(mediaType);
	}

	/**
	 * 	
	 * @param generic
	 * @return
	 */
	protected T get(final GenericType<T> generic) {
		return builder.get(generic);
	}

	/**
	 * 
	 * @param generic
	 * @param obj
	 * @return
	 */
	protected T delete(final GenericType<T> generic, final Object obj) {
		return builder.delete(generic, obj);
	}

	/**
	 * 
	 * @param generic
	 * @param obj
	 * @return
	 */
	protected T put(final GenericType<T> generic, final Object obj) {
		return builder.put(generic, obj);
	}

	/**
	 * 
	 * @param generic
	 * @param obj
	 * @return
	 */
	protected T post(final GenericType<T> generic, final Object obj) {
		return builder.post(generic, obj);
	}

	/**
	 * 
	 * @param generic
	 * @return
	 */
	protected T delete(final GenericType<T> generic) {
		return builder.delete(generic);
	}

	/**
	 * 
	 * @param generic
	 * @return
	 */
	protected T put(final GenericType<T> generic) {
		return builder.put(generic);
	}

	/**
	 * 
	 * @param generic
	 * @return
	 */
	protected T post(final GenericType<T> generic) {
		return builder.post(generic);
	}

	/**
	 * @param pathParams
	 */
	private void setPathParams(final List<String> pathParams) {
		if (pathParams != null && pathParams.size() > 0) {
			for (String string : pathParams) {
				wr = wr.path(string);
			}
		}
	}

	/**
	 * @param queryParams
	 */
	private void setQueryParams(final MultivaluedMap<String, String> queryParams) {
		if ((queryParams != null) && (queryParams.size() > 0)) {
			wr = wr.queryParams(queryParams);
		}
	}

}
