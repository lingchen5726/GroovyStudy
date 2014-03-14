package provgw

class Wlit extends LegacyTable {

    public Wlit(Object name) {
        super('TB_SB_WLIT_ISOL_TRGT_CUST');
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        SMS_RCP_TELNO='010089381788',
        WLIT_SEQNO='1118639900',
        SMS_YN='Y',
        WLIT_ISOL_END_DT='9999-12-31 00:00:00',
        VALD_STRT_DT='2011-05-09 00:00:00',
        WLIT_ISOL_DV_CD='Y'
        ) {
        sql.execute("""insert into TB_SB_WLIT_ISOL_TRGT_CUST
            (ENTR_NO, SMS_RCP_TELNO, WLIT_SEQNO, SMS_YN, WLIT_ISOL_END_DT, VALD_STRT_DT, WLIT_ISOL_DV_CD) 
                        values 
            ($ENTR_NO, $SMS_RCP_TELNO, $WLIT_SEQNO, $SMS_YN, $WLIT_ISOL_END_DT, $VALD_STRT_DT, $WLIT_ISOL_DV_CD)""")
    }

    @Override
    public void update(
        ENTR_NO='',
        SMS_RCP_TELNO='',
        SMS_YN='',
        WLIT_ISOL_DV_CD='',
        WLIT_SEQNO='1118639900',
        WLIT_ISOL_END_DT='9999-12-31 00:00:00',
        VALD_STRT_DT='2011-05-09 00:00:00'
        ) {
        sql.execute("""update TB_SB_WLIT_ISOL_TRGT_CUST set
        SMS_RCP_TELNO=$SMS_RCP_TELNO, 
        WLIT_SEQNO=$WLIT_SEQNO, 
        SMS_YN=$SMS_YN, 
        WLIT_ISOL_END_DT=$WLIT_ISOL_END_DT,
        VALD_STRT_DT=$VALD_STRT_DT,
        WLIT_ISOL_DV_CD=$WLIT_ISOL_DV_CD
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from TB_SB_WLIT_ISOL_TRGT_CUST where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from TB_SB_WLIT_ISOL_TRGT_CUST where ENTR_NO=$ENTR_NO") {
            println """TB_SB_WLIT_ISOL_TRGT_CUST:
                ENTRO_NO is $it.ENTR_NO, 
                SMS_RCP_TELNO is $it.SMS_RCP_TELNO, 
                SMS_YN is $it.SMS_YN, 
                WLIT_ISOL_DV_CD is $it.WLIT_ISOL_DV_CD,
                WLIT_SEQNO is $it.WLIT_SEQNO, 
                WLIT_ISOL_END_DT is $it.WLIT_ISOL_END_DT,
                VALD_STRT_DT is $it.VALD_STRT_DT"""}
    }

    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from TB_SB_WLIT_ISOL_TRGT_CUST") {
            println """TB_SB_WLIT_ISOL_TRGT_CUST:
                ENTRO_NO is $it.ENTR_NO, 
                SMS_RCP_TELNO is $it.SMS_RCP_TELNO, 
                SMS_YN is $it.SMS_YN, 
                WLIT_ISOL_DV_CD is $it.WLIT_ISOL_DV_CD,
                WLIT_SEQNO is $it.WLIT_SEQNO, 
                WLIT_ISOL_END_DT is $it.WLIT_ISOL_END_DT,
                VALD_STRT_DT is $it.VALD_STRT_DT"""}
    }

    static main(args) {
        def wlit = new Wlit()
        wlit.delete('500011186399')
        wlit.queryAll();
        wlit.add('500011186399');
        wlit.query('500011186399');
        wlit.update('500011186399', '010089381789', 'N', 'N');
        wlit.queryAll();
    }

}
