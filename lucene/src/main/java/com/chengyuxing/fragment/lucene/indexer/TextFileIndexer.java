package com.chengyuxing.fragment.lucene.indexer;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2017/6/20
 * Time: 下午11:44
 * Description:
 */
public class TextFileIndexer {
    private static StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_5_5_0);
}
