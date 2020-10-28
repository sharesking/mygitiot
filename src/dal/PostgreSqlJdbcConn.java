package dal;


import java.sql.*;

public class PostgreSqlJdbcConn {
    private String dbDriver = "org.postgresql.Driver";
    private String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    private String dbUser = "postgres";
    private String dbPwd = "123456";
    private Connection conn = null;
    public Connection getConnection() {//完成Mysql数据库驱动的加载后进行数据库连接
        try {
            Class.forName(dbDriver);
            conn = DriverManager
                    .getConnection(dbUrl,
                            dbUser, dbPwd);
            System.out.println("连接数据库成功！");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public ResultSet doQurey(String sql) {//实现查询操作
        ResultSet rs = null;
        conn = this.getConnection();
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public int doUpdate(String sql) {//实现更新操作
        int res = 0;
        conn = this.getConnection();
        try {
            Statement stmt = conn.createStatement();
            res = stmt.executeUpdate(sql);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public void close() throws SQLException{
        try {
            conn.close();//关闭相关对象，释放内存
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}