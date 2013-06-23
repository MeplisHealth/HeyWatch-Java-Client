package com.heywatch.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EncodedVideoList
{
	@XmlElement
	private List<EncodedVideoInfo> list;

	public EncodedVideoList()
	{
		// TODO Auto-generated constructor stub
	}

	public EncodedVideoList(List<EncodedVideoInfo> list)
	{
		this.list = list;
	}

	public List<EncodedVideoInfo> getList()
	{
		if (this.list == null)
		{
			this.list = new ArrayList<EncodedVideoInfo>();
		}
		return list;
	}
}
