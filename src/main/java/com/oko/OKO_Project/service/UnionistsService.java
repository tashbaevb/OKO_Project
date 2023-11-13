package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.Unionists;
import com.oko.OKO_Project.enums.UnionistsType;

import java.util.List;

public interface UnionistsService {

    Unionists createUnionists(Unionists unionists);

    List<Unionists> getAllUnionists();

    List<Unionists> getUnionistsByType(UnionistsType unionistsType);
}
