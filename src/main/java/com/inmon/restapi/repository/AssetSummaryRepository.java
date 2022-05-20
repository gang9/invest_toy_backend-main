package com.inmon.restapi.repository;


import com.inmon.restapi.entity.member.Member;
import com.inmon.restapi.entity.summary.AssetSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetSummaryRepository extends JpaRepository<AssetSummary, Long> {

}
