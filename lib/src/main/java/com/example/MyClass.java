package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;
import org.junit.Test;

public class MyClass {
    //生成类的绝对路径
    private  static  final  String GEN_TARGET="D:\\PROJECT\\AutoTask\\istudy\\src\\main\\java";

    //创建数据库的版本
    private  static  final  int DATABASE_VERSION=1;
    //bean 放置的路径
    private  static  final  String DATABASE_BEAN_TARGET="com.yf.istudy.greenBean";
    //dao 放置的路径
    private  static  final  String DATABASE_DAO_TARGET="com.yf.istudy.greenDao";

    //创建的表名称
    private  static  final  String TABLE_USER="user";

    private  static  final  String USERNAME="userName";

    private  static  final  String PASSWORD="password";


    public  static  void main(String args[]){
        Schema schema=new Schema(DATABASE_VERSION,DATABASE_BEAN_TARGET);
        schema.setDefaultJavaPackageDao(DATABASE_DAO_TARGET);
        addNote_User(schema);
        try {
            new DaoGenerator().generateAll(schema,GEN_TARGET);
            System.out.print("create success");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.print("create error");
        }
    }

    private static void addNote_User(Schema schema) {
        Entity entity = schema.addEntity(TABLE_USER);
        entity.addIdProperty().notNull().primaryKey().autoincrement();
        entity.addStringProperty(USERNAME);
        entity.addStringProperty(PASSWORD);
    }


}
