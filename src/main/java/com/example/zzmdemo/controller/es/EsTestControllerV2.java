package com.example.zzmdemo.controller.es;

import com.example.zzmdemo.dto.Article;
import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * es之java操作插入文档4方式：
 * 1、  使用json字符串直接创建
 * 2、  使用Map集合
 * 3、  使用第三方库来序列化  createDocumentBySerialize
 * 4、  使用内置的帮助器XContentFactory.jsonBuilder（）
 *
 * @author zhangzhiming
 * @since 2020/4/20 14:15
 */
@RestController
@RequestMapping("/es2")
public class EsTestControllerV2 {

    @Value("${cluster.name}")
    private String clusterName;
    @Value("${network.host}")
    private String networkHost;

    public TransportClient getTransportClient() throws UnknownHostException {
        // 指定ES集群
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        System.out.println(settings);
        // 创建ES客户端，客户端端口号默认9300，不要写web端口9200
        @SuppressWarnings("resource")
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(networkHost), 9300));
        client.prepareIndex();
        return client;
    }


    @RequestMapping("addByJson")
    public Response addByJson() throws IOException {
        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        //IndexRequestBuilder prepareIndex(String index, String type)
        final IndexResponse response = getTransportClient().prepareIndex("twitter", "tweet")
                .setSource(json).get();
        //获取索引
        final String index = response.getIndex();
        //获取类型
        final String type = response.getType();
        // 文档ID
        String id = response.getId();
        // 版本
        long version = response.getVersion();
        // 返回的操作状态
        RestStatus status = response.status();
        String message = "索引名称:" + index + " " + "类型 :" + type + " 文档ID：" + id + " 版本 ：" + version + " 返回的操作状态：" + status;
        System.out.println(message);
        return new ObjectResponse<>(message);
    }

    @RequestMapping("addByMap")
    public Response addByMap() throws IOException {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user", "jike");
        json.put("postDate", new Date());
        json.put("message", "trying out Elasticsearch by map");
        final IndexResponse response = getTransportClient().prepareIndex("twitter2", "tweet")
                .setSource(json).get();
        //获取索引
        final String index = response.getIndex();
        //获取类型
        final String type = response.getType();
        // 文档ID
        String id = response.getId();
        // 版本
        long version = response.getVersion();
        // 返回的操作状态
        RestStatus status = response.status();
        String message = "索引名称:" + index + " " + "类型 :" + type + " 文档ID：" + id + " 版本 ：" + version + " 返回的操作状态：" + status;
        System.out.println(message);
        System.out.println("response: " + response.toString());
        return new ObjectResponse<>(message);
    }

    @RequestMapping("addByJsonBuilder")
    public Response addByJsonBuilder() throws IOException {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("user", "rose")
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch byJsonBuilder")
                .endObject();
        IndexResponse response = getTransportClient().prepareIndex("twitter4", "tweet")
                .setSource(builder)
                .get();
        //获取索引
        final String index = response.getIndex();
        //获取类型
        final String type = response.getType();
        // 文档ID
        String id = response.getId();
        // 版本
        long version = response.getVersion();
        // 返回的操作状态
        RestStatus status = response.status();
        String message = "索引名称:" + index + " " + "类型 :" + type + " 文档ID：" + id + " 版本 ：" + version + " 返回的操作状态：" + status;
        System.out.println(message);
        System.out.println("response: " + response.toString());
        return new ObjectResponse<>(message);
    }


    @RequestMapping("addArticle")
    public Response addArticle(@RequestBody Article article) throws IOException {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("title", article.getType())
                .field("content", article.getContent())
                .field("createTime", new Date())
                .endObject();
        //type cmsArticle
        IndexResponse response = getTransportClient().prepareIndex("databasesname", article.getType())
                .setSource(builder)
                .get();
        return new ObjectResponse<>(response);
    }

    @RequestMapping("addArticleV2")
    public Response addArticleV2(@RequestBody Article article) throws IOException {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("title", article.getType())
                .field("content", article.getContent())
                .field("createTime", new Date())
                .endObject();
        //type cmsArticle
        IndexResponse response = getTransportClient().prepareIndex()
                .setSource(builder)
                .get();
        return new ObjectResponse<>(response);
    }


    @RequestMapping("qryByIndexAndType")
    public Response qry2(String index, String type) throws IOException {
        SearchResponse searchResponse = getTransportClient().prepareSearch(index)
                .setTypes(type).setQuery(QueryBuilders.matchAllQuery())
                .get();
        getTransportClient().close();
        return new ObjectResponse<>(searchResponse);
    }

    //cmsArticle
    @RequestMapping("qryByLike")
    public Response qryByLike(String index,String type,String content,String name) throws IOException {
        // knowledge代表的是索引名称（相当于数据库名称），knowledge_theme代表的是类型（相当于数据库中的表名）
        SearchRequestBuilder requestBuilder = getTransportClient().prepareSearch(index).setTypes(type);
        // 声明where条件
        BoolQueryBuilder qbs = QueryBuilders.boolQuery();
        //此处使用模糊匹配查询 类比数据库中 like    name代表的是字段名，‘动态’代表的是匹配的关键字
        //QueryBuilder 适用于单个字段查询（matchPhraseQuery是没有用分词起，matchQuery会使用分词器，
        // 将我们输入的值进行分割，如：“java动态”会分割成：“java”,“动态”）
        QueryBuilder qb1 = QueryBuilders.matchPhraseQuery(name, content);
        BoolQueryBuilder bqb1 = QueryBuilders.boolQuery().must(qb1);
        qbs.must(bqb1);
        requestBuilder.setQuery(qbs);
        //查询前10条数据  （此处是为了简单实现功能，才使用From,Size 进行分页查询，若数据量小可以使用，
        // 当数据量大时建议大家使用scroll方式进行分页，数据量大时From Size效率会越来越低，而scroll的效率是From Size的几倍）
        SearchResponse responses = requestBuilder.setFrom(0).setSize(10).execute().actionGet();
        return new ObjectResponse<>(responses);
    }
    @RequestMapping("qryByLikeV2")
    public Response qryByLikeV2(String index,String type,String content,String name) throws IOException {

        SearchRequestBuilder requestBuilder = getTransportClient().prepareSearch(index).setTypes(type);
        // 声明where条件
        BoolQueryBuilder qbs = QueryBuilders.boolQuery();
        //此处使用模糊匹配查询 类比数据库中 like    name代表的是字段名，‘动态’代表的是匹配的关键字
        //QueryBuilder 适用于单个字段查询（matchPhraseQuery是没有用分词起，matchQuery会使用分词器，
        // 将我们输入的值进行分割，如：“java动态”会分割成：“java”,“动态”）
        //搜索名字中含有jack文档（name中只要包含jack即可）
        WildcardQueryBuilder queryBuilder =QueryBuilders.wildcardQuery(name,"*"+content+"*");
        //搜索名字中含有_jack**的文档；如： wjacksss; ajackwww
        //        WildcardQueryBuilder queryBuilder =QueryBuilders.wildcardQuery("name","?jack*");
        BoolQueryBuilder bqb1 = QueryBuilders.boolQuery().must(queryBuilder);
        qbs.must(bqb1);
        requestBuilder.setQuery(qbs);
        SearchResponse responses = requestBuilder.setFrom(0).setSize(10).execute().actionGet();
        return new ObjectResponse<>(responses);
    }
}
