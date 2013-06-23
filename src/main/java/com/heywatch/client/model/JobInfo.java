package com.heywatch.client.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JobInfo
{
	private Integer id;

	private Integer videoId;

	private Integer formatId;

	private String status;

	private Integer progress;

	private Integer error_code;

	private Integer errorCode;

	private String errorMessage;

	private Integer encodedVideoId;

	private EncodingOptions encodingOptions;

	private String pingUrlAfterEncode;

	private String pingUrlIfError;

	private String ftpDirective;

	private String s3Directive;

	private String cfDirective;

	private String httpUploadDirective;

	private Date creationDate;

	private Date updatedDate;

	public JobInfo()
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

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Integer getProgress()
	{
		return progress;
	}

	public void setProgress(Integer progress)
	{
		this.progress = progress;
	}

	public Integer getError_code()
	{
		return error_code;
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

	@XmlElement(name = "format_id")
	public Integer getFormatId()
	{
		return formatId;
	}

	public void setFormatId(Integer formatId)
	{
		this.formatId = formatId;
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

	@XmlElement(name = "error_msg")
	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	@XmlElement(name = "encoded_video_id")
	public Integer getEncodedVideoId()
	{
		return encodedVideoId;
	}

	public void setEncodedVideoId(Integer encodedVideoId)
	{
		this.encodedVideoId = encodedVideoId;
	}

	@XmlElement(name = "encoding_options")
	public EncodingOptions getEncodingOptions()
	{
		return encodingOptions;
	}

	public void setEncodingOptions(EncodingOptions encodingOptions)
	{
		this.encodingOptions = encodingOptions;
	}

	@XmlElement(name = "ping_url_after_encode")
	public String getPingUrlAfterEncode()
	{
		return pingUrlAfterEncode;
	}

	public void setPingUrlAfterEncode(String pingUrlAfterEncode)
	{
		this.pingUrlAfterEncode = pingUrlAfterEncode;
	}

	@XmlElement(name = "ping_url_if_error")
	public String getPingUrlIfError()
	{
		return pingUrlIfError;
	}

	public void setPingUrlIfError(String pingUrlIfError)
	{
		this.pingUrlIfError = pingUrlIfError;
	}

	@XmlElement(name = "ftp_directive")
	public String getFtpDirective()
	{
		return ftpDirective;
	}

	public void setFtpDirective(String ftpDirective)
	{
		this.ftpDirective = ftpDirective;
	}

	@XmlElement(name = "s3_directive")
	public String getS3Directive()
	{
		return s3Directive;
	}

	public void setS3Directive(String s3Directive)
	{
		this.s3Directive = s3Directive;
	}

	@XmlElement(name = "cf_directive")
	public String getCfDirective()
	{
		return cfDirective;
	}

	public void setCfDirective(String cfDirective)
	{
		this.cfDirective = cfDirective;
	}

	@XmlElement(name = "http_upload_directive")
	public String getHttpUploadDirective()
	{
		return httpUploadDirective;
	}

	public void setHttpUploadDirective(String httpUploadDirective)
	{
		this.httpUploadDirective = httpUploadDirective;
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
