package com.lc.lucene.sample;

/**
 * @Description:
 * @Auther: LuChao
 * @Date: 2022/8/9 10:57
 * @Version: v1.0
 */

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.pattern.PatternTokenizer;

import java.util.regex.Pattern;

public class PatternAnalyzer extends Analyzer {



    String regex;//使用的正则拆分式

    public PatternAnalyzer(String regex) {

        this.regex=regex;

    }




    @Override
    protected TokenStreamComponents createComponents(String fieldName) {

        PatternTokenizer it = new PatternTokenizer(Pattern.compile(regex) , -1);
        return new TokenStreamComponents(it);

    }


//
//
//	@Override
//	protected TokenStreamComponents createComponents(String arg0, Reader arg1) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}