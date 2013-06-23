package com.heywatch.client.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EncodedVideoInfo
{
	private Integer id;

	private String title;

	private String filename;

	private Long jobId;
	
	private String link;
	
	private Specs specs;

	private Date creationDate;

	private Date updatedDate;

	public EncodedVideoInfo()
	{
		// TODO Auto-generated constructor stub
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	@XmlElement(name = "job_id")
	public Long getJobId()
	{
		return jobId;
	}

	public void setJobId(Long jobId)
	{
		this.jobId = jobId;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public Specs getSpecs()
	{
		return specs;
	}

	public void setSpecs(Specs specs)
	{
		this.specs = specs;
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
