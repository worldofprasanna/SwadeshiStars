package org.swadeshi.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class AbstractEntity {

	private Long pkey;
	private Boolean deleted = false;
	private String creator;
	private Date created;
	private String changer;
	private Date changed; 
	private Long version;

	
	@Id
	@GeneratedValue
	public Long getPkey() {
		return pkey;
	}
	public void setPkey(Long pkey) {
		this.pkey = pkey;
	}

	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getChanger() {
		return changer;
	}

	public void setChanger(String changer) {
		this.changer = changer;
	}

	public Date getChanged() {
		return changed;
	}

	public void setChanged(Date changed) {
		this.changed = changed;
	}
	
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
	@PrePersist
	public void onPerisit(){
		this.setCreated(new Date());
	}
	
	@PreUpdate
	public void onChange(){
		this.setChanged(new Date());
	}
	
	
}
