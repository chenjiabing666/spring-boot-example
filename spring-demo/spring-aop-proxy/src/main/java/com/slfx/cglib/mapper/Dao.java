package com.slfx.cglib.mapper;

public class Dao implements IDao{

    public void select() {
        System.out.println("select 1 from dual:");
        insert();
    }

    public void insert() {
        System.out.println("insert into ...");
    }

    public final void delete() {
        System.out.println("delete from ...");
    }
}
