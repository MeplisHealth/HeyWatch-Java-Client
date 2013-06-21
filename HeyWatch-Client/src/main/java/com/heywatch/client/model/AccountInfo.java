package com.heywatch.client.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountInfo
{
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String login;
	
	private String env;
	
	private Integer io;
	
	private Integer encodeCredits;
	
	private Boolean automaticEncode;
	
	private Integer defaultFormat;
	
	private String uploadKey;
	
	private Date creationDate;
	
	private Date updatedDate;

	public AccountInfo()
	{
		// TODO Auto-generated constructor stub
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getEnv()
	{
		return env;
	}

	public void setEnv(String env)
	{
		this.env = env;
	}

	public Integer getIo()
	{
		return io;
	}

	public void setIo(Integer io)
	{
		this.io = io;
	}

	@XmlElement(name = "encode_credits")
	public Integer getEncodeCredits()
	{
		return encodeCredits;
	}

	public void setEncodeCredits(Integer encodeCredits)
	{
		this.encodeCredits = encodeCredits;
	}

	@XmlElement(name = "automatic_encode")
	public Boolean getAutomaticEncode()
	{
		return automaticEncode;
	}

	public void setAutomaticEncode(Boolean automaticEncode)
	{
		this.automaticEncode = automaticEncode;
	}

	@XmlElement(name = "default_format")
	public Integer getDefaultFormat()
	{
		return defaultFormat;
	}

	public void setDefaultFormat(Integer defaultFormat)
	{
		this.defaultFormat = defaultFormat;
	}

	@XmlElement(name = "upload_key")
	public String getUploadKey()
	{
		return uploadKey;
	}

	public void setUploadKey(String uploadKey)
	{
		this.uploadKey = uploadKey;
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
