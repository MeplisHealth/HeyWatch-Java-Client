package com.heywatch.client.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VideoSpecs
{
	private Float stream;

	private Float aspect;

	private Integer rotation;

	private String pixelFormat;

	private Float fps;

	private Integer bitrate;

	private Integer length;

	private Integer width;

	private Float height;

	private String container;

	private String codec;

	public VideoSpecs()
	{
		// TODO Auto-generated constructor stub
	}

	public Float getStream()
	{
		return stream;
	}

	public void setStream(Float stream)
	{
		this.stream = stream;
	}

	public Float getAspect()
	{
		return aspect;
	}

	public void setAspect(Float aspect)
	{
		this.aspect = aspect;
	}

	public Integer getRotation()
	{
		return rotation;
	}

	public void setRotation(Integer rotation)
	{
		this.rotation = rotation;
	}

	@XmlElement(name = "pix_format")
	public String getPixelFormat()
	{
		return pixelFormat;
	}

	public void setPixelFormat(String pixelFormat)
	{
		this.pixelFormat = pixelFormat;
	}

	public Float getFps()
	{
		return fps;
	}

	public void setFps(Float fps)
	{
		this.fps = fps;
	}

	public Integer getBitrate()
	{
		return bitrate;
	}

	public void setBitrate(Integer bitrate)
	{
		this.bitrate = bitrate;
	}

	public Integer getLength()
	{
		return length;
	}

	public void setLength(Integer length)
	{
		this.length = length;
	}

	public Integer getWidth()
	{
		return width;
	}

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	public Float getHeight()
	{
		return height;
	}

	public void setHeight(Float height)
	{
		this.height = height;
	}

	public String getContainer()
	{
		return container;
	}

	public void setContainer(String container)
	{
		this.container = container;
	}

	public String getCodec()
	{
		return codec;
	}

	public void setCodec(String codec)
	{
		this.codec = codec;
	}

}
