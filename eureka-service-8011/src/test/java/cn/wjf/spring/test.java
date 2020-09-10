package cn.wjf.spring;

import cn.wjf.spring.configure.ApplicationConfigure;
import cn.wjf.spring.service.impl.UserAndRoleServiceImpl;
import com.alibaba.fastjson.JSON;
import entity.Role;
import entity.User;
import org.bouncycastle.cert.ocsp.Req;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.ArrayList;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class test {


    @Autowired
    UserAndRoleServiceImpl userAndRoleService;

    @Autowired
    @Qualifier("restHighLevelClient")
    RestHighLevelClient restHighLevelClient;

    @Test
    public void one(){
        User user = userAndRoleService.selectUserById(1, 0, 2);
        System.out.println(user);
        System.out.println("6666666");
    }

    // 测试索引的创建
    @Test
    public void two() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("wjf2");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.index());
    }

    // 测试获取索引,判断其是否存在
    @Test
    public void three() throws IOException {
        GetIndexRequest wjf2 = new GetIndexRequest("wjf2");
        boolean exists = restHighLevelClient.indices().exists(wjf2, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 测试删除索引
    @Test
    public void four() throws IOException {
        DeleteIndexRequest wjf2 = new DeleteIndexRequest("wjf2");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(wjf2, RequestOptions.DEFAULT);
        System.out.println(delete);
    }

    // 测试添加文档
    @Test
    public void five() throws IOException {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(1,"Super User",1,new User()));
        User user = new User(1,"wjf2","123456",roles);

        IndexRequest indexRequest = new IndexRequest();
        indexRequest.id("1");
        indexRequest.index("wjf2");
       /* indexRequest.timeout(TimeValue.timeValueMillis(3000));*/
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);//不写会出现The number of object passed must be even but was [1]
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(index);
    }

    // 获取文档，判断是否存在
    @Test
    public void six() throws IOException {
        GetRequest getRequest = new GetRequest();
        getRequest.id("1");
        getRequest.index("wjf2");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 获得文档的信息
    @Test
    public void seven() throws IOException {
        GetRequest getRequest = new GetRequest();
        getRequest.index("wjf2");
        getRequest.id("1");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields);
    }

    // 更新文档的信息
    @Test
    public void eight() throws IOException {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(1,"Super User2",1,new User()));
        User user = new User(1,"wjf2","6666661",roles);
        UpdateRequest wjf2 = new UpdateRequest("wjf2", "1");
        wjf2.doc(JSON.toJSONString(user),XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(wjf2, RequestOptions.DEFAULT);
        System.out.println(update);
    }


    // 删除文档记录
    @Test
    public void nine() throws IOException {
        DeleteRequest wjf2 = new DeleteRequest();
        wjf2.id("1");
        wjf2.index("wjf2");
        DeleteResponse delete = restHighLevelClient.delete(wjf2, RequestOptions.DEFAULT);
        System.out.println(delete);
    }

    // 特殊的，真的项目一般都会批量插入数据！
    @Test
    public void ten() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(2,"wjf2","6666661",new ArrayList<Role>()));
        users.add(new User(3,"wjf3","6666663",new ArrayList<Role>()));
        users.add(new User(4,"wjf4","6666664",new ArrayList<Role>()));

        for(int i=0;i<users.size();i++){
            bulkRequest.add(new IndexRequest().index("wjf2").id(""+(i+2)).source(JSON.toJSONString(users.get(i)),XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk);
    }

    // 查询
    // SearchRequest 搜索请求
    // SearchSourceBuilder 条件构造
    // HighlightBuilder 构建高亮
    // TermQueryBuilder 精确查询
    // MatchAllQueryBuilder
    // xxx QueryBuilder 对应我们刚才看到的命令！
    @Test
    public void test11() throws IOException {
        SearchRequest searchRequest = new SearchRequest("wjf2");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("username", "wjf2");
        //HighlightBuilder highlighter = searchSourceBuilder.highlighter();
       /* highlighter.preTags("<span style='color:red'>");
        highlighter.postTags("</span>");
        highlighter.field("username");*/
        //searchSourceBuilder.highlighter(highlighter);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(3);
        searchSourceBuilder.query(matchQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search.getHits());
    }

}
