package com.heywatch.client.request;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.core.util.MultivaluedMapImpl;

public abstract class Request
{
	protected static final String MISSING_PARAMETER = "One of the required parameters is missing. Required parameters: %s";

	/**
	 * Create a multiValuedMap with key and values for request.
	 * 
	 * @param keys
	 * @param values
	 * @return
	 */
	protected MultivaluedMap<String, String> createValuedMap(String[] keys,
			String[] values)
	{
		if (keys != null && values != null)
		{
			MultivaluedMap<String, String> map = new MultivaluedMapImpl();
			for (int i = 0; i < keys.length; i++)
			{
				if (values[i] != null)
				{
					map.putSingle(keys[i], values[i]);
				}
			}
			return map;
		}
		return null;
	}

	/**
	 * Method to validate the required parameters.
	 * 
	 * @return
	 */
	protected abstract boolean isValid();

	/**
	 * 
	 * @param _long
	 * @return
	 */
	protected String parse(Long _long)
	{
		return (_long == null ? null : String.valueOf(_long));
	}

	/**
	 * 
	 * @param _integer
	 * @return
	 */
	protected String parse(Integer _integer)
	{
		return (_integer == null ? null : String.valueOf(_integer));
	}

	/**
	 * 
	 * @param _boolean
	 * @return
	 */
	protected String parse(Boolean _boolean)
	{
		return (_boolean == null ? null : String.valueOf(_boolean));
	}

	/**
	 * 
	 * @param _float
	 * @return
	 */
	protected String parse(Float _float)
	{
		return (_float == null ? null : String.valueOf(_float));
	}

	/**
	 * 
	 * @param _double
	 * @return
	 */
	protected String parse(Double _double)
	{
		return (_double == null ? null : String.valueOf(_double));
	}

}
