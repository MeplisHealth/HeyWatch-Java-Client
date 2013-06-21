/**
 * 
 */
package com.heywatch.client.request;

import javax.ws.rs.core.MultivaluedMap;

import com.heywatch.client.ConnectorConstants;

/**
 * @author Davi
 * 
 */
public class CreateFormatRequest extends Request
{
	private String name;

	private String category;

	private String videoContainer;

	private String videoCodec;

	private Integer videoBitrate;

	private Integer width;

	private Integer height;

	private Float fps;

	private Boolean twoPass;

	private String audioCodec;

	private Integer audioBitrate;

	private Integer sampleRate;

	private Integer audioChannels;

	public CreateFormatRequest()
	{
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

	public String getVideoContainer()
	{
		return videoContainer;
	}

	public void setVideoContainer(String videoContainer)
	{
		this.videoContainer = videoContainer;
	}

	public String getVideoCodec()
	{
		return videoCodec;
	}

	public void setVideoCodec(String videoCodec)
	{
		this.videoCodec = videoCodec;
	}

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

	public Boolean getTwoPass()
	{
		return twoPass;
	}

	public void setTwoPass(Boolean twoPass)
	{
		this.twoPass = twoPass;
	}

	public String getAudioCodec()
	{
		return audioCodec;
	}

	public void setAudioCodec(String audioCodec)
	{
		this.audioCodec = audioCodec;
	}

	public Integer getAudioBitrate()
	{
		return audioBitrate;
	}

	public void setAudioBitrate(Integer audioBitrate)
	{
		this.audioBitrate = audioBitrate;
	}

	public Integer getSampleRate()
	{
		return sampleRate;
	}

	public void setSampleRate(Integer sampleRate)
	{
		this.sampleRate = sampleRate;
	}

	public Integer getAudioChannels()
	{
		return audioChannels;
	}

	public void setAudioChannels(Integer audioChannels)
	{
		this.audioChannels = audioChannels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.heywatch.client.request.Request#isValid()
	 */
	@Override
	protected boolean isValid()
	{
		return (name != null && category != null && videoContainer != null
				&& videoCodec != null && videoBitrate != null && width != null
				&& height != null && fps != null && audioCodec != null
				&& audioBitrate != null && sampleRate != null && audioChannels != null);
	}

	/**
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 */
	public MultivaluedMap<String, String> createValuedMap() throws IllegalArgumentException
	{
		if (!isValid())
			throw new IllegalArgumentException(
					String.format(
							MISSING_PARAMETER,
							"name, category, videoContainer, videoCodec, videoBitrate, width, height, fps, audioCodec, audioBitrate, sampleRate, audioChannels"));
		String[] keys = { ConnectorConstants.NAME,
				ConnectorConstants.CATEGORY_NAME,
				ConnectorConstants.VIDEO_CONTAINER_NAME,
				ConnectorConstants.VIDEO_CODEC_NAME,
				ConnectorConstants.VIDEO_BITRATE_NAME,
				ConnectorConstants.WIDTH_NAME, 
				ConnectorConstants.HEIGHT_NAME,
				ConnectorConstants.FPS_NAME,
				ConnectorConstants.AUDIO_CODEC_NAME,
				ConnectorConstants.AUDIO_BITRATE__NAME,
				ConnectorConstants.SAMPLE_RATE_NAME,
				ConnectorConstants.AUDIO_CHANNELS_NAME,
				ConnectorConstants.TWO_PASS_NAME };
		String[] values = { name, category, videoContainer, videoCodec,
				parse(videoBitrate), parse(width), parse(height), parse(fps),
				audioCodec, parse(audioBitrate), parse(sampleRate),
				parse(audioChannels) };
		return super.createValuedMap(keys, values);
	}
}
