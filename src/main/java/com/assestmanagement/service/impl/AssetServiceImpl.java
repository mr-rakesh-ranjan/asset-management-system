package com.assestmanagement.service.impl;

import com.assestmanagement.constants.Status;
import com.assestmanagement.dao.AssetDao;
import com.assestmanagement.entity.Asset;
import com.assestmanagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetDao assetDao;

    //create new asset
    @Override
    public Asset addAsset(Asset asset) {
        return this.assetDao.save(asset);
    }

    @Override
    public List<Asset> allAssets() {
        List<Asset> list = this.assetDao.findAll();
        return list;
    }

    @Override
    public List<Asset> getAssetByName(String assetName) {
        return this.assetDao.findAssetByAssetName(assetName);
    }

    @Override
    public Asset updateAsset(Asset asset) {
        Asset asset1 = this.addAsset(asset);
        System.out.println(asset1);
        return asset1;
    }

    @Override
    public void deleteAsset(String assetId) {
        Asset asset = this.assetDao.findAssetByAssetId(assetId);
        System.out.println(asset);
        this.assetDao.delete(asset);
    }

    @Override
    public String assignedAssetToEmployee(Status status, String assetId) {
        Asset asset = this.assetDao.findAssetByAssetId(assetId);
        Status currentAssetStatus = asset.getAssetAssignmentStatus();
        if(currentAssetStatus == Status.AVAILABLE || currentAssetStatus == Status.RCOVERED){
            asset.setAssetAssignmentStatus(Status.ASSIGNED);
            this.assetDao.save(asset);
            System.out.println(asset);
            return "Asset is assigned successfully.";
        } else {
            return "Asset is not available right now.";
        }
    }

    @Override
    public String recoveredAssetFromEmployee(Status status, String assetId) {
        Asset asset = this.assetDao.findAssetByAssetId(assetId);
        Status currentAssetStatus = asset.getAssetAssignmentStatus();
        if(currentAssetStatus == Status.ASSIGNED){
            asset.setAssetAssignmentStatus(Status.RCOVERED);
            this.assetDao.save(asset);
            return "Asset is recovered successfully.";
        } else {
            return "Asset is not recovered from any employee.";
        }
    }
}
