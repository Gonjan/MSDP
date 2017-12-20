/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: FileHandler.java, v 0.1 2017年11月25日 11:28 Gonjan Exp $
 */
public class FileHandler {
    /**
     * 读取文件所有行，并返回一个list，包含所有行
     */
    public static List<String> readAllLines(String filePath) {
        List<String> lineList = new ArrayList<String>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine()) != null) {
                lineList.add(line);
            }

        } catch (IOException e) {
            System.err.println("读取文件失败");
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lineList;
    }

    public static void main(String[] args) {
        String filePath = "F:\\PyCharmWorkSpace\\Test\\dataProcess\\test_result.txt";
        List<String> lineList = readAllLines(filePath);
        System.out.println(lineList.size());
        for(String line : lineList) {
            System.out.println(line);
        }
    }
}