/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import java.util.regex.*;
/**
 *
 * @author parth
 */
public class regex {
    
    public static void main(String[] args) {
     Pattern p = Pattern.compile("(\\w+\\s+\\d+\\s+\\d+\\x3a\\d+\\x3a\\d+)\\s*(\\S*)\\s*(\\S*)\\x3a\\s*(\\w+\\s*\\S+)\\s*(\\S*)\\s*(\\S*)\\s*>(\\w*)\\s*(?:rule*\\x3a\\s*(\\d*)\\x3b\\s*|)(?:rule_uid\\x3a\\s*\\x7b(\\S*)\\x7d\\x3b\\s*|)(?:rule_name\\x3a\\s*([^;]*)\\x3b\\s*|)(?:service_id\\x3a\\s*(\\S*)\\x3b\\s*|)(?:ICMP:\\s*([^;]*)\\x3b\\s*|)(?:src\\x3a\\s*(\\S*)\\x3b\\s*|)(?:dst\\x3a\\s*(\\S*)\\x3b\\s*|)(?:proto\\x3a\\s*(\\S*)\\x3b\\s*|)(?:ICMP Type:\\s*(\\d*)\\x3b\\s*|)(?:ICMP Code:\\s*(\\d*)\\x3b\\s*|)(?:xlatedst\\x3a\\s*(\\S*)\\x3b\\s*|)(?:xlatesrc\\x3a\\s*(\\S*)\\x3b\\s*|)(?:NAT_rulenum\\x3a\\s*(\\d*)\\x3b\\s*|)(?:NAT_addtnl_rulenum\\x3a\\s*(\\d*)\\x3b\\s*|)(?:product\\x3a\\s*([^\\x3b]*)\\x3b\\s*|)(?:service\\x3a\\s*(\\d*)\\x3b\\s*|)(?:s_port\\x3a\\s*(\\d*)\\x3b\\s*|)(?:xlatesport\\x3a\\s*(\\S*)\\x3b\\s*|)");
     Matcher m = p.matcher("Sep 3 15:10:54 192.168.99.1 Checkpoint: 3Sep2007 15:10:28 accept 192.168.99.1 >eth2 rule: 9; rule_uid: {11111111-2222-3333-8A67-F54CED606693}; service_id: domain-udp; src: 103.26.128.84; dst: 103.26.128.84; proto: udp; product: VPN-1 & FireWall-1; service: 53; s_port: 32769;");
     boolean b  = m.matches();
     if (b==true)
     {
        for (int i = 0; i <= m.groupCount(); i++)
                System.out.println(m.group(i));
     }
     else 
     {
      System.out.println("ncapturing group are not matching");
     }
    }
}
