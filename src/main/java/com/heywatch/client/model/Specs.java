package com.heywatch.client.model;

import java.net.URL;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Specs
{
	private String mimeType;

	private URL thumb;

	private Integer size;

	private VideoSpecs video;

	private AudioSpecs audio;

	public Specs()
	{
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name = "mime_type")
	public String getMimeType()
	{
		return mimeType;
	}

	public void setMimeType(String mimeType)
	{
		this.mimeType = mimeType;
	}

	public URL getThumb()
	{
		return thumb;
	}

	public void setThumb(URL thumb)
	{
		this.thumb = thumb;
	}

	public Integer getSize()
	{
		return size;
	}

	public void setSize(Integer size)
	{
		this.size = size;
	}

	public VideoSpecs getVideo()
	{
		return video;
	}

	public void setVideo(VideoSpecs video)
	{
		this.video = video;
	}

	public AudioSpecs getAudio()
	{
		return audio;
	}

	public void setAudio(AudioSpecs audio)
	{
		this.audio = audio;
	}

}
