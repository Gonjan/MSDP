/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.weightProcess;

import java.util.Map;

/**
 *
 * @author Gonjan
 * @version $Id: WeightContainer.java, v 0.1 2018年01月10日 15:47 Gonjan Exp $
 */
public class WeightContainer {

    private Map<String,Double> occupationAttrsWeightMap;

    private Map<String,Double> educationAttrsWeightMap;

    private Map<String,Double> maritalStatusAttrsWeightMap;

    private Map<String,Double> workclassAttrsWeightMap;

    private Map<String,Double> raceAttrsWeightMap;








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
}