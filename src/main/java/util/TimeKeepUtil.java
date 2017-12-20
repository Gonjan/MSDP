/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package util;

/**
 *
 * @author Gonjan
 * @version $Id: TimeKeepUtil.java, v 0.1 2017年11月30日 18:15 Gonjan Exp $
 */
public class TimeKeepUtil {

    private static ThreadLocal<Long> timeKeep = new ThreadLocal<Long>();

    //线程计时开始
    public static void startTheTime() {
        timeKeep.set(System.currentTimeMillis());
    }

    //计时结束
    public static long getLengthOfTime() {
        long endTime = System.currentTimeMillis();
        long duration = endTime - timeKeep.get();
        timeKeep.remove();
        return duration;
    }

}