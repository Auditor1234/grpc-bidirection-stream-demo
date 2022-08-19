package com.li.client;

import java.util.List;

public class Client {
    private ClientServices clientServices;
    
    public Client(){
        this.clientServices = new ClientServices();
    }

    public static void main(String[] args) {
        Client client = new Client();
        List<String> strings = client.manyToMany();
        System.out.println("---------------------");
        for(String str : strings){
            System.out.println(str);
        }
    }

    public List<String> manyToMany(){
        return this.clientServices.manyToMany("你好", 12);
    }

}
