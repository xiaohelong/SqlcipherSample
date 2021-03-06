package com.gdpost.db.dao;
/*
 * @author:xiaohelong
 * @email:xiaohelong2005@gmail.com
 * @date:2013-11-06
 * @function:db operation abstraction class
 */

import com.gdpost.db.util.DeviceInfo;
import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
public abstract class DBBaseDAO extends SQLiteOpenHelper{        
        protected static String password="";
        protected static final int DB_VERSION = 1;
        protected static final String DB_NAME = "gdpostmap.db";
        protected static final String DB_PATH = "/sdcard/";
        public SQLiteDatabase getReadableDatabase() {
                // TODO Auto-generated method stub
                return super.getReadableDatabase(password);
        }

        public SQLiteDatabase getWritableDatabase() {
                // TODO Auto-generated method stub
                return super.getWritableDatabase(password);
        }
        
        public DBBaseDAO(Context context) {
                super(context, DB_PATH+DB_NAME, null,DB_VERSION);
            SQLiteDatabase.loadLibs(context);
                //password="123"; 
                password=DeviceInfo.getDeviceModel()+"_"+DeviceInfo.getDeviceId(context);//need get password first
                //password=DeviceInfo.getDeviceModel()+"_";//need get password first
                // TODO Auto-generated constructor stub
        }

        abstract protected Boolean createTable();        
        abstract protected Boolean dropTable();
}
