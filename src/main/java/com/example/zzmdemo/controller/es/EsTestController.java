package com.example.zzmdemo.controller.es;

import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/18 13:23
 */
@RestController
@RequestMapping("/es")
public class EsTestController {

    @Value("${cluster.name}")
    private String clusterName;
    @Value("${network.host}")
    private String networkHost;

    @RequestMapping("add")
    public Response add(String id) throws IOException {
        // 指定ES集群
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        System.out.println(settings);
        // 创建ES客户端，客户端端口号默认9300，不要写web端口9200
        @SuppressWarnings("resource")
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(networkHost), 9300));

        // 构建文档数据
        XContentBuilder doc = XContentFactory.jsonBuilder().startObject().field("first_name", "Green")
                .field("last_name", "Smith").field("age", 32).field("about", "I like to collect rock albums")
                .array("interests", "music", "dance").endObject();
        // 添加文档
        //index可以理解为数据库，type 理解为数据表，例如 /blog/article/1，
        // 就表示一个 index 为 blog，type 为aritcle，id 为1的 document。其中 index、type 是必须提供的，id 是可选的，不提供的话 es 会自动生成。
        IndexResponse response = client.prepareIndex("lib", "user", id).setSource(doc).get();

        // 查看执行状态，创建成功后，之前没有CREATED，之前存在OK
        System.out.println(response.status());
        client.close();
        return new ObjectResponse<>(response);
    }

    @RequestMapping("qry")
    public Response qry(String id) throws IOException {
        // 指定ES集群
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        System.out.println(settings);
        // 创建ES客户端，客户端端口号默认9300，不要写web端口9200
        @SuppressWarnings("resource")
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(networkHost), 9300));
        // 数据查询
        GetResponse response = client.prepareGet("lib", "user", id).execute().actionGet();

        System.out.println(response.getSourceAsString());

        client.close();
        return new ObjectResponse<>(response);
    }
    @RequestMapping("qry2")
    public Response qry2(String id) throws IOException {
        // 指定ES集群
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        @SuppressWarnings("resource")
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(networkHost), 9300));
        SearchResponse searchResponse = client.prepareSearch("lib")
                .setTypes("user").setQuery(QueryBuilders.matchAllQuery())
                .get();

        client.close();
        return new ObjectResponse<>(searchResponse);
    }
    @RequestMapping("del")
    public Response del(String id) throws IOException {
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        @SuppressWarnings("resource")
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(networkHost), 9300));
        DeleteResponse response = client.prepareDelete("lib", "user", id).get();
        System.out.println(response.status());
        client.close();
        return new ObjectResponse<>(response);
    }

}
