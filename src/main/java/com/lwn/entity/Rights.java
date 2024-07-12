package com.lwn.entity;

import com.lwn.utils.TreeUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rights implements TreeUtils.TreeNode<Rights> {
    private String id;
    private String authName;
    private String icon;
    private String parentId;
    private String path;
    private List<String> rights;
    private List<Rights> children;

    /**
     * 将字符串转换成list
     *
     * @param rights
     */
    public void setRights(String rights) {
        this.rights = Arrays.asList(rights.split(","));
    }
}
