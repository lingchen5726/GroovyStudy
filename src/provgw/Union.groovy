package provgw

class Union extends LegacyTable {

    public Union(Object name) {
        super('TB_SB_ENTR_SVC_UNION');
        // TODO Auto-generated constructor stub
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        TRGT_ENTR_NO='500089381788',
        SHARE_YN='Y',
        VALD_END_DT='9999-12-31 00:00:00',
        SVC_UNION_SEQNO=1100832158,
        SVC_UNION_TYPE='OPM',
        VALD_STRT_DT='2013-07-01 14:26:16'
        ) {
        sql.execute("""insert into TB_SB_ENTR_SVC_UNION
            (ENTR_NO, TRGT_ENTR_NO, SHARE_YN, VALD_END_DT, SVC_UNION_SEQNO, SVC_UNION_TYPE, VALD_STRT_DT) 
                        values 
            ($ENTR_NO, $TRGT_ENTR_NO, $SHARE_YN, $VALD_END_DT, $SVC_UNION_SEQNO, $SVC_UNION_TYPE, $VALD_STRT_DT)""")
    }

    @Override
    public void update(
        ENTR_NO='',
        TRGT_ENTR_NO='',
        SHARE_YN='',
        VALD_END_DT='',
        SVC_UNION_SEQNO=1100832158,
        SVC_UNION_TYPE='OPM',
        VALD_STRT_DT='2013-07-01 14:26:16'
        ) {
        sql.execute("""update TB_SB_ENTR_SVC_UNION set
        TRGT_ENTR_NO=$TRGT_ENTR_NO, 
        SHARE_YN=$SHARE_YN, 
        VALD_END_DT=$VALD_END_DT, 
        SVC_UNION_SEQNO=$SVC_UNION_SEQNO,
        SVC_UNION_TYPE=$SVC_UNION_TYPE,
        VALD_STRT_DT=$VALD_STRT_DT
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from TB_SB_ENTR_SVC_UNION where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from TB_SB_ENTR_SVC_UNION where ENTR_NO=$ENTR_NO") {
            println """TB_SB_ENTR_SVC_UNION:
                ENTRO_NO is $it.ENTR_NO, 
                TRGT_ENTR_NO is $it.TRGT_ENTR_NO, 
                SHARE_YN is $it.SHARE_YN, 
                VALD_END_DT is $it.VALD_END_DT,
                SVC_UNION_SEQNO is $it.SVC_UNION_SEQNO, 
                SVC_UNION_TYPE is $it.SVC_UNION_TYPE,
                VALD_STRT_DT is $it.VALD_STRT_DT"""}
    }

    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from TB_SB_ENTR_SVC_UNION") {
            println """TB_SB_ENTR_SVC_UNION:
                ENTRO_NO is $it.ENTR_NO, 
                TRGT_ENTR_NO is $it.TRGT_ENTR_NO, 
                SHARE_YN is $it.SHARE_YN, 
                VALD_END_DT is $it.VALD_END_DT,
                SVC_UNION_SEQNO is $it.SVC_UNION_SEQNO, 
                SVC_UNION_TYPE is $it.SVC_UNION_TYPE,
                VALD_STRT_DT is $it.VALD_STRT_DT"""}
    }

    static main(args) {
        def union = new Union()
        union.delete('500011186399')
        union.queryAll();
        union.add('500011186399', '500089381788', 'Y');
        union.query('500011186399');
        union.update('500011186399', '500089381788', 'N', '2014-08-31 23:59:59');
        union.queryAll();

    }

}
