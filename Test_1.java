package com.blog.cola;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Test {

    private String name = "张三"; // 姓名
    private String stuId = "xh123456789"; // 学号
    private String subject = "计算机"; // 专业

    public Test(){}
    public Test(char[] cList){
        charCount(cList);
    }

    private String cList; // 统计的字符
    private int[] countList; // 对应字符出现的个数

    /**
     * 从文件读取字符串
     * @param filePath 文件路径
     * @return str
     */
    public String read(String filePath) {
        File file = new File(filePath);
        long fileLength = file.length();
        byte[] fileContent = new byte[(int) fileLength];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(fileContent, StandardCharsets.UTF_8);
    }

    /**
     * 将String写入对应文件
     * @param str 字符串
     * @param filePath 文件路径
     */
    public void write(String str, String filePath){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符串处理函数
     * @param str str
     * @return str
     */
    public String cut(String str){
        boolean b = true; // 用于判断插入逗号还是句号
        StringBuilder builder = new StringBuilder();
        char[] ch = str.toCharArray(); // 转为数组
        int n;
        for (int i = 0; i < ch.length; i++) {
            // 统计指定字符个数
            if (cList != null && (n = cList.indexOf(ch[i])) != -1){
                    countList[n]++;
            }
            builder.append(ch[i]);
            if ((i+1) % 7 == 0){
                builder.append(b ? "，" : "。\r\n");
                b = !b;
            }
        }
        builder.delete(builder.length()-2, builder.length()); // 删除最后的"\r\n"
        return builder.toString();
    }

    /**
     * 设置需统计字符
     * @param c 字符
     */
    public void charCount(char[] c){
        this.cList =  new String(c);
        this.countList = new int[c.length];
    }

    /**
     * 打印字符统计结果
     * @return 统计结果
     */
    public String printCharCount(){
        if (cList != null){
            StringBuilder builder = new StringBuilder();
            builder.append("出现给定字符统计结果：\r\n");
            char[] ch = cList.toCharArray(); //转char[]
            for (int i = 0; i < ch.length; i++) {
                builder.append(ch[i]).append(":\t").append(countList[i]).append("次。\r\n");
            }
            return builder.toString();
        }
        return null;
    }

    /**
     * 整合学生信息
     * @return str
     */
    public String stuInfo(){
        StringBuilder builder = new StringBuilder();
        builder.append("姓名：\t").append(name).append("\r\n");
        builder.append("学号：\t").append(stuId).append("\r\n");
        builder.append("专业：\t").append(subject).append("\r\n");
        return builder.toString();
    }


    /**
     * 学生信息的get set方法
     */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStuId() { return stuId; }
    public void setStuId(String stuId) { this.stuId = stuId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public static void main(String[] args) {
        Test t = new Test(new char[]{'此','汉'});
        String str = t.read("F://2.txt");
        str = t.stuInfo() + t.cut(str);
        t.write(str,"F://1.txt");
        System.out.println(t.printCharCount());
    }
}