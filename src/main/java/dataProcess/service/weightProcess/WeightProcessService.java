/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.weightProcess;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightProcessService.java, v 0.1 2018年01月10日 14:54 Gonjan Exp $
 */
public interface WeightProcessService {

    Double processWeight(List<String> sensitives);

    void setWeightContainer(WeightContainer weightContainer);
}