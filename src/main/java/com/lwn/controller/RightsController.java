package com.lwn.controller;

import com.alibaba.fastjson.JSONObject;
import com.lwn.entity.Rights;
import com.lwn.mapper.RightsMapper;
import com.lwn.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rights")
public class RightsController {

    @Autowired
    private RightsMapper rightsMapper;

    @GetMapping("/b")
    public Object test1() {
        List<Rights> rights = rightsMapper.select2();
        return listToTree("0", rights);
    }

    public List<Rights> listToTree(String id, List<Rights> list) {
        // 构建以 parentId 为键，子节点列表为值的映射
        Map<String, List<Rights>> childrenMap = list.stream()
                .collect(Collectors.groupingBy(Rights::getParentId));

        // 递归构建树结构
        return buildTree(id, childrenMap);
    }

    private List<Rights> buildTree(String parentId, Map<String, List<Rights>> childrenMap) {
        /*
         * 根据传入的pid作为key获取对应的子节点列表
         * getOrDefault获取key对应的value，第二个参数是默认值，如果key存在，返回key的value，否则返回默认值
         * Collections.emptyList()设置一个空list
         * */
        List<Rights> children = childrenMap.getOrDefault(parentId, Collections.emptyList());

        // 为每个子节点递归设置其子节点，一开始传入的pid=0，即最先从根节点list开始遍历
        for (Rights child : children) {
            child.setChildren(buildTree(child.getId(), childrenMap));
        }
        // 返回节点节点list
        return children;
    }

    @GetMapping
    public List<Rights> getRights() {
        List<Rights> rights = rightsMapper.select2();
        List<Rights> tree = TreeUtils.listToTree("0", rights);
        return tree;
    }
}
