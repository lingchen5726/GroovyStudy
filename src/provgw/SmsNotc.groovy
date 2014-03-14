package provgw

class SmsNotc extends LegacyTable {

    public SmsNotc(Object name) {
        super('TB_SB_LTE_RMND_SMS_NOTC');
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        PROD_NO='010089381788',
        STRT_DTTM='2011-05-09 00:00:00',
        CHNG_DTTM='9999-12-31 00:00:00'
        ) {
        sql.execute("""insert into TB_SB_LTE_RMND_SMS_NOTC
            (ENTR_NO, PROD_NO, STRT_DTTM, CHNG_DTTM) 
                        values 
            ($ENTR_NO, $PROD_NO, $STRT_DTTM, $CHNG_DTTM)""")
    }

    @Override
    public void update(
        ENTR_NO='',
        PROD_NO='',
        STRT_DTTM='2011-05-09 00:00:00',
        CHNG_DTTM='9999-12-31 00:00:00'
        ) {
        sql.execute("""update TB_SB_LTE_RMND_SMS_NOTC set
        PROD_NO=$PROD_NO, 
        STRT_DTTM=$STRT_DTTM, 
        CHNG_DTTM=$CHNG_DTTM
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from TB_SB_LTE_RMND_SMS_NOTC where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from TB_SB_LTE_RMND_SMS_NOTC where ENTR_NO=$ENTR_NO") {
            println """TB_SB_LTE_RMND_SMS_NOTC:
                ENTRO_NO is $it.ENTR_NO, 
                PROD_NO is $it.PROD_NO, 
                STRT_DTTM is $it.STRT_DTTM, 
                CHNG_DTTM is $it.CHNG_DTTM"""}
    }

    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from TB_SB_LTE_RMND_SMS_NOTC") {
            println """TB_SB_LTE_RMND_SMS_NOTC:
                ENTRO_NO is $it.ENTR_NO, 
                PROD_NO is $it.PROD_NO, 
                STRT_DTTM is $it.STRT_DTTM, 
                CHNG_DTTM is $it.CHNG_DTTM"""}
    }

    static main(args) {
        def smsNotc = new SmsNotc()
        smsNotc.delete('500011186399')
        smsNotc.queryAll();
        smsNotc.add('500011186399');
        smsNotc.query('500011186399');
        smsNotc.update('500011186399', '010089381789', '2014-01-01 00:00:00', '2014-08-31 23:59:59');
        smsNotc.queryAll();
    }

}
