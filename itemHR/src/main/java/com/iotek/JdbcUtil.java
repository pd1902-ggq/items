package com.iotek;


import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/lesson0716";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static Connection connection = null;

    static {
        try {
            Class.forName(DRIVE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Statement statement, Connection connection) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean doUpdate(String sql, Object... parms) {
        if (sql == null) return false;
        connection = getConn();
        try {
            ps = connection.prepareStatement(sql);
            if (parms != null && parms.length != 0) {
                for (int i = 0; i < parms.length; i++) {
                    ps.setObject(i + 1, parms[i]);
                }
            }
            int row = ps.executeUpdate();
            if (row != 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(ps, connection);
        }
        return false;
    }

    //查询返回结果
    public static <T> List<T> doQuery(String sql, Class<T> clazz, Object... objects) {
        if (sql == null || clazz == null) return null;
        connection = getConn();
        try {
            ps = connection.prepareStatement(sql);
            if (objects != null && objects.length != 0) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i + 1, objects[i]);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();//找到列的属性信息
            int columnCount = metaData.getColumnCount();//找到列的数量
            List<T> objList = new ArrayList<T>();
            while (rs.next()) {
                T obj = clazz.newInstance();//创建对象实例
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);//根据索引取出列的名称
                    Object columnValue = rs.getObject(columnName);//根据列名取出列值
                    Field field = clazz.getDeclaredField(columnName);//根据表中的列名获取类中的属性
                    field.setAccessible(true);
                    field.set(obj, columnValue);
                }
                objList.add(obj);
            }
            return objList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(rs, ps, connection);
        }
        return null;
    }

    //返回总记录数
    public static int getTotalRows(String sql,Object...objects){
        connection=getConn();
        try {
            ps=connection.prepareStatement(sql);
            if(objects!=null&&objects.length!=0){
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i+1,objects[i]);
                }
            }
            rs=ps.executeQuery();
            int rows=0;
            while (rs.next()){
                rows=rs.getInt(1);
            }
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            release(rs,ps,connection);
        }
        return 0;
    }
}

