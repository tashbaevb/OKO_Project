package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.GovOrgan;
import com.oko.OKO_Project.enums.GovOrgansType;

import java.util.List;

public interface GovOrgansService {

    GovOrgan createGovOrgans(GovOrgan govOrgans);

    List<GovOrgan> getAllGovOrgan();

    List<GovOrgan> getGovOrganByType(GovOrgansType govOrgansType);
}
