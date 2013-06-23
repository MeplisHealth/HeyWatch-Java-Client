package com.heywatch.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VideoList
{
	@XmlElement
	private List<VideoInfo> list;

	public VideoList()
	{
		// TODO Auto-generated constructor stub
	}

	public VideoList(List<VideoInfo> list)
	{
		this.list = list;
	}

	public List<VideoInfo> getList()
	{
		if (this.list == null)
		{
			this.list = new ArrayList<VideoInfo>();
		}
		return list;
	}
}
