package com.assestmanagement.dao;

import com.assestmanagement.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.util.List;

@Repository
public interface AssetDao extends JpaRepository<Asset, String> {
    public Asset findAssetByAssetId(String assetId);

    @Query("SELECT u from Asset u where u.assetName = :e")
    public List<Asset> findAssetByAssetName(@Param("e") String assetName);
}
