package util;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.io.File;
import java.util.List;

public class CuttingFile {
    // 分词算法调用
    public static List<Word> cuttingFile(File file){
        String string1 = FileUtil.readFile(file);
        // 调用word分词其中的分词函数
        List<Word> string2 = WordSegmenter.segWithStopWords(string1);
        return string2;
    }

    public static List<Word> cuttingFile(String string1){
        List<Word> string2 = WordSegmenter.segWithStopWords(string1);
        return string2;
    }
}
