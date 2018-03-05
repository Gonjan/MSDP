/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package mpdp.base;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightGroup.java, v 0.1 2018年01月15日 19:48 Gonjan Exp $
 */
public class WeightGroup<T> {

    /**
     * 分组大小
     */
    private Integer groupSize;

    /**分组的最大权值**/
    private Double maxGroupWeight;

    /** 分组id*/
    private Integer groupId;

    /** 存放分组元组*/
    private List<T> groupContainer;

    /** 分组中所有元组在原始表中的下标 */
    private List<Integer> originTupleIds;

    /**分组中的权值**/
    private double groupWeight;

    public  WeightGroup(int groupSize, double maxGroupWeight) {
        this.groupId = 1;
        this.groupSize = groupSize;
        this.maxGroupWeight = maxGroupWeight;
        this.groupContainer = new ArrayList<>();
        this.originTupleIds = new ArrayList<>();
        this.groupWeight = new Double(0);
    }

    /**
     * 分组添加元组
     * @param t
     *
     */
    public void add(T t) {
        groupContainer.add(t);
    }

    /**
     * 判断分组是否已经满足单个分组元素个数
     * @return
     */
    public boolean isFull() {
        return groupContainer.size() == groupSize ? true : false;
    }

    /**
     * 清理分组内容，分组编号自动加一
     */
    public void clearWithIdIncrease() {
        this.originTupleIds.clear();
        this.groupContainer.clear();
        this.groupWeight = new Double(0);
        this.groupId = groupId + 1;
    }

    /**
     * 清理分组内容，id不自增
     */
    public void clearWithoutIdIncrease() {
        this.groupContainer.clear();
        this.originTupleIds.clear();
        this.groupWeight = new Double(0);
    }

    /** 重置分组，L参数不变，id清零 */
    public void reset() {
        this.originTupleIds.clear();
        this.groupContainer.clear();
        this.groupWeight = new Double(0);
        this.groupId = 1;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public List<Integer> getOriginTupleIds() {
        return this.originTupleIds;
    }

    public List<T> getGroupContainer() {
        return groupContainer;
    }

    public boolean isEmpty() {
        return groupContainer.size() == 0 ? true : false;
    }

    public Double getMaxGroupWeight() {
        return maxGroupWeight;
    }

    public double getGroupWeight() {
        return groupWeight;
    }

    public void setGroupWeight(double groupWeight) {
        this.groupWeight = groupWeight;
    }
}