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
public class CreateJobRequest extends Request
{

	private Integer formatId;

	private Integer videoId;

	/** PING OPTIONS */
	private String pingUrlAfterEncode;

	private String pingUrlIfError;

	/** DELIVERY OPTIONS */
	private String ftpDirective;

	private String s3Directive;

	private String cfDirective;

	private String httpUploadDirective;

	/** ENCODING OPTIONS */
	private Boolean keepVideoSize;

	private Boolean keepAspectRatio;

	private Boolean keepFps;

	private Boolean keepVideoBitrate;

	private Boolean keepSampleRate;

	private Boolean keepChannels;

	private Boolean keepAudioBitrate;

	private Boolean deinterlace;

	private Integer transpose;

	private String maxVideoBitrate;

	private Integer duration;

	private String watermarkImageUrl;

	private String watermarkPosition;

	private String x264Options;

	public CreateJobRequest()
	{
	}

	public Integer getFormatId()
	{
		return formatId;
	}

	public void setFormatId(Integer formatId)
	{
		this.formatId = formatId;
	}

	public Integer getVideoId()
	{
		return videoId;
	}

	public void setVideoId(Integer videoId)
	{
		this.videoId = videoId;
	}

	public String getPingUrlAfterEncode()
	{
		return pingUrlAfterEncode;
	}

	public void setPingUrlAfterEncode(String pingUrlAfterEncode)
	{
		this.pingUrlAfterEncode = pingUrlAfterEncode;
	}

	public String getPingUrlIfError()
	{
		return pingUrlIfError;
	}

	public void setPingUrlIfError(String pingUrlIfError)
	{
		this.pingUrlIfError = pingUrlIfError;
	}

	public String getFtpDirective()
	{
		return ftpDirective;
	}

	public void setFtpDirective(String ftpDirective)
	{
		this.ftpDirective = ftpDirective;
	}

	public String getS3Directive()
	{
		return s3Directive;
	}

	public void setS3Directive(String s3Directive)
	{
		this.s3Directive = s3Directive;
	}

	public String getCfDirective()
	{
		return cfDirective;
	}

	public void setCfDirective(String cfDirective)
	{
		this.cfDirective = cfDirective;
	}

	public String getHttpUploadDirective()
	{
		return httpUploadDirective;
	}

	public void setHttpUploadDirective(String httpUploadDirective)
	{
		this.httpUploadDirective = httpUploadDirective;
	}

	public Boolean getKeepVideoSize()
	{
		return keepVideoSize;
	}

	public void setKeepVideoSize(Boolean keepVideoSize)
	{
		this.keepVideoSize = keepVideoSize;
	}

	public Boolean getKeepAspectRatio()
	{
		return keepAspectRatio;
	}

	public void setKeepAspectRatio(Boolean keepAspectRatio)
	{
		this.keepAspectRatio = keepAspectRatio;
	}

	public Boolean getKeepFps()
	{
		return keepFps;
	}

	public void setKeepFps(Boolean keepFps)
	{
		this.keepFps = keepFps;
	}

	public Boolean getKeepVideoBitrate()
	{
		return keepVideoBitrate;
	}

	public void setKeepVideoBitrate(Boolean keepVideoBitrate)
	{
		this.keepVideoBitrate = keepVideoBitrate;
	}

	public Boolean getKeepSampleRate()
	{
		return keepSampleRate;
	}

	public void setKeepSampleRate(Boolean keepSampleRate)
	{
		this.keepSampleRate = keepSampleRate;
	}

	public Boolean getKeepChannels()
	{
		return keepChannels;
	}

	public void setKeepChannels(Boolean keepChannels)
	{
		this.keepChannels = keepChannels;
	}

	public Boolean getKeepAudioBitrate()
	{
		return keepAudioBitrate;
	}

	public void setKeepAudioBitrate(Boolean keepAudioBitrate)
	{
		this.keepAudioBitrate = keepAudioBitrate;
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

	public String getMaxVideoBitrate()
	{
		return maxVideoBitrate;
	}

	public void setMaxVideoBitrate(String maxVideoBitrate)
	{
		this.maxVideoBitrate = maxVideoBitrate;
	}

	public Integer getDuration()
	{
		return duration;
	}

	public void setDuration(Integer duration)
	{
		this.duration = duration;
	}

	public String getWatermarkImageUrl()
	{
		return watermarkImageUrl;
	}

	public void setWatermarkImageUrl(String watermarkImageUrl)
	{
		this.watermarkImageUrl = watermarkImageUrl;
	}

	public String getWatermarkPosition()
	{
		return watermarkPosition;
	}

	public void setWatermarkPosition(String watermarkPosition)
	{
		this.watermarkPosition = watermarkPosition;
	}

	public String getX264Options()
	{
		return x264Options;
	}

	public void setX264Options(String x264Options)
	{
		this.x264Options = x264Options;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.heywatch.client.request.Request#isValid()
	 */
	@Override
	protected boolean isValid()
	{
		return (formatId != null && videoId != null);
	}

	/**
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 */
	public MultivaluedMap<String, String> createValuedMap()
			throws IllegalArgumentException
	{
		if (!isValid())
			throw new IllegalArgumentException(String.format(MISSING_PARAMETER,
					"formatId, videoId"));
		String[] keys = { ConnectorConstants.FORMAT_ID_NAME,
				ConnectorConstants.VIDEO_ID_NAME,
				ConnectorConstants.PING_URL_AFTER_ENCODE_NAME,
				ConnectorConstants.PING_URL_IF_ERROR_NAME,
				ConnectorConstants.FTP_DIRECTIVE_NAME,
				ConnectorConstants.S3_DIRECTIVE_NAME,
				ConnectorConstants.CF_DIRECTIVE_NAME,
				ConnectorConstants.HTTP_UPLOAD_DIRECTIVE_NAME,
				ConnectorConstants.KEEP_VIDEO_SIZE_NAME,
				ConnectorConstants.KEEP_ASPECT_RATIO_NAME,
				ConnectorConstants.KEEP_FPS_NAME,
				ConnectorConstants.KEEP_VIDEO_BITRATE_NAME,
				ConnectorConstants.KEEP_SAMPLE_RATE_NAME,
				ConnectorConstants.KEEP_CHANNELS_NAME,
				ConnectorConstants.KEEP_AUDIO_BITRATE_NAME,
				ConnectorConstants.DEINTERLACE_NAME,
				ConnectorConstants.TRANSPOSE_NAME,
				ConnectorConstants.MAX_VIDEO_BITRATE_NAME,
				ConnectorConstants.DURATION_NAME,
				ConnectorConstants.WATERMARK_IMAGE_URL_NAME,
				ConnectorConstants.WATERMARK_POSITION_NAME,
				ConnectorConstants.X264_OPTIONS_NAME };
		String[] values = { parse(formatId), parse(videoId),
				pingUrlAfterEncode, pingUrlIfError, ftpDirective, s3Directive,
				cfDirective, httpUploadDirective, parse(keepVideoSize),
				parse(keepAspectRatio), parse(keepFps),
				parse(keepVideoBitrate), parse(keepSampleRate),
				parse(keepChannels), parse(keepAudioBitrate),
				parse(deinterlace), parse(transpose), maxVideoBitrate,
				parse(duration), watermarkImageUrl, watermarkPosition,
				x264Options };
		return super.createValuedMap(keys, values);
	}

}
