/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package mpdp.base;

import org.springframework.util.StringUtils;

/**
 *
 * @author Gonjan
 * @version $Id: SensitiveAttrsEnum.java, v 0.1 2018年01月11日 17:19 Gonjan Exp $
 */
public enum SensitiveAttrsEnum {

    OCCUPATION("occupation", "职业"),
    EDUCATION("education","教育程度"),
    MARITALSTATUS("maritalstatus","婚姻状况"),
    WORKCLASS("workclass","工薪阶层"),
    RACE("race","种族");

    private String attrs;

    private String attrsDesc;

    SensitiveAttrsEnum(String attrs,String attrsDesc) {
        this.attrs = attrs;
        this.attrsDesc = attrsDesc;
    }


    /**根据名称获取枚举类型**/
    public static SensitiveAttrsEnum getEnum(String enumNameString) {
        if(StringUtils.isEmpty(enumNameString)) {
            return null;
        }
        for(SensitiveAttrsEnum sensitiveEnmu : SensitiveAttrsEnum.values()) {
            if(sensitiveEnmu.name().equals(enumNameString)) {
                return sensitiveEnmu;
            }
        }
        return null;
    }

}