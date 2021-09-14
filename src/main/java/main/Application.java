package main;

import org.apdplat.word.segmentation.Word;

import util.CuttingFile;
import util.FileUtil;
import util.SimpleCommonWords;

import java.io.File;
import java.util.List;
public class Application{
	public static void main(String[] args) {
		//从命令行给出几个文件的绝对路径
        // 输入文件并对其进行分词
        List<Word> txt1 = CuttingFile.cuttingFile(new File(args[0]));
        List<Word> txt2 = CuttingFile.cuttingFile(new File(args[1]));

        // 调用SimpleCommonWords类中的简单共有词算法进行相似度计算
        double result = SimpleCommonWords.similarityCalculate(txt1, txt2);

        // 输出结果到指定文件中
        FileUtil.ouput(result, args[0], args[1], args[2]);
        System.out.println("------------------------");
        System.out.println("结果文件路径：" + args[2]);

        //System.exit(0);
    }
}