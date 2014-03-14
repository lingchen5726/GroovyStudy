package provgw
import groovy.sql.Sql

class ProvGWMySQL {
    private static sql = null;
     
    private ProvGWMySQL() {
    }
    
    public static Sql getSql() {
        if (null==this.sql) {
            this.sql =Sql.newInstance(ProvGWConstants.dataSource, ProvGWConstants.username, ProvGWConstants.passwd, ProvGWConstants.driver)
        } else {
            return this.sql
        }
    }
    
    public static void main(args) {
        def sql = ProvGWMySQL.getSql();
        sql.eachRow("select * from tb_sb_entr_hist") {println "ENTRO_NO is $it.ENTR_NO, PROD_NO is $it.PROD_NO, IMSI_NO is $it.IMSI_NO"}
    }
}
