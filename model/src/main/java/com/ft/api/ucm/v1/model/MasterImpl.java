package com.ft.api.ucm.v1.model;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

import com.google.common.base.Objects;

public class MasterImpl implements Master {

	private String masterEntityId;
	private MasterSource masterSource;
	
	public MasterImpl() {
	}

	public MasterImpl(String masterEntityId, MasterSource masterSource){
		notNull(masterSource);
		hasText(masterEntityId);
		this.masterEntityId = masterEntityId;
		this.masterSource = masterSource;
	}
	
	@Override
	public String getMasterSource() {
		return masterSource.toString();
	}

	public void setMasterEntityId(String masterEntityId) {
		this.masterEntityId = masterEntityId;
	}
	
	@Override
	public String getMasterEntityId() {
		return masterEntityId;
	}

	public void setMasterSource(String masterSource) {
		this.masterSource = MasterSource.fromString(masterSource);
	}

    @Override
	public String toString() {
		return Objects.toStringHelper(this)
						.add("masterSource", masterSource)
						.add("masterEntityId", masterEntityId)
						.toString();
	}

}