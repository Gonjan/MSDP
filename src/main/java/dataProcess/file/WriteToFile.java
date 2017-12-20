/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.file;

import com.google.common.collect.Lists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gonjan
 * @version $Id: WriteToFile.java, v 0.1 2017年12月04日 19:58 Gonjan Exp $
 */
public class WriteToFile {


    public static void writeListToFile(List<String> lists, String fileName) {
        if(lists == null || lists.size() == 0 ) {
            return;
        }
        StringBuilder content = new StringBuilder();
        for(String ele : lists) {
            content.append(ele).append("\n");
        }
        fileWriter(content.toString(), fileName);

    }

    public static void fileWriter(String line, String fileName) {
        FileWriter writer = null;
        BufferedWriter bw = null;
        try{
            writer = new FileWriter(fileName);
            bw = new BufferedWriter(writer);
            bw.write(line);
        } catch (Exception e) {
            System.err.println("文件写入出错！！！");
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件写入成功");

    }

    public static void main(String[] args) {
        String fileName = "E:\\论文\\论文实验\\data\\surplus_line.txt";
        String str1 = "a,b,c";
        String str2 = "aa,bb,cc";
        List<String> list = Lists.newArrayList();
        list.add(str1);
        list.add(str2);
        List<String> newList = list.stream().map(param -> param + "dd").collect(Collectors.toList());
        writeListToFile(newList, fileName);
    }
}