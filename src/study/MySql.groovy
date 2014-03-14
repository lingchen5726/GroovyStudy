package study
import groovy.sql.Sql

class MySql {

    def static sql =Sql.newInstance("jdbc:mysql://localhost:3306/snap_cdh1", "root", "ylxz", "com.mysql.jdbc.Driver")
    
    static main(args) {
        sql.eachRow("select * from tb_sb_entr_hist") {println "ENTRO_NO is ${it.ENTR_NO}"}
    }

}

