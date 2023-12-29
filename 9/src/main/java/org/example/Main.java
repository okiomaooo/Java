package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Butterfly butterfly = new Butterfly("бабочка1", 1, "456", Butterfly.Color.ORANGE, new Date(2004-1900,5,26));
        Butterfly butterfly2 = new Butterfly("бабочка2", 2, "100", Butterfly.Color.BLACK, new Date(2015-1900,10,5));
        Butterfly butterfly3 = new Butterfly("бабочка3", 3, "201", Butterfly.Color.WHITE, new Date(2005-1900,6,12));
        Requests.createTable(butterfly);
        Requests.insertIntoTable(butterfly);
        Requests.insertIntoTable(butterfly2);
        Requests.insertIntoTable(butterfly3);
    }
}