package com.youku1327.restTemplate;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/14 18:21
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class RestTest {


    @Autowired
    RestTemplate restTemplate;

    /*
     * @Author lsc
     * @Description  <p> 获得无参的get请求 </p>
     * @Date 2019/10/17 21:15
     * @Param []
     * @return void
     **/
    @Test
    public void testGETNoParams(){
        String result = restTemplate.getForObject("http://localhost:8090/youku1327/user", String.class);
        System.out.println(result);
    }
    /*
     * @Author lsc
     * @Description  <p> URL带参 </p>
     * @Date 2019/10/18 13:49
     * @Param []
     * @return void
     **/
    @Test
    public void testGETParams(){
        // http://localhost:8090/youku1327/user/{1}
        String result = restTemplate.getForObject("http://localhost:8090/youku1327/user/{name}", String.class,"lsc");
        System.out.println(result);
    }
    /*
     * @Author lsc
     * @Description  <p> post</p>
     * @Date 2019/10/18 23:23
     * @Param []
     * @return void
     **/
    @Test
    public void testPostMethod() throws MalformedURLException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user","youku1327");
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);
        String url = "http://localhost:8090/youku1327/provider";
        ResponseEntity<String> mapResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        System.out.println(mapResponseEntity.getBody());
    }
    /*
     * @Author lsc
     * @Description  <p> put</p>
     * @Date 2019/10/18 23:23
     * @Param
     * @return
     **/

    @Test
    public void testPutMethod() throws MalformedURLException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user","youku1327");
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);
        String url = "http://localhost:8090/youku1327/provider/{id}";
        restTemplate.put(url, httpEntity, 1327);
    }

    /*
     * @Author lsc
     * @Description  <p> delete</p>
     * @Date 2019/10/18 23:22
     * @Param []
     * @return void
     **/
    @Test
    public void testDelete(){
        String url = "http://localhost:8090/youku1327/provider/{id}";
        restTemplate.delete(url,1327);
    }
    /*
     * @Author lsc
     * @Description  <p> exchange</p>
     * @Date 2019/10/18 23:22
     * @Param []
     * @return void
     **/
    @Test
    public void testExchange(){
        String url = "http://localhost:8090/youku1327/user/{name}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class, "youku1327");
        System.out.println(exchange.getBody());
    }



    @Test
    public void testURLConnection() throws IOException {

        getMethod("http://localhost:8090/youku1327/user",null);
    }

    public void getMethod(String url, String query) throws IOException {
        URL restURL = new URL(url);
        // 获得一个URLConnection
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        // 设置为 GET请求
        conn.setRequestMethod("GET");
        // 设置请求属性
        conn.setRequestProperty("Content-Type", "text/plain");
        // 表示输出
        conn.setDoOutput(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

}
