/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import java.io.File;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.apache.solr.common.util.NamedList; 
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author parth
 */
public class importdatatosolr {
    public static void main(String[] args) throws SolrServerException, IOException {
    SolrServer client = new HttpSolrServer("http://IP:8983/solr/tenant8-ipmapping");
  //  ContentStreamUpdateRequest req = new ContentStreamUpdateRequest("/update/extract");
    File file = new File("C:\\Users\\parth\\Desktop\\sample1.xml");
         

    }
}
