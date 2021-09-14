package util;

import org.apdplat.word.segmentation.Word;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 文本相似度计算
 * 判定方式：简单共有词，通过计算两篇文档共有的词的总字符数除以最长文档字符数来评估他们的相似度
 * 算法步骤描述：
 * 1、分词
 * 2、求交集（去重），累加交集的所有的词的字符数得到 intersectionLength
 * 3、求最长文本字符数 Math.max(words1Length, words2Length)
 * 4、2中的值除以3中的值 intersectionLength/(double)Math.max(words1Length, words2Length)
 * 完整计算公式：
 * double score = intersectionLength/(double)Math.max(words1Length, words2Length);
 * @author 杨尚川
 */
public class SimpleCommonWords {
    /**
     * 计算相似度分值
     * @param words1 词列表1
     * @param words2 词列表2
     * @return 相似度分值
     */
    public static double similarityCalculate(List<Word> words1, List<Word> words2) {
        // 计算词列表1总的字符数
        AtomicInteger words1Length = new AtomicInteger();
        words1.parallelStream().forEach(word -> words1Length.addAndGet(word.getText().length()));
        // 计算词列表2总的字符数
        AtomicInteger words2Length = new AtomicInteger();
        words2.parallelStream().forEach(word -> words2Length.addAndGet(word.getText().length()));
        // 计算词列表1和词列表2共有的词的总的字符数
        words1.retainAll(words2);
        AtomicInteger intersectionLength = new AtomicInteger();
        words1.parallelStream().forEach(word -> {
            intersectionLength.addAndGet(word.getText().length());
        });
        double result = intersectionLength.get()/(double)Math.max(words1Length.get(), words2Length.get());
        return result;
    }
}