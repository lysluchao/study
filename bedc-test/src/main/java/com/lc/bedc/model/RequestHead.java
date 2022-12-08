package com.lc.bedc.model;

/**
 * 公共请求报文头
 */
public class RequestHead {
	/**
	 * 银企直连序号标识
	 */
	private String seqNo;
	/**
	 * 银企直连交易类型标识
	 */
	private String service;
	/**
	 * 银企直连请求时间戳:yyyyMMddhhmmss
	 */
	private String reqDate;
	/**
	 * 银企直连请求渠道
	 */
	private String channel;

	private String group;
	private String taskName;
	private String orgId;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "RequestHead{" +
				"seqNo='" + seqNo + '\'' +
				", service='" + service + '\'' +
				", reqDate='" + reqDate + '\'' +
				", channel='" + channel + '\'' +
				", group='" + group + '\'' +
				", taskName='" + taskName + '\'' +
				", orgId='" + orgId + '\'' +
				'}';
	}
}
