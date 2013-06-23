package com.heywatch.client.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DownloadInfo
{
	private String errorMessage;
	
	private Integer videoId;
	
	private Integer errorCode;
	
	private String title;

	private String url;

	private Progress progress;

	private Integer id;

	private Integer length;

	private String status;

	private Date creationDate;

	private Date updatedDate;

	public DownloadInfo()
	{
	}

	@XmlElement(name = "error_msg")
	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	@XmlElement(name = "video_id")
	public Integer getVideoId()
	{
		return videoId;
	}

	public void setVideoId(Integer videoId)
	{
		this.videoId = videoId;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Progress getProgress()
	{
		return progress;
	}

	public void setProgress(Progress progress)
	{
		this.progress = progress;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@XmlElement(name = "error_code")
	public Integer getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(Integer errorCode)
	{
		this.errorCode = errorCode;
	}

	public Integer getLength()
	{
		return length;
	}

	public void setLength(Integer length)
	{
		this.length = length;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@XmlElement(name = "created_at")
	public Date getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}

	@XmlElement(name = "updated_at")
	public Date getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}

}
