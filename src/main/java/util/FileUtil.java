package util;

import java.io.*;

/**
 * 文件工具类
 */
public class FileUtil {
	public static String readFile(File file) { 
		 // 1.创建字符输入流对象与结果字符串容器 
		 Reader reader = null; 
		 StringBuilder builder = null; 
		 try { 
		 reader = new FileReader(file); 
		 builder = new StringBuilder(); 
		 // 2.定义字符数组 
		 char[] ch = new char[1024]; 
		 // 定义一个变量，记录读到的有效字符数. 
		 int len; 
		 while((len = reader.read(ch)) != -1) { 
		 String s = new String(ch, 0, len); 
		 builder.append(s); 
		 } 
		 } catch (IOException e) { 
		 System.out.println("读取文件出错！"); 
		 e.printStackTrace(); 
		 } finally { 
		 //3.释放资源 
		 try { 
		 // 判断输出流是否为空 
		 if(reader != null) { 
		 reader.close(); 
		 } 
		 } catch (IOException e) { 
		 System.out.println("关闭输出流出错！"); 
		 e.printStackTrace(); 
		 } 
		 } 
		   // 返回读取结果 
		 return builder.toString(); 
		 } 
    // 新建一个文件并将结果输出到文件中
    public static void ouput(double result, String orig1, String orig2, String location){
        try{
            FileWriter creat = new FileWriter(location);
            PrintWriter out = new PrintWriter(creat, false);
            String output = String.format("%.2f", result);
            out.print("原文文件：" + orig1 + "\n");
            out.print("抄袭版论文文件：" + orig2 + "\n");
            out.print("查重结果为：" + output);
            creat.close();
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
