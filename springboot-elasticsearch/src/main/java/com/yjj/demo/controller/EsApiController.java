package com.yjj.demo.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/esApi")
public class EsApiController {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @GetMapping(value = "/elasticsearch")
    public JSONArray getDoc() throws IOException {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("name","张飞"));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);

        SearchRequest searchRequest = new SearchRequest("users");
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();

        JSONArray jsonArray = new JSONArray();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            JSONObject jsonObject = new JSONObject(sourceAsString);
            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }
}
