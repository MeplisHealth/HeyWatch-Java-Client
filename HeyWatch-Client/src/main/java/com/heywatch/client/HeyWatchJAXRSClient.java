package com.heywatch.client;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.heywatch.client.model.AccountInfo;
import com.heywatch.client.model.DownloadInfo;
import com.heywatch.client.model.DownloadList;
import com.heywatch.client.model.EncodedVideoInfo;
import com.heywatch.client.model.EncodedVideoList;
import com.heywatch.client.model.FormatInfo;
import com.heywatch.client.model.FormatList;
import com.heywatch.client.model.JobInfo;
import com.heywatch.client.model.JobList;
import com.heywatch.client.model.VideoInfo;
import com.heywatch.client.model.VideoList;
import com.heywatch.client.request.CreateDownloadRequest;
import com.heywatch.client.request.CreateFormatRequest;
import com.heywatch.client.request.CreateJobRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class HeyWatchJAXRSClient
{
	
	private static final Logger logger = LoggerFactory.getLogger(HeyWatchJAXRSClient.class);
	
	private static final String RESPONSE_MESSAGE = "%s, response[%s], code[%d]";

	private String username;

	private String password;
	
	private GenericType<ClientResponse> clientResponse;

	public HeyWatchJAXRSClient(String username, String password)
	{
		this.clientResponse = new GenericType<ClientResponse>(){};
		this.username = username;
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
    public GenericType<ClientResponse> getClientResponse()
	{
		return clientResponse;
	}

	public void setClientResponse(GenericType<ClientResponse> clientResponse)
	{
		this.clientResponse = clientResponse;
	}

	/**
     * Get all the encoded videos
     *
     * @return List<EncodedVideoInfo> The encoded videos
     **/
	public List<EncodedVideoInfo> getEncodedVideos()
	{
        String[] pathParams = { ConnectorConstants.ENCODED_VIDEO_NAME };
		
        JAXRSConnector<JAXBElement<EncodedVideoList>> connector = new JAXRSConnector<JAXBElement<EncodedVideoList>>(
                Arrays.asList(pathParams), username, password);
        
        return connector.get(new GenericType<JAXBElement<EncodedVideoList>>(){}).getValue().getList();
	}
	
    /**
     * Get one encoded video
     *
     * @param encodedVideoId
     * @return EncodedVideoInfo The video
     */
	public EncodedVideoInfo getEncodedVideo(Integer encodedVideoId)
	{
        String[] pathParams = { ConnectorConstants.ENCODED_VIDEO_NAME, String.valueOf(encodedVideoId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.get(clientResponse);
		
		GenericType<JAXBElement<EncodedVideoInfo>> gt = new GenericType<JAXBElement<EncodedVideoInfo>>(){};
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "getEncodedVideo", status, status.getStatusCode()));
		
		return (isResponseOk(response) ? response.getEntity(gt).getValue() : null);
	}
	
    /**
     * Get the thumbnail url for an encoded video
     *
     * @param encodedVideoId
     * @param start Offset in second (position in the video)
     * @param height 
     * @param width 
     * @return string The video url
     */
	public File getEncodedVideoThumbnail(Integer encodedVideoId, Integer start, Integer width, Integer height)
	{
		String[] pathParams = { ConnectorConstants.ENCODED_VIDEO_NAME, String.format(ConnectorConstants.THUMBNAILS_MASK, encodedVideoId) };

    String[] dataParamsKeys = { ConnectorConstants.START_NAME, ConnectorConstants.WIDTH_NAME, ConnectorConstants.HEIGHT_NAME };
    String[] dataValues = { start.toString(), width.toString(), height.toString() };
    MultivaluedMap<String, String> map = createValuedMap(dataParamsKeys, dataValues);
    
    JAXRSConnector<File> connector = new JAXRSConnector<File>(
            Arrays.asList(pathParams), map, username, password);
    connector.enableToDownload("image/jpeg");
    
    return connector.get(new GenericType<File>(){});
	}
	
    /**
     * Get the thumbnail url for an encoded video in 240x180
     *
     * @param encodedVideoId
     * @return string The video url
     */
	public String getEncodedVideoThumbnail(Integer encodedVideoId)
	{
		return String.format(ConnectorConstants.SIMPLE_THUMBNAIL_URL, ConnectorConstants.ENCODED_VIDEO_NAME, String.format(ConnectorConstants.THUMBNAILS_MASK, encodedVideoId) );
	}
	
    /**
     * Update an encoded video
     *
     * @param encodedVideoId
     * @param title
     * @return boolean
     */
	public Boolean updateEncodedVideo(Long encodedVideoId, String title)
	{
		String[] pathParams = { ConnectorConstants.ENCODED_VIDEO_NAME, String.valueOf(encodedVideoId) };
        String[] dataParamsKeys = { ConnectorConstants.TITLE_NAME };
        String[] dataValues = { title };
		
        MultivaluedMap<String, String> map = createValuedMap(dataParamsKeys, dataValues);
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.put(clientResponse, map);
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "updateEncodedVideo", status, status.getStatusCode()));
		
		return parseStatus(status);
	}

	/**
     * Delete an encoded video
     *
     * @param encodedVideoId
     * @return boolean
     */
	public Boolean deleteEncodedVideo(Long encodedVideoId)
	{
		String[] pathParams = { ConnectorConstants.ENCODED_VIDEO_NAME, String.valueOf(encodedVideoId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.delete(clientResponse);
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "deleteEncodedVideo", status, status.getStatusCode()));
		
		return parseStatus(status);
	}
	
    /**
     * Get all the videos
     *
     * @return List<VideoInfo> The videos
     **/
	public List<VideoInfo> getVideos()
	{
		String[] pathParams = { ConnectorConstants.VIDEO_NAME };
		
        JAXRSConnector<JAXBElement<VideoList>> connector = new JAXRSConnector<JAXBElement<VideoList>>(
                Arrays.asList(pathParams), username, password);
		
		return connector.get(new GenericType<JAXBElement<VideoList>>(){}).getValue().getList();
	}
	
    /**
     * Get one video
     *
     * @param videoId
     * @return VideoInfo The video
     */
	public VideoInfo getVideo(Long videoId)
	{
		String[] pathParams = { ConnectorConstants.VIDEO_NAME, String.valueOf(videoId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.get(clientResponse);
		
		GenericType<JAXBElement<VideoInfo>> gt = new GenericType<JAXBElement<VideoInfo>>(){};
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "getVideo", status, status.getStatusCode()));
		
		return (isResponseOk(response) ? response.getEntity(gt).getValue() : null);
	}
	
	/**
	 * Update a video
	 * 
	 * @param videoId
	 * @param title
	 * @return boolean
	 */
	public Boolean updateVideo(Long videoId, String title)
	{
		String[] pathParams = { ConnectorConstants.VIDEO_NAME, String.valueOf(videoId) };
        String[] dataParamsKeys = { ConnectorConstants.TITLE_NAME };
        String[] dataValues = { title };
        
        MultivaluedMap<String, String> map = createValuedMap(dataParamsKeys, dataValues);
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.put(clientResponse, map);
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "updateVideo", status, status.getStatusCode()));
		
		return parseStatus(status);
	}
	
    /**
     * Delete a video
     *
     * @param videoId
     * @return boolean
     */
	public Boolean deleteVideo(Long videoId)
	{
		String[] pathParams = { ConnectorConstants.VIDEO_NAME, String.valueOf(videoId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.delete(clientResponse);
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "deleteVideo", status, status.getStatusCode()));
		
		return parseStatus(status);
	}
	
    /**
     * Get the list of all the formats
     *
     * @return videos
     **/
	public List<FormatInfo> getFormats()
	{
		String[] pathParams = { ConnectorConstants.FORMAT_NAME };
		
        JAXRSConnector<JAXBElement<FormatList>> connector = new JAXRSConnector<JAXBElement<FormatList>>(
                Arrays.asList(pathParams), username, password);
		
		return connector.get(new GenericType<JAXBElement<FormatList>>(){}).getValue().getList();
	}
	
    /**
     * Retrieve information about the format ID
     *
     * @param formatId
     * @return FormatInfo The format
     */
	public FormatInfo getFormat(Long formatId)
	{
		String[] pathParams = { ConnectorConstants.FORMAT_NAME, String.valueOf(formatId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.get(clientResponse);
		
		GenericType<JAXBElement<FormatInfo>> gt = new GenericType<JAXBElement<FormatInfo>>(){};
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "getFormat", status, status.getStatusCode()));
		
		return (isResponseOk(response) ? response.getEntity(gt).getValue() : null);
	}
	
    /**
     * Create a format
     *
     * @param request
     * @return boolean
     */
	public Boolean createFormat(CreateFormatRequest request)
	{
		String[] pathParams = { ConnectorConstants.FORMAT_NAME };
		
		MultivaluedMap<String, String> map = request.createValuedMap();
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.post(clientResponse, map);
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "createFormat", status, status.getStatusCode()));
		
		return parseStatus(status);
	}

    /**
     * Destroy a format
     *
     * @param formatId
     * @return Boolean
     */
	public Boolean deleteFormat(Long formatId)
	{
		String[] pathParams = { ConnectorConstants.FORMAT_NAME, String.valueOf(formatId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.delete(clientResponse);
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "deleteFormat", status, status.getStatusCode()));
		
		return parseStatus(status);
	}
	
    /**
     * Get the list of all the jobs
     *
     * @return jobs
     **/
	public List<JobInfo> getJobs()
	{
		String[] pathParams = { ConnectorConstants.JOB_NAME };
		
        JAXRSConnector<JAXBElement<JobList>> connector = new JAXRSConnector<JAXBElement<JobList>>(
                Arrays.asList(pathParams), username, password);
		
		return connector.get(new GenericType<JAXBElement<JobList>>(){}).getValue().getList();
	}
	
    /**
     * Get one job
     *
     * @param jobId
     * @return JobInfo The job
     */
	public JobInfo getJob(Long jobId)
	{
		String[] pathParams = { ConnectorConstants.JOB_NAME, String.valueOf(jobId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.get(clientResponse);
		
		GenericType<JAXBElement<JobInfo>> gt = new GenericType<JAXBElement<JobInfo>>(){};
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "getJob", status, status.getStatusCode()));
		
		return (isResponseOk(response) ? response.getEntity(gt).getValue() : null);
	}
	
    /**
     * Create a job
     *
     * @param array optionals
     * @return JobInfo
     */
	public JobInfo createJob(CreateJobRequest request)
	{
		String[] pathParams = { ConnectorConstants.JOB_NAME };
		
		MultivaluedMap<String, String> map = request.createValuedMap();
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.post(clientResponse, map);
		
		GenericType<JAXBElement<JobInfo>> gt = new GenericType<JAXBElement<JobInfo>>(){};
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "createJob", status, status.getStatusCode()));
		
		return (isResponseOk(response) ? response.getEntity(gt).getValue() : null);
	}
	
    /**
     * Cancel a job
     *
     * @param jobId
     * @return Boolean
     */
	public Boolean cancelJob(Long jobId)
	{
		String[] pathParams = { ConnectorConstants.JOB_NAME, String.valueOf(jobId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.delete(clientResponse);
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "cancelJob", status, status.getStatusCode()));
		
		return parseStatus(status);
	}
	
    /**
     * Upload a file
     *
     * @param request
     * @return DownloadInfo
     */
	public DownloadInfo upload(CreateDownloadRequest request)
	{
		return createDownload(request);
	}
	
    /**
     * Get the list of all the downloads
     *
     * @return videos
     **/
	public List<DownloadInfo> getDownloads()
	{
		String[] pathParams = { ConnectorConstants.DOWNLOAD_NAME };
		
		JAXRSConnector<JAXBElement<DownloadList>> connector = createDownloadListConnector(pathParams);
		
		return connector.get(new GenericType<JAXBElement<DownloadList>>(){}).getValue().getList();
	}

    /**
     * Get one download
     *
     * @param downloadId
     * @return DownloadInfo The download
     */
	public DownloadInfo getDownload(Long downloadId)
	{
		String[] pathParams = { ConnectorConstants.DOWNLOAD_NAME, String.valueOf(downloadId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.get(clientResponse);
		
		GenericType<JAXBElement<DownloadInfo>> gt = new GenericType<JAXBElement<DownloadInfo>>(){};
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "getDownload", status, status.getStatusCode()));
		
		return (isResponseOk(response) ? response.getEntity(gt).getValue() : null);
	}
	
    /**
     * Create a download
     *
     * @param request
     * @return DownloadInfo
     */
	public DownloadInfo createDownload(CreateDownloadRequest request)
	{
		String[] pathParams = { ConnectorConstants.DOWNLOAD_NAME };
		
		MultivaluedMap<String, String> map = request.createValuedMap();
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.post(clientResponse, map);
		
		GenericType<JAXBElement<DownloadInfo>> gt = new GenericType<JAXBElement<DownloadInfo>>(){};
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "createDownload", status, status.getStatusCode()));
		
		return (isResponseOk(response) ? response.getEntity(gt).getValue() : null);
	}
	
	
    /**
     * Delete a download
     *
     * @param downloadId
     * @return Boolean
     */
	public Boolean deleteDownload(Long downloadId)
	{
		String[] pathParams = { ConnectorConstants.DOWNLOAD_NAME, String.valueOf(downloadId) };
		
		JAXRSConnector<ClientResponse> connector = createClientResponseConnector(pathParams);
		
		ClientResponse response = connector.delete(clientResponse);
		
		Status status = response.getClientResponseStatus();
		
		logger.info(String.format(RESPONSE_MESSAGE, "deleteDownload", status, status.getStatusCode()));
		
		return parseStatus(status);
	}

    /**
     * Get all info about your account
     *
     * @return AccountInfo Your account information
     */
	public AccountInfo account()
	{
		String[] pathParams = { ConnectorConstants.ACCOUNT_NAME };
		
        JAXRSConnector<JAXBElement<AccountInfo>> connector = createAccountInfoConnector(pathParams);
        
		return connector.get(new GenericType<JAXBElement<AccountInfo>>(){}).getValue();
	}
	
	/**
	 * @param pathParams
	 * @return
	 */
	private JAXRSConnector<ClientResponse> createClientResponseConnector(
			String[] pathParams)
	{
		return new JAXRSConnector<ClientResponse>(Arrays.asList(pathParams), username, password);
	}
	
	/**
	 * 
	 * @param pathParams
	 * @return
	 */
	private JAXRSConnector<JAXBElement<DownloadList>> createDownloadListConnector(
			String[] pathParams)
	{
		return new JAXRSConnector<JAXBElement<DownloadList>>(
                Arrays.asList(pathParams), username, password);
	}
	
	/**
	 * 
	 * @param pathParams
	 * @return
	 */
	private JAXRSConnector<JAXBElement<AccountInfo>> createAccountInfoConnector(
			String[] pathParams)
	{
		return new JAXRSConnector<JAXBElement<AccountInfo>>(
                Arrays.asList(pathParams), username, password);
	}
	
	/**
	 * 
	 * @param response
	 * @return
	 */
	public Boolean isResponseOk(ClientResponse response)
	{
		return Status.OK.equals(response.getClientResponseStatus());
	}
	
	/**
	 * 
	 * @param status
	 * @return
	 */
	private Boolean parseStatus(Status status)
	{
		return Status.OK.equals(status) || Status.CREATED.equals(status) || Status.ACCEPTED.equals(status) || Status.NO_CONTENT.equals(status);
	}
	
	/**
	 * 
	 * @param keys
	 * @param values
	 * @return
	 */
	private MultivaluedMap<String, String> createValuedMap(final String[] keys, final String[] values)
	{
		if (keys != null && values != null)
		{
			MultivaluedMap<String, String> map = new MultivaluedMapImpl();
			for (int i = 0; i < keys.length; i++)
			{
				map.putSingle(keys[i], values[i]);
			}
			return map;
		}
		return null;
	}
	
}
