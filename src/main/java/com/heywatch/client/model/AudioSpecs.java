package com.heywatch.client.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AudioSpecs
{
	private Integer channels;

	private Boolean synched;

	private Integer bitrate;

	private Integer sampleRate;

	private String codec;

	private Float stream;

	public AudioSpecs()
	{
	}

	public Integer getChannels()
	{
		return channels;
	}

	public void setChannels(Integer channels)
	{
		this.channels = channels;
	}

	public Boolean getSynched()
	{
		return synched;
	}

	public void setSynched(Boolean synched)
	{
		this.synched = synched;
	}

	public Integer getBitrate()
	{
		return bitrate;
	}

	public void setBitrate(Integer bitrate)
	{
		this.bitrate = bitrate;
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

	public String getCodec()
	{
		return codec;
	}

	public void setCodec(String codec)
	{
		this.codec = codec;
	}

	public Float getStream()
	{
		return stream;
	}

	public void setStream(Float stream)
	{
		this.stream = stream;
	}

}
