/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import java.io.File;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import java.io.FileWriter;
import org.apache.solr.client.solrj.util.ClientUtils;


/*
 * @author parth
 */
public class solr {

    public static void main(String[] args) throws SolrServerException, IOException  {
    SolrServer client = new HttpSolrServer("http://172.16.8.191:8983/solr/tenant8-activity_1");
    SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setParam("wt", "csv"); 
        query.setStart(0);
        QueryResponse response = client.query(query);
        SolrDocumentList results = response.getResults();
        File file;
        file = new File("C:\\Users\\parth\\Desktop\\sample1.xml");
        FileWriter writer = new FileWriter(file);
        Object[] o = new Object[results.size()];
        o = results.toArray();
    
        for(int i=0; i < results.size();i++)
        {
            /*  System.out.println(o[i].toString());
              writer.write(o[i].toString() + "\n");  */
             String xml = ClientUtils.toXML(ClientUtils.toSolrInputDocument(results.get(i)));
             //System.out.println(xml);
             writer.write(xml);
                 
        }
        writer.flush();
        writer.close();
    }
}
