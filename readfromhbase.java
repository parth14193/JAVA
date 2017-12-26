/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import com.google.protobuf.ServiceException;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.util.Bytes;
/**
 *
 * @author parth
 */
public class readfromhbase {
    public static void main(String[] args) throws IOException, ZooKeeperConnectionException, ServiceException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "172.16.8.191");
        config.set("hbase.master", "172.16.8.191:60000");
        config.set("hbase.zookeeper.property.clientport", "2181");
        HBaseAdmin.checkHBaseAvailable(config);
        HBaseAdmin admin = null;
        
        admin = new HBaseAdmin(config);
     //   NamespaceDescriptor nm =  NamespaceDescriptor.create("testspace").build();
      //  admin.createNamespace(nm);
      TableName[] tbls = admin.listTableNamesByNamespace("tenant8");
       for(int i=0;i<tbls.length;i++)
        {
        System.out.println(tbls[i].getNameAsString());
        }
       
       // HTableDescriptor[] tt = admin.listTables();
      //  System.out.println(tt);
        

    }
}
