package com.lc.lucene.service;

import com.lc.lucene.dao.BankInfoDao;
import com.lc.lucene.model.BankBranchEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: LuChao
 * @Date: 2022/8/9 16:29
 * @Version: v1.0
 */
@Service
@Slf4j
public class BankBranchServiceImpl implements BankBranchService {
    Directory directory = new RAMDirectory();
    @Resource
    private BankInfoDao bankInfoDao;

    public BankBranchServiceImpl() {
    }

    @Override
    public void createIndex() throws IOException {
        //指定索引库的存放位置Directory对象
        //Directory directory = new MMapDirectory(Paths.get("/lucene/"));
        //指定一个分析器，对文档内容进行分析。
        Analyzer analyzer = new IKAnalyzer(Boolean.TRUE);
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

        try (IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig)) {
            int count = bankInfoDao.branchCount();

            //查询数据库
            int pageSize = 10000, total = 0;
            while (total < count) {
                Map<String, String> param = new HashMap<>();
                param.put("from", String.valueOf(total));
                param.put("to", String.valueOf(total + pageSize));
                total = total + pageSize;
                List<BankBranchEntity> bankBranchEntities = bankInfoDao.loadBankBranchs(param);
                for (BankBranchEntity bankBranchEntity : bankBranchEntities) {
                    Document document = new Document();
                    document.add(new StringField("bankCode", bankBranchEntity.getBankcode(), Field.Store.YES));
                    document.add(new TextField("branchName", bankBranchEntity.getBranchname(), Field.Store.YES));
                    document.add(new StringField("branchCode", bankBranchEntity.getBranchcode(), Field.Store.YES));
                    //使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库
                    indexWriter.addDocument(document);
                }
            }
        }
    }

    @Override
    public BankBranchEntity query(String bankName) throws IOException, ParseException {
        log.info("============查询行名{}=====", bankName);
        IKAnalyzer analyzer = new IKAnalyzer(Boolean.TRUE);

        //指定索引库的存放位置Directory对象
        //Directory directory = new MMapDirectory(Paths.get("/lucene/"));
        //创建IndexReader对象，需要指定Directory对象
        IndexReader indexReader = DirectoryReader.open(directory);

        //创建Indexsearcher对象，需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //创建queryparser对象
        //第一个参数默认搜索的域
        //第二个参数就是分析器对象
        QueryParser queryParser = new QueryParser("branchName", analyzer);
        //使用默认的域,这里用的是语法，下面会详细讲解一下
        Query query = queryParser.parse(bankName);
        //不使用默认的域，可以自己指定域
        //Query query = queryParser.parse("fileContent:apache");
        //执行查询

        //第一个参数是查询对象，第二个参数是查询结果返回的最大值
        TopDocs topDocs = indexSearcher.search(query, 4);

        //查询结果的总条数
        log.info("查询结果的总条数：" + topDocs.totalHits);
        //遍历查询结果
        //topDocs.scoreDocs存储了document对象的id
        //ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            //scoreDoc.doc属性就是document对象的id
            //int doc = scoreDoc.doc;
            //根据document的id找到document对象
            Document document = indexSearcher.doc(scoreDoc.doc);
            log.info(document.get("branchName"));
            log.info(document.get("bankCode"));
            log.info(document.get("branchCode"));
            log.info("----------------------------------");
        }
        //关闭indexreader对象
        indexReader.close();

        return null;
    }

}
