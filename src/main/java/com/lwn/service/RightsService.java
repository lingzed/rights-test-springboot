package com.lwn.service;

import com.lwn.entity.Rights;

import java.util.List;

public interface RightsService {
    List<Rights> selectRightsByRole(Integer roleId);
}
