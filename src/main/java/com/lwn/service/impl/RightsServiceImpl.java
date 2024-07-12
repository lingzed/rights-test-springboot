package com.lwn.service.impl;

import com.lwn.entity.Rights;
import com.lwn.mapper.RightsMapper;
import com.lwn.service.RightsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RightsServiceImpl implements RightsService {
    @Resource
    private RightsMapper rightsMapper;

    //    @Override
    public List<Rights> selectRights() {
        return rightsMapper.select2();
    }

    @Override
    public List<Rights> selectRightsByRole(Integer roleId) {
        return rightsMapper.selectByRole(roleId);
    }
}
