package com.lc.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.pattern.PatternTokenizer;

import java.util.regex.Pattern;

/**
 * @Description: 正则分词器
 * @Auther: LuChao
 * @Date: 2022/8/9 11:34
 * @Version: v1.0
 */
public class PatternAnalyzer extends Analyzer {
    /**
     * 分词的正则表达式
     */
    private String regex;

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        /*
        group=-1 (the default) is equivalent to "split". In this case, the tokens will be
        equivalent to the output from (without empty tokens): String.split(String)
         */
        PatternTokenizer it = new PatternTokenizer(Pattern.compile(regex), -1);
        return new TokenStreamComponents(it);
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
