package org.cloudfoundry.community.servicebroker.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * A binding to a service instance
 * 
 * @author sgreenberg@gopivotal.com
 *
 */
@Entity
public class ServiceInstanceBinding {

	@Id
	private String id;
	@Column
	@NotNull
	private String serviceInstanceId;
	@ElementCollection(fetch=FetchType.EAGER)
	private Map<String,String> credentials = new HashMap<>();
	@Column
	private String syslogDrainUrl;
	@Column
	private String appGuid;
	
	public ServiceInstanceBinding() {
		
	}

	public ServiceInstanceBinding(String id, 
			String serviceInstanceId, 
			Map<String,String> credentials,
			String syslogDrainUrl, String appGuid) {
		this.id = id;
		this.serviceInstanceId = serviceInstanceId;
		setCredentials(credentials);
		this.syslogDrainUrl = syslogDrainUrl;
		this.appGuid = appGuid;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getServiceInstanceId() {
		return serviceInstanceId;
	}
	
	public void setServiceInstanceId(String id) {
		this.serviceInstanceId = id;
	}

	public Map<String, String> getCredentials() {
		return credentials;
	}

	private void setCredentials(Map<String, String> credentials) {
		if (credentials == null) {
			credentials = new HashMap<String,String>();
		} else {
			this.credentials = credentials;
		}
	}

	public String getSyslogDrainUrl() {
		return syslogDrainUrl;
	}
	
	public void setSyslogDrainUrl(String url) {
		this.syslogDrainUrl = url;
	}
	
	public String getAppGuid() {
		return appGuid;
	}
	
	public void setAppGuid(String uid) {
		this.appGuid = uid;
	}
	
}
