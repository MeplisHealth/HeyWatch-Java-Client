package com.heywatch.client.model;

import java.net.URL;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EncodingOptions
{
	private Boolean keepVideoSize;

	private Boolean keepAspectRatio;

	private Boolean keepFps;

	private Boolean keepVideoBitrate;

	private Boolean keepSampleRate;

	private Boolean keepChannels;

	private Boolean keepAudioBitrate;

	private Boolean deinterlace;

	private Integer transpose;

	private Integer duration;

	private String maxVideoBitrate;

	private URL watermarkImageUrl;

	private String x264Options;

	public EncodingOptions()
	{
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name = "keep_video_size")
	public Boolean getKeepVideoSize()
	{
		return keepVideoSize;
	}

	public void setKeepVideoSize(Boolean keepVideoSize)
	{
		this.keepVideoSize = keepVideoSize;
	}

	@XmlElement(name = "keep_aspect_ratio")
	public Boolean getKeepAspectRatio()
	{
		return keepAspectRatio;
	}

	public void setKeepAspectRatio(Boolean keepAspectRatio)
	{
		this.keepAspectRatio = keepAspectRatio;
	}

	@XmlElement(name = "keep_fps")
	public Boolean getKeepFps()
	{
		return keepFps;
	}

	public void setKeepFps(Boolean keepFps)
	{
		this.keepFps = keepFps;
	}

	@XmlElement(name = "keep_video_bitrate")
	public Boolean getKeepVideoBitrate()
	{
		return keepVideoBitrate;
	}

	public void setKeepVideoBitrate(Boolean keepVideoBitrate)
	{
		this.keepVideoBitrate = keepVideoBitrate;
	}

	@XmlElement(name = "keep_sample_rate")
	public Boolean getKeepSampleRate()
	{
		return keepSampleRate;
	}

	public void setKeepSampleRate(Boolean keepSampleRate)
	{
		this.keepSampleRate = keepSampleRate;
	}

	@XmlElement(name = "keep_channels")
	public Boolean getKeepChannels()
	{
		return keepChannels;
	}

	public void setKeepChannels(Boolean keepChannels)
	{
		this.keepChannels = keepChannels;
	}

	@XmlElement(name = "keep_audio_bitrate")
	public Boolean getKeepAudioBitrate()
	{
		return keepAudioBitrate;
	}

	public void setKeepAudioBitrate(Boolean keepAudioBitrate)
	{
		this.keepAudioBitrate = keepAudioBitrate;
	}

	@XmlElement(name = "max_video_bitrate")
	public String getMaxVideoBitrate()
	{
		return maxVideoBitrate;
	}

	public void setMaxVideoBitrate(String maxVideoBitrate)
	{
		this.maxVideoBitrate = maxVideoBitrate;
	}

	@XmlElement(name = "watermark_image_url")
	public URL getWatermarkImageUrl()
	{
		return watermarkImageUrl;
	}

	public void setWatermarkImageUrl(URL watermarkImageUrl)
	{
		this.watermarkImageUrl = watermarkImageUrl;
	}

	@XmlElement(name = "x264_options")
	public String getX264Options()
	{
		return x264Options;
	}

	public void setX264Options(String x264Options)
	{
		this.x264Options = x264Options;
	}

	public Boolean getDeinterlace()
	{
		return deinterlace;
	}

	public void setDeinterlace(Boolean deinterlace)
	{
		this.deinterlace = deinterlace;
	}

	public Integer getTranspose()
	{
		return transpose;
	}

	public void setTranspose(Integer transpose)
	{
		this.transpose = transpose;
	}

	public Integer getDuration()
	{
		return duration;
	}

	public void setDuration(Integer duration)
	{
		this.duration = duration;
	}

}
