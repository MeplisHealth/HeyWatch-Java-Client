package com.heywatch.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JobList
{
	@XmlElement
	private List<JobInfo> list;

	public JobList()
	{
		// TODO Auto-generated constructor stub
	}

	public JobList(List<JobInfo> list)
	{
		this.list = list;
	}

	public List<JobInfo> getList()
	{
		if (this.list == null)
		{
			this.list = new ArrayList<JobInfo>();
		}
		return list;
	}
}
