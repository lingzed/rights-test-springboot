package com.lwn.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * list转换成tree的工具类
 */
public class TreeUtils {
    // 定义一个接口，确保传入的类型包含getId、getParentId和setChildren方法
    public interface TreeNode<T> {
        Comparable getId();

        Comparable getParentId();

        void setChildren(List<T> children);
    }

    /**
     * 创建HashMap，通过pid进行分组，将同一组的节点整合为list
     * pid作为key，节点list作为value
     *
     * @param pid  节点的父节点id，只能接收String和Integer类型
     * @param list 需要转换成tree的list
     * @param <T>
     * @return 转换成tree后的list
     */
    public static <T extends TreeNode<T>> List<T> listToTree(Comparable pid, List<T> list) {
        Map<Comparable, List<T>> map = list.stream().collect(Collectors.groupingBy(TreeNode::getParentId));

        return buildTree(pid, map);
    }

    /**
     * 通过pid得到对应节点list，遍历list，递归将节点的子节点填充到自己
     * 返回包含子节点的节点list
     *
     * @param pid 节点的父节点id，只能接收String和Integer类型
     * @param map 完整的pid与节点list的映射
     * @param <T>
     * @return 转换成tree后的list
     */
    public static <T extends TreeNode<T>> List<T> buildTree(Comparable pid, Map<Comparable, List<T>> map) {
//        List<T> list = map.getOrDefault(pid, Collections.emptyList());
        List<T> list = map.getOrDefault(pid, null);
        if (list != null) {
            for (T t : list) {
                t.setChildren(buildTree(t.getId(), map));
            }
        }
        return list;
    }
}
