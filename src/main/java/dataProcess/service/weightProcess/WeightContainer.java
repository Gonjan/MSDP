/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.weightProcess;

import mpdp.base.SensitiveAttrsEnum;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Gonjan
 * @version $Id: WeightContainer.java, v 0.1 2018年01月10日 15:47 Gonjan Exp $
 */
public class WeightContainer {

    /**occpation 属性值域权值**/
    private Map<String,Double> occupationAttrsWeightMap;

    /**education 属性值域权值**/
    private Map<String,Double> educationAttrsWeightMap;

    /**maritalStatus 属性值域权值**/
    private Map<String,Double> maritalStatusAttrsWeightMap;

    /**workclass 属性值域权值**/
    private Map<String,Double> workclassAttrsWeightMap;

    /**race 属性值域权值**/
    private Map<String,Double> raceAttrsWeightMap;

    /**属性自身权值**/
    private Map<String,Double> attrsWeightMap;

    /**属性与属性值域权值map映射**/
    private EnumMap<SensitiveAttrsEnum, Map<String,Double>> attrsToValuesWeightMap
            = new EnumMap<SensitiveAttrsEnum, Map<String, Double>>(SensitiveAttrsEnum.class);

    /** 属性与属性值集合的映射**/
    private EnumMap<SensitiveAttrsEnum, Set<String>> attrsToValuesMap
            = new EnumMap<SensitiveAttrsEnum, Set<String>>(SensitiveAttrsEnum.class);

    /**
     * 初始化权值容器
     */
    public void initWeightContainer() {
        if(!CollectionUtils.isEmpty(occupationAttrsWeightMap)) {
            attrsToValuesWeightMap.put(SensitiveAttrsEnum.OCCUPATION,occupationAttrsWeightMap);
            attrsToValuesMap.put(SensitiveAttrsEnum.OCCUPATION,occupationAttrsWeightMap.keySet());
        }
        if(!CollectionUtils.isEmpty(educationAttrsWeightMap)) {
            attrsToValuesWeightMap.put(SensitiveAttrsEnum.EDUCATION,educationAttrsWeightMap);
            attrsToValuesMap.put(SensitiveAttrsEnum.EDUCATION,educationAttrsWeightMap.keySet());
        }
        if(!CollectionUtils.isEmpty(maritalStatusAttrsWeightMap)) {
            attrsToValuesWeightMap.put(SensitiveAttrsEnum.MARITALSTATUS,maritalStatusAttrsWeightMap);
            attrsToValuesMap.put(SensitiveAttrsEnum.MARITALSTATUS,maritalStatusAttrsWeightMap.keySet());
        }
        if(!CollectionUtils.isEmpty(workclassAttrsWeightMap)) {
            attrsToValuesWeightMap.put(SensitiveAttrsEnum.WORKCLASS,workclassAttrsWeightMap);
            attrsToValuesMap.put(SensitiveAttrsEnum.WORKCLASS,workclassAttrsWeightMap.keySet());
        }
        if(!CollectionUtils.isEmpty(raceAttrsWeightMap)) {
            attrsToValuesWeightMap.put(SensitiveAttrsEnum.RACE,raceAttrsWeightMap);
            attrsToValuesMap.put(SensitiveAttrsEnum.RACE,raceAttrsWeightMap.keySet());
        }
    }

    /**
     * 根据具体属性值获取该属性值的权值
     * @param value 具体属性值
     * @return 权值
     */
    public Double getValueWeight(String value)  {
        if(StringUtils.isEmpty(value)) {
            return null;
        }
        SensitiveAttrsEnum attr = getAttrsEnum(value);
        if(attr != null) {
            Map<String,Double> attrsToWeightMap = attrsToValuesWeightMap.get(attr);
            if(!CollectionUtils.isEmpty(attrsToWeightMap)) {
                return attrsToWeightMap.get(value);
            }
        }
        return null;
    }

    /**
     * 获取属性值对应属性自身权值
     * @param value
     * @return
     */
    public Double getAttrWeight(String value) {
        if(StringUtils.isEmpty(value)) {
            return null;
        }
        //获取属性值对应的属性名称
        SensitiveAttrsEnum attrEnum = getAttrsEnum(value);
        if(attrEnum != null) {
            return attrsWeightMap.get(attrEnum.getAttrs());
        }
        return null;
    }


    /**
     * 获取value对应的属性Enum
     * @param value
     * @return
     */
    private SensitiveAttrsEnum getAttrsEnum(String value) {
        Set<Entry<SensitiveAttrsEnum, Set<String>>> entrySet =  attrsToValuesMap.entrySet();
        if(!CollectionUtils.isEmpty(entrySet)) {
            for(Map.Entry<SensitiveAttrsEnum, Set<String>> entry : entrySet) {
                if(entry.getValue().contains(value)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }


    public void setOccupationAttrsWeightMap(Map<String, Double> occupationAttrsWeightMap) {
        this.occupationAttrsWeightMap = occupationAttrsWeightMap;
    }

    public void setEducationAttrsWeightMap(Map<String, Double> educationAttrsWeightMap) {
        this.educationAttrsWeightMap = educationAttrsWeightMap;
    }

    public void setMaritalStatusAttrsWeightMap(Map<String, Double> maritalStatusAttrsWeightMap) {
        this.maritalStatusAttrsWeightMap = maritalStatusAttrsWeightMap;
    }

    public void setWorkclassAttrsWeightMap(Map<String, Double> workclassAttrsWeightMap) {
        this.workclassAttrsWeightMap = workclassAttrsWeightMap;
    }

    public void setRaceAttrsWeightMap(Map<String, Double> raceAttrsWeightMap) {
        this.raceAttrsWeightMap = raceAttrsWeightMap;
    }

    public void setAttrsWeightMap(Map<String, Double> attrsWeightMap) {
        this.attrsWeightMap = attrsWeightMap;
    }
}