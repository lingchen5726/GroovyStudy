package provgw

class Dev extends LegacyTable {

    public Dev(Object name) {
        super('tb_sb_entr_hist');
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        PROD_NO='010089381739',
        IMSI_NO='450061089381739',
        ENTR_STTS_CHNG_DTTM='2013-09-03 17:08:04',
        BILL_ACNT_NO=461211232433,
        ACENO=300011737117,
        ENTR_STTS_CD='A',
        PROD_CD='LZP0000001',
        HLDR_CUST_NO=4005909069,
        MRKT_CD='LGT',
        ENTR_STTS_CHNG_RSN_DTL_CD='CR',
        FRST_ENTR_DTTM='2012-11-16 00:00:00',
        VALD_END_DTTM='9999-12-31 23:59:59'
        ) {
        sql.execute("""insert into tb_sb_entr_hist 
            (ENTR_NO, PROD_NO, IMSI_NO, ENTR_STTS_CHNG_DTTM, BILL_ACNT_NO, ACENO, ENTR_STTS_CD, PROD_CD, HLDR_CUST_NO, MRKT_CD, ENTR_STTS_CHNG_RSN_DTL_CD, FRST_ENTR_DTTM, VALD_END_DTTM) 
                        values 
            ($ENTR_NO, $PROD_NO, $IMSI_NO, $ENTR_STTS_CHNG_DTTM, $BILL_ACNT_NO, $ACENO, $ENTR_STTS_CD, $PROD_CD, $HLDR_CUST_NO, $MRKT_CD, $ENTR_STTS_CHNG_RSN_DTL_CD, $FRST_ENTR_DTTM, $VALD_END_DTTM)""");
    }

    @Override
    public void update(
        ENTR_NO='',
        PROD_NO='',
        IMSI_NO='',
        VALD_END_DTTM='',
        ENTR_STTS_CHNG_DTTM='2013-09-03 17:08:04'
        ) {
        sql.execute("""update tb_sb_entr_hist set 
        PROD_NO=$PROD_NO, 
        IMSI_NO=$IMSI_NO, 
        VALD_END_DTTM=$VALD_END_DTTM,
        ENTR_STTS_CHNG_DTTM=$ENTR_STTS_CHNG_DTTM
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from tb_sb_entr_hist where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from tb_sb_entr_hist where ENTR_NO=$ENTR_NO") {println """tb_sb_entr_hist:
            ENTRO_NO is $it.ENTR_NO, 
            PROD_NO is $it.PROD_NO, 
            IMSI_NO is $it.IMSI_NO, 
            VALD_END_DTTM is $it.VALD_END_DTTM"""}
    }

    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from tb_sb_entr_hist") {println """tb_sb_entr_hist:
            ENTRO_NO is $it.ENTR_NO, 
            PROD_NO is $it.PROD_NO, 
            IMSI_NO is $it.IMSI_NO, 
            VALD_END_DTTM is $it.VALD_END_DTTM"""}
    }

    static main(args) {
        def dev = new Dev()
        dev.delete('500011186399')
        dev.queryAll()
        dev.add('500011186399', '010089381739', '450061089381739')
        dev.query('500011186399')
        dev.update('500011186399', '010089381740', '450061089381740', '2014-08-31 23:59:59')
        dev.queryAll()
    }

}
