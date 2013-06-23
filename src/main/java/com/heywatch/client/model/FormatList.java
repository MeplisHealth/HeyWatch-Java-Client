package com.heywatch.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormatList
{
	@XmlElement
	private List<FormatInfo> list;

	public FormatList()
	{
		// TODO Auto-generated constructor stub
	}

	public FormatList(List<FormatInfo> list)
	{
		this.list = list;
	}

	public List<FormatInfo> getList()
	{
		if (this.list == null)
		{
			this.list = new ArrayList<FormatInfo>();
		}
		return list;
	}
}
