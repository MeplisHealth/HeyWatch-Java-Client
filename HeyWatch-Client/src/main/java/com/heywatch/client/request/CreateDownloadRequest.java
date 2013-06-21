package com.heywatch.client.request;

import javax.ws.rs.core.MultivaluedMap;

import com.heywatch.client.ConnectorConstants;

public class CreateDownloadRequest extends Request
{
	private String url;

	private String title;

	private Integer maxLength;

	private String pingUrlAfterTransfer;

	private String pingUrlIfError;

	private Boolean automaticEncode;

	private Integer formatId;

	public CreateDownloadRequest()
	{
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Integer getMaxLength()
	{
		return maxLength;
	}

	public void setMaxLength(Integer maxLength)
	{
		this.maxLength = maxLength;
	}

	public String getPingUrlAfterTransfer()
	{
		return pingUrlAfterTransfer;
	}

	public void setPingUrlAfterTransfer(String pingUrlAfterTransfer)
	{
		this.pingUrlAfterTransfer = pingUrlAfterTransfer;
	}

	public String getPingUrlIfError()
	{
		return pingUrlIfError;
	}

	public void setPingUrlIfError(String pingUrlIfError)
	{
		this.pingUrlIfError = pingUrlIfError;
	}

	public Boolean getAutomaticEncode()
	{
		return automaticEncode;
	}

	public void setAutomaticEncode(Boolean automaticEncode)
	{
		this.automaticEncode = automaticEncode;
	}

	public Integer getFormatId()
	{
		return formatId;
	}

	public void setFormatId(Integer formatId)
	{
		this.formatId = formatId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.heywatch.client.request.Request#isValid()
	 */
	@Override
	protected boolean isValid()
	{
		return (url != null);
	}

	/**
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 */
	public MultivaluedMap<String, String> createValuedMap() throws IllegalArgumentException
	{
		if (!isValid())
			throw new IllegalArgumentException(String.format(MISSING_PARAMETER,
					"URL"));
		String[] keys = { ConnectorConstants.URL_NAME,
				ConnectorConstants.TITLE_NAME, ConnectorConstants.TWO_PASS_NAME,
				ConnectorConstants.PING_URL_AFTER_TRANSFER_NAME,
				ConnectorConstants.PING_URL_IF_ERROR_NAME,
				ConnectorConstants.AUTOMATIC_ENCODE_NAME,
				ConnectorConstants.FORMAT_ID_NAME };
		String[] values = { url, title, parse(maxLength), pingUrlAfterTransfer,
				pingUrlIfError, parse(automaticEncode), parse(formatId) };
		return super.createValuedMap(keys, values);
	}

}
