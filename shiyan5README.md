# 5
# 一实验目的

## 1掌握字符串String及其方法的使用
## 2掌握文件的读取/写入方法
## 3掌握异常处理结构

# 二实验内容

将学生的处理后的作业信息，以及学生的个人基本信息，存储到一个文本文件中

# 三实验过程

## 1学生的基本信息
## 2学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：

### 1每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
### 2允许提供输入参数，统计古诗中某个字或词出现的次数
### 3输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A
### 4考虑操作中可能出现的异常，在程序中设计异常处理程序

# 四核心方法

## 1String cList统计的字符
## 2int[] countList 对应字符出现的个数
## 3String read读取文件
## 4catch (IOException e)写入文件
## 5 this.countList统计字符

# 五关键代码

 public void write(String str, String filePath){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  * 将String写入对应文件
     * @param str 字符串
     * @param filePath 文件路径
     
 # 六 实验结果
 
 
 # 七实验感想 
  
 在实验中，我基本掌握了java的编程规则、知识要点和一些小技巧，特别是对面向对象的编程思想和风格有了进一步的认识和思想到。
 同时，因正确的编出程序而带来的成就感让我对编程更加感兴趣。
 对于在这些实验过程中，请教老师、同学互助、查阅资料等基本的学习方式，使我更加领悟到集体和团队的力量，也树立了敢于攻坚的信心
 ![result](https://github.com/asdfqweSMP01/5/upload/main)






