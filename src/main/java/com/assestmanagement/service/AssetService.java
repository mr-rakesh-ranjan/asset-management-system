package com.assestmanagement.service;

import com.assestmanagement.constants.Status;
import com.assestmanagement.entity.Asset;

import java.util.List;

public interface AssetService {

    //create new asset
    public Asset addAsset(Asset asset);
    //list of all assets
    public List<Asset> allAssets();
    //get asset by name
    public List<Asset> getAssetByName(String assetName);
    //update asset
    public Asset updateAsset(Asset asset);
    //delete asset
    public void deleteAsset(String assetId);
    //assigned asset to employee
    public String assignedAssetToEmployee(Status status, String assetId);
    //recovered asset from employee
    public String recoveredAssetFromEmployee(Status status, String assetId);
}
