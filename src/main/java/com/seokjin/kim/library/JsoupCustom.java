package com.seokjin.kim.library;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupCustom {
    
    private JsoupCustom() {}
    
    
    /**
     * Url에서 Dom객체 얻어오기, GET 통신
     * @param url
     * @return Document
     * @throws IOException 
     * @throws Exception 
     */
    public static Document getGetDocumentFromURL( String url ) {
        return getGetDocumentFromURL( url, Collections.EMPTY_MAP );
    }
    public static Document getGetDocumentFromURL( String url, Map<String, String> params ) {
        String changedURL = HttpClientCustom.getParamToString(url, params);
        Document result = new Document("");
        try {
            Connection connection = Jsoup.connect(changedURL);
            result = connection.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    /**
     * 로컬 xml파일에서 xml파싱한 결과 가지고 오기 
     * @param url
     * @return Document
     * @throws IOException 
     * @throws Exception 
     */
    public static org.w3c.dom.Document getGetDocumentFromXML( String url ) {
        org.w3c.dom.Document result = null;
        try {
            File fXmlFile = new File(url);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            result = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
