package com.heywatch.client.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Progress
{
	private Integer currentLength;

	private Integer speed;

	private Integer percent;

	private String timeLeft;

	public Progress()
	{
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name = "current_length")
	public Integer getCurrentLength()
	{
		return currentLength;
	}

	public void setCurrentLength(Integer currentLength)
	{
		this.currentLength = currentLength;
	}

	public Integer getSpeed()
	{
		return speed;
	}

	public void setSpeed(Integer speed)
	{
		this.speed = speed;
	}

	public Integer getPercent()
	{
		return percent;
	}

	public void setPercent(Integer percent)
	{
		this.percent = percent;
	}

	@XmlElement(name = "time_left")
	public String getTimeLeft()
	{
		return timeLeft;
	}

	public void setTimeLeft(String timeLeft)
	{
		this.timeLeft = timeLeft;
	}

}
