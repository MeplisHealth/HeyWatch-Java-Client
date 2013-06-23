package com.heywatch.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DownloadList
{
	@XmlElement
	private List<DownloadInfo> list;

	public DownloadList()
	{
	}

	public DownloadList(List<DownloadInfo> list)
	{
		this.list = list;
	}

	public List<DownloadInfo> getList()
	{
		if (this.list == null)
		{
			this.list = new ArrayList<DownloadInfo>();
		}
		return list;
	}
	
}
