package test;

import java.util.List;

import org.apdplat.word.segmentation.Word;
import org.testng.annotations.Test;

import main.Application;
import util.CuttingFile;
import util.SimpleCommonWords;

public class TestCoverage {

	@Test
	public void testCuttingFile() {
		//分词算法测试
		//正常情况下分词
		List<Word> string1 = CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		//乱序情况下分词
		List<Word> string2 = CuttingFile.cuttingFile("我旧日令人感动却他的嗓音，老人粗哑的歌谣唱起了听到。");
		//倒序情况下分词
		List<Word> string3 = CuttingFile.cuttingFile("谣歌的旧日了起唱他，音嗓的动感人令却哑粗人老到听我。");
		//乱码情况下分词
		List<Word> string4 = CuttingFile.cuttingFile("我听！到老人%%粗哑却令人，感动的嗓@@音，他唱&&起了旧日的%%歌谣。");
		//有空格情况下分词
		List<Word> string5 = CuttingFile.cuttingFile("我听到老 人粗哑却令人感动的 嗓音，他唱起了旧  日的歌谣。");
		//输入空字符串
		List<Word> string6 = CuttingFile.cuttingFile("");
		System.out.println("正常情况下分词："+string1);
		System.out.println("乱序情况下分词："+string2);
		System.out.println("倒序情况下分词："+string3);
		System.out.println("乱码情况下分词："+string4);
		System.out.println("空格情况下分词："+string5);
		System.out.println("空字符串下分词："+string6);
	}

	@Test
	public void testSimpleCommonWord()
	{
		//文本相似度算法设计
		//测试两个完全相同的文本
		List<Word> txt1=CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		List<Word> txt2=CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		double result=SimpleCommonWords.similarityCalculate(txt1, txt2);
		//抄袭文本乱序时
		List<Word> txt3 = CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		List<Word> txt4 = CuttingFile.cuttingFile("我旧日令人感动却他的嗓音，老人粗哑的歌谣唱起了听到。");
		double result2=SimpleCommonWords.similarityCalculate(txt3, txt4);
		//抄袭文本倒序时
		List<Word> txt5 = CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		List<Word> txt6 = CuttingFile.cuttingFile("谣歌的旧日了起唱他，音嗓的动感人令却哑粗人老到听我。");
		double result3=SimpleCommonWords.similarityCalculate(txt5, txt6);
		//抄袭文本乱码时
		List<Word> txt7=CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		List<Word> txt8 = CuttingFile.cuttingFile("我听！到老人%%粗哑却令人，感动的嗓@@音，他唱&&起了旧日的%%歌谣。");
		double result4=SimpleCommonWords.similarityCalculate(txt7, txt8);
		//抄袭文本有改动时
		List<Word> txt9=CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		List<Word> txt10=CuttingFile.cuttingFile("我听到老人清亮却令人沉默的嗓音，他唱起了旧日的歌曲。");
		double result5=SimpleCommonWords.similarityCalculate(txt9, txt10);
		//抄袭文本缩短时
		List<Word> txt11=CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		List<Word> txt12=CuttingFile.cuttingFile("我听到老人的嗓音，他唱起了歌谣。");
		double result6=SimpleCommonWords.similarityCalculate(txt11, txt12);
		//抄袭文本为空时
		List<Word> txt13=CuttingFile.cuttingFile("我听到老人粗哑却令人感动的嗓音，他唱起了旧日的歌谣。");
		List<Word> txt14=CuttingFile.cuttingFile("");
		double result7=SimpleCommonWords.similarityCalculate(txt13, txt14);
		//两个文本都为空时
		List<Word> txt15=CuttingFile.cuttingFile("");
		List<Word> txt16=CuttingFile.cuttingFile("");
		double result8=SimpleCommonWords.similarityCalculate(txt15, txt16);
		System.out.println("两个完全相同的文本："+result);
		System.out.println("抄袭文本乱序时："+result2);
		System.out.println("抄袭文本倒序时："+result3);
		System.out.println("抄袭文本乱码时："+result4);
		System.out.println("抄袭文本有改动时："+result5);
		System.out.println("抄袭文本缩短时："+result6);
		System.out.println("抄袭文本为空时："+result7);
		System.out.println("两个文本都为空时："+result8);
		
	}
	@Test
	//应用程序测试
	public void testApplication() {
		Application.main(new String[]{"D:\\测试文本\\orig.txt", "D:\\测试文本\\orig_0.8_dis_10.txt", "D:\\测试文本\\结果5.txt"});
	}

}
