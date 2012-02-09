package com.ft.unifiedContentModel.model;

import com.ft.unifiedContentModel.core.datetime.DateTimeAdapter;
import com.google.common.base.Objects;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name="lifecycle", namespace=XSDs.ASPECT_NAMESPACE, propOrder={"initialPublishDateTime", "lastPublishDateTime"})
public class LifecycleImpl implements Lifecycle {

	private DateTime initialPublishDateTime;
	private DateTime lastPublishDateTime;
	
	public LifecycleImpl() { 
	}
	
	public LifecycleImpl(DateTime initialPublishDateTime, DateTime lastPublishDateTime) { 
		this.initialPublishDateTime = initialPublishDateTime;
		this.lastPublishDateTime = lastPublishDateTime;
	}	
	
	@Override
	@XmlElement(name="initialPublishDateTime", namespace=XSDs.FIELD_NAMESPACE)
	@XmlJavaTypeAdapter(value=DateTimeAdapter.class, type=DateTime.class)
	public DateTime getInitialPublishDateTime() {
		return initialPublishDateTime;
	}

	@Override
	@XmlElement(name="lastPublishDateTime", namespace=XSDs.FIELD_NAMESPACE)
	@XmlJavaTypeAdapter(value=DateTimeAdapter.class, type=DateTime.class)
	public DateTime getLastPublishDateTime() {
		return lastPublishDateTime;
	}
	
	public void setInitialPublishDateTime(DateTime initialPublishDateTime){
		this.initialPublishDateTime = initialPublishDateTime;
	}
	
	public void setLastPublishDateTime(DateTime lastPublishDateTime) {
		this.lastPublishDateTime = lastPublishDateTime;
	}

    @Override
	public String toString() {
		return Objects.toStringHelper(this).add("lastPublishDateTime", lastPublishDateTime).toString();
	}

}
