package provgw

class Agnt extends LegacyTable {

    public Agnt(Object name) {
        super('TB_SB_ENTR_AGNT');
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        AGNT_CUST_NO='010089381788',
        REP_AGNT_YN='Y',
        AGNT_VALD_END_DT='9999-12-31 00:00:00',
        AGNT_VALD_STRT_DT='2011-05-09 00:00:00',
        AGNT_SEQNO='1118639900',
        AGNT_KD_CD='DSA'
        ) {
        sql.execute("""insert into TB_SB_ENTR_AGNT
            (ENTR_NO, AGNT_SEQNO, AGNT_KD_CD, AGNT_CUST_NO, AGNT_VALD_STRT_DT, AGNT_VALD_END_DT, REP_AGNT_YN) 
                        values 
            ($ENTR_NO, $AGNT_SEQNO, $AGNT_KD_CD, $AGNT_CUST_NO, $AGNT_VALD_STRT_DT, $AGNT_VALD_END_DT, $REP_AGNT_YN)""")
    }

    @Override
    public void update(
        ENTR_NO='',
        AGNT_CUST_NO='',
        REP_AGNT_YN='',
        AGNT_VALD_END_DT='',
        AGNT_VALD_STRT_DT='2011-05-09 00:00:00',
        AGNT_SEQNO='1118639900',
        AGNT_KD_CD='DSA'
        ) {
        sql.execute("""update TB_SB_ENTR_AGNT set
        AGNT_CUST_NO=$AGNT_CUST_NO, 
        REP_AGNT_YN=$REP_AGNT_YN, 
        AGNT_VALD_END_DT=$AGNT_VALD_END_DT, 
        AGNT_VALD_STRT_DT=$AGNT_VALD_STRT_DT,
        AGNT_SEQNO=$AGNT_SEQNO,
        AGNT_KD_CD=$AGNT_KD_CD
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from TB_SB_ENTR_AGNT where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from TB_SB_ENTR_AGNT where ENTR_NO=$ENTR_NO") {
            println """TB_SB_ENTR_AGNT:
                ENTRO_NO is $it.ENTR_NO, 
                AGNT_CUST_NO is $it.AGNT_CUST_NO, 
                REP_AGNT_YN is $it.REP_AGNT_YN, 
                AGNT_VALD_END_DT is $it.AGNT_VALD_END_DT,
                AGNT_VALD_STRT_DT is $it.AGNT_VALD_STRT_DT, 
                AGNT_SEQNO is $it.AGNT_SEQNO,
                AGNT_KD_CD is $it.AGNT_KD_CD"""}
    }

    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from TB_SB_ENTR_AGNT") {
            println """TB_SB_ENTR_AGNT:
                ENTRO_NO is $it.ENTR_NO, 
                AGNT_CUST_NO is $it.AGNT_CUST_NO, 
                REP_AGNT_YN is $it.REP_AGNT_YN, 
                AGNT_VALD_END_DT is $it.AGNT_VALD_END_DT,
                AGNT_VALD_STRT_DT is $it.AGNT_VALD_STRT_DT, 
                AGNT_SEQNO is $it.AGNT_SEQNO,
                AGNT_KD_CD is $it.AGNT_KD_CD"""}
    }

    static main(args) {
        def agnt = new Agnt()
        agnt.delete('500011186399')
        agnt.queryAll();
        agnt.add('500011186399');
        agnt.query('500011186399');
        agnt.update('500011186399', '010089381789', 'N', '2014-08-31 23:59:59');
        agnt.queryAll();

    }

}
