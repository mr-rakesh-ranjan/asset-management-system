package com.assestmanagement.entity;

import com.assestmanagement.constants.Status;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Asset {
    @Id
    @GeneratedValue(generator = "asset-generator")
    @GenericGenerator(name = "asset-generator",
            parameters = @Parameter(name = "prefix", value = "AST"),
            strategy = "com.assestmanagement.genrator.MyGenerator"
    )
    private String assetId;
    private String assetName;
    @Temporal(TemporalType.DATE)
    private Date assetPurchaseDate;
    private String assetConditionNotes;
    private String assetCategory;
    private Status assetAssignmentStatus;

    public Asset(String assetId, String assetName, Date assetPurchaseDate, String assetConditionNotes, String assetCategory, Status assetAssignmentStatus) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetPurchaseDate = assetPurchaseDate;
        this.assetConditionNotes = assetConditionNotes;
        this.assetCategory = assetCategory;
        this.assetAssignmentStatus = assetAssignmentStatus;
    }

    public Asset() {
        super();
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Date getAssetPurchaseDate() {
        return assetPurchaseDate;
    }

    public void setAssetPurchaseDate(Date assetPurchaseDate) {
        this.assetPurchaseDate = assetPurchaseDate;
    }

    public String getAssetConditionNotes() {
        return assetConditionNotes;
    }

    public void setAssetConditionNotes(String assetConditionNotes) {
        this.assetConditionNotes = assetConditionNotes;
    }

    public String getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }

    public Status getAssetAssignmentStatus() {
        return assetAssignmentStatus;
    }

    public void setAssetAssignmentStatus(Status assetAssignmentStatus) {
        this.assetAssignmentStatus = assetAssignmentStatus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Asset{");
        sb.append("assetId='").append(assetId).append('\'');
        sb.append(", assetName='").append(assetName).append('\'');
        sb.append(", assetPurchaseDate=").append(assetPurchaseDate);
        sb.append(", assetConditionNotes='").append(assetConditionNotes).append('\'');
        sb.append(", assetCategory=").append(assetCategory);
        sb.append(", assetAssignmentStatus=").append(assetAssignmentStatus);
        sb.append('}');
        return sb.toString();
    }
}
