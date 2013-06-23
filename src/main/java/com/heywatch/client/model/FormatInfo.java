package com.heywatch.client.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormatInfo
{
	private Integer id;

	private String name;

	private String category;

	private Boolean owner;

	private String videoContainer;
	
	private String videoCoded;
	
	private Integer videoBitrate;

	private Integer width;

	private Integer height;

	private Float fps;

	private Boolean twoPass;
	
	private String audioCodec;
	
	private Integer audioBitrate;
	
	private Integer sampleRate;
	
	private Integer audioChannels;

	public FormatInfo()
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public Boolean getOwner()
	{
		return owner;
	}

	public void setOwner(Boolean owner)
	{
		this.owner = owner;
	}

	
	@XmlElement(name = "video_container")
	public String getVideoContainer()
	{
		return videoContainer;
	}

	public void setVideoContainer(String videoContainer)
	{
		this.videoContainer = videoContainer;
	}

	@XmlElement(name = "video_codec")
	public String getVideoCoded()
	{
		return videoCoded;
	}

	public void setVideoCoded(String videoCoded)
	{
		this.videoCoded = videoCoded;
	}

	@XmlElement(name = "video_bitrate")
	public Integer getVideoBitrate()
	{
		return videoBitrate;
	}

	public void setVideoBitrate(Integer videoBitrate)
	{
		this.videoBitrate = videoBitrate;
	}

	public Integer getWidth()
	{
		return width;
	}

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	public Integer getHeight()
	{
		return height;
	}

	public void setHeight(Integer height)
	{
		this.height = height;
	}

	public Float getFps()
	{
		return fps;
	}

	public void setFps(Float fps)
	{
		this.fps = fps;
	}

	@XmlElement(name = "two_pass")
	public Boolean getTwoPass()
	{
		return twoPass;
	}

	public void setTwoPass(Boolean twoPass)
	{
		this.twoPass = twoPass;
	}

	@XmlElement(name = "audio_codec")
	public String getAudioCodec()
	{
		return audioCodec;
	}

	public void setAudioCodec(String audioCodec)
	{
		this.audioCodec = audioCodec;
	}

	@XmlElement(name = "audio_bitrate")
	public Integer getAudioBitrate()
	{
		return audioBitrate;
	}

	public void setAudioBitrate(Integer audioBitrate)
	{
		this.audioBitrate = audioBitrate;
	}

	@XmlElement(name = "sample_rate")
	public Integer getSampleRate()
	{
		return sampleRate;
	}

	public void setSampleRate(Integer sampleRate)
	{
		this.sampleRate = sampleRate;
	}

	@XmlElement(name = "audio_channels")
	public Integer getAudioChannels()
	{
		return audioChannels;
	}

	public void setAudioChannels(Integer audioChannels)
	{
		this.audioChannels = audioChannels;
	}
	
	

}
