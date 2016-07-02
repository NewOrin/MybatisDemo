package com.neworin.test;

import java.io.*;

/**
 * 读取文件Demo
 * java读取txt文件内容。可以作如下理解：

 首先获得一个文件句柄。File file = new File(); file即为文件句柄。两人之间连通电话网络了。接下来可以开始打电话了。

 通过这条线路读取甲方的信息：new FileInputStream(file) 目前这个信息已经读进来内存当中了。接下来需要解读成乙方可以理解的东西

 既然你使用了FileInputStream()。那么对应的需要使用InputStreamReader()这个方法进行解读刚才装进来内存当中的数据

 解读完成后要输出呀。那当然要转换成IO可以识别的数据呀。那就需要调用字节码读取的方法BufferedReader()。同时使用bufferedReader()的readline(）方法读取txt文件中的每一行数据哈。
 * Created by NewOrin Zhang on 2016/6/29.
 * Email: NewOrinZhang@Gmail.com
 */
public class FileTest {
    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Neworin\\Desktop\\test.txt";
        readFile(filePath);
    }

    public static void readFile(String filePath) {
        String encoding = "GBK";
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println("输出内容:" + lineTxt);
                }
                read.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
