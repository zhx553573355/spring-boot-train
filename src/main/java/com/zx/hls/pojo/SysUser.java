package com.zx.hls.pojo;

import oracle.sql.DATE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="SYS_USER")
public class SysUser implements Serializable {

    private static final long serialVersionUID = -4739285993714407388L;

    @Column(name="user_id")
    @Id
    Integer userId;

    @Column(name="user_name")
    String userName;
    @Column(name="encrypted_user_password")
    String encryptedUserPassword;
    @Column(name="start_date")
    Date startDate;
    @Column(name="end_date")
    Date endDate;
    @Column(name="description")
    String description;
    @Column(name="frozen_flag")
    String frozenFlag;

    @Column(name="encrypted_foundation_password")
    String encryptedFoundationPassword;
    @Column(name="last_logon_date")
    Date lastLogonDate            ;
    @Column(name="password_lifespan_access")
    Integer  passwordLifespanAccess      ;
    @Column(name="employee_id")
    Integer  employeeId              ;
    @Column(name="customer_id")
    Integer  customerId               ;
    @Column(name="vender_id")
    Integer  venderId                   ;
    @Column(name="frozen_date")
    Date frozenDate               ;
    @Column(name="password_start_date")
    Date passwordStartDate        ;
    @Column(name="menu_type")
    String menuType                  ;
    @Column(name="last_update_date")
    Date lastUpdateDate             ;
    @Column(name="last_updated_by")
    Integer lastUpdatedBy             ;
    @Column(name="creation_date")
    Date creationDate            ;
    @Column(name="created_by")
    Integer createdBy                ;
    @Column(name="bp_category")
    String bpCategory                 ;
    @Column(name="bp_id")
    Integer bpId                        ;
    @Column(name="tm_flag")
    String tmFlag;

    public SysUser() {
    }

    public SysUser(Integer userId, String userName, String encryptedUserPassword, Date startDate, Date endDate, String description, String frozenFlag, String encryptedFoundationPassword, Date lastLogonDate, Integer passwordLifespanAccess, Integer employeeId, Integer customerId, Integer venderId, String frozenFlag1, Date frozenDate, Date passwordStartDate, String menuType, Date lastUpdateDate, Integer lastUpdatedBy, Date creationDate, Integer createdBy, String bpCategory, Integer bpId, String tmFlag) {
        this.userId = userId;
        this.userName = userName;
        this.encryptedUserPassword = encryptedUserPassword;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.frozenFlag = frozenFlag;
        this.encryptedFoundationPassword = encryptedFoundationPassword;
        this.lastLogonDate = lastLogonDate;
        this.passwordLifespanAccess = passwordLifespanAccess;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.venderId = venderId;
        this.frozenFlag = frozenFlag1;
        this.frozenDate = frozenDate;
        this.passwordStartDate = passwordStartDate;
        this.menuType = menuType;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.bpCategory = bpCategory;
        this.bpId = bpId;
        this.tmFlag = tmFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedUserPassword() {
        return encryptedUserPassword;
    }

    public void setEncryptedUserPassword(String encryptedUserPassword) {
        this.encryptedUserPassword = encryptedUserPassword;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrozenFlag() {
        return frozenFlag;
    }

    public void setFrozenFlag(String frozenFlag) {
        this.frozenFlag = frozenFlag;
    }

    public Date getFrozenDate() {
        return frozenDate;
    }

    public void setFrozenDate(Date frozenDate) {
        this.frozenDate = frozenDate;
    }

    public Date getPasswordStartDate() {
        return passwordStartDate;
    }

    public void setPasswordStartDate(Date passwordStartDate) {
        this.passwordStartDate = passwordStartDate;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getBpCategory() {
        return bpCategory;
    }

    public void setBpCategory(String bpCategory) {
        this.bpCategory = bpCategory;
    }

    public Integer getBpId() {
        return bpId;
    }

    public void setBpId(Integer bpId) {
        this.bpId = bpId;
    }

    public String getTmFlag() {
        return tmFlag;
    }

    public void setTmFlag(String tmFlag) {
        this.tmFlag = tmFlag;
    }

    public String getEncryptedFoundationPassword() {
        return encryptedFoundationPassword;
    }

    public void setEncryptedFoundationPassword(String encryptedFoundationPassword) {
        this.encryptedFoundationPassword = encryptedFoundationPassword;
    }

    public Date getLastLogonDate() {
        return lastLogonDate;
    }

    public void setLastLogonDate(Date lastLogonDate) {
        this.lastLogonDate = lastLogonDate;
    }

    public Integer getPasswordLifespanAccess() {
        return passwordLifespanAccess;
    }

    public void setPasswordLifespanAccess(Integer passwordLifespanAccess) {
        this.passwordLifespanAccess = passwordLifespanAccess;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getVenderId() {
        return venderId;
    }

    public void setVenderId(Integer venderId) {
        this.venderId = venderId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", encryptedUserPassword='" + encryptedUserPassword + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", frozenFlag='" + frozenFlag + '\'' +
                ", encryptedFoundationPassword='" + encryptedFoundationPassword + '\'' +
                ", lastLogonDate=" + lastLogonDate +
                ", passwordLifespanAccess=" + passwordLifespanAccess +
                ", employeeId=" + employeeId +
                ", customerId=" + customerId +
                ", venderId=" + venderId +
                ", frozenFlag='" + frozenFlag + '\'' +
                ", frozenDate=" + frozenDate +
                ", passwordStartDate=" + passwordStartDate +
                ", menuType='" + menuType + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", bpCategory='" + bpCategory + '\'' +
                ", bpId=" + bpId +
                ", tmFlag='" + tmFlag + '\'' +
                '}';
    }
}

