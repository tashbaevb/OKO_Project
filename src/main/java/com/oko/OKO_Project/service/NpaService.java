package com.oko.OKO_Project.service;


import com.oko.OKO_Project.entity.Npa;
import com.oko.OKO_Project.enums.NpaType;

import java.util.List;

public interface NpaService {

    Npa createNpa(Npa npa);

    List<Npa> getAllNpa();

    List<Npa> getNpaByType(NpaType npaType);
}
