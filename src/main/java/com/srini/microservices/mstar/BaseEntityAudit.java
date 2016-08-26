package com.srini.microservices.mstar;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * Base Entity Audit
 *
 * @author cem ikta
 */
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Size(max = 20)
    @Column(name = "created_by", length = 20)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Size(max = 20)
    @Column(name = "updated_by", length = 20)
    private String updatedBy;
    
    

    public BaseEntityAudit() {
		super();
	}
    
    

	public BaseEntityAudit(Date createdAt, String createdBy, Date updatedAt, String updatedBy) {
		super();
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}



	public Date getCreatedAt() {
            return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
    }

    public String getCreatedBy() {
            return createdBy;
    }

    public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
            return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
            return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
    }

    /**
     * Sets createdAt before insert
     */
    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();
    }

    /**
     * Sets updatedAt before update
     */
    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }

	@Override
	public String toString() {
		return super.toString() + "BaseEntityAudit [createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt=" + updatedAt
				+ ", updatedBy=" + updatedBy + "]";
	}
    
    

}
