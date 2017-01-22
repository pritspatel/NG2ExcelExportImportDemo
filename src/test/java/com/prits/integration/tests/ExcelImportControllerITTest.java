package com.prits.integration.tests;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;


import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by 3ppat on 1/22/2017.
 */
public class ExcelImportControllerITTest {
    @Test
    public void whenUploadFileUsingHttpClient_thenCorrect() throws ClientProtocolException, IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:9999/api/upload");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", new File("C:\\tmp\\file.xls"), ContentType.APPLICATION_OCTET_STREAM, "C:\\tmp\\uploads\\upload.xls");
        HttpEntity multipart = builder.build();

        httpPost.setEntity(multipart);

        CloseableHttpResponse response = null;

        response = client.execute(httpPost);

        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));

        client.close();

    }

}