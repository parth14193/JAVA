/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import java.util.List;


public class amazone {
/**
 *    
 * @author parth
 */
             public static AmazonS3 amazonS3;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
                FileInputStream input = null;
                
                input = new FileInputStream("C:\\Users\\parth\\Documents\\NetBeansProjects\\amazone\\src\\main\\java\\com\\mycompany\\amazone\\aws.properties");
                prop.load(input);
                
                String s = prop.getProperty("AWS_ACCESS_KEY_ID");
                String y = prop.getProperty("AWS_SECRET_ACCESS_KEY");
                String z = prop.getProperty("bucket_name");
                System.out.println("\nAWS_ACCESS_KEY_ID::" +s + "\nAWS_SECRET_ACCESS_KEY::" + y + "\nbucket_name::" + z);
                
        AWSCredentials credentials = null;
          
            AWSCredentials awsCredentials = new BasicAWSCredentials(s, y);
                amazonS3 = new AmazonS3Client(awsCredentials);
                System.out.println(amazonS3);
                
                List<Bucket> buckets = amazonS3.listBuckets();
    
      
         ObjectListing listing = amazonS3.listObjects(new ListObjectsRequest().withBucketName(z));
         for (S3ObjectSummary objectSummary : listing.getObjectSummaries()) {
         System.out.println(" -> " + objectSummary.getKey() + "  " +
                  "(size = " + objectSummary.getSize()/1024 + " KB)");
         }
     
        }
}
