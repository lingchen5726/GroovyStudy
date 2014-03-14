package provgw

class VtNo extends LegacyTable {

    public VtNo(Object name) {
        super('TB_SB_VT_NO');
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        IMSI='450061089381788',
        VT_NO='010055525455',
        VALD_STRT_DT='2011-05-09 00:00:00',
        VALD_END_DT='9999-12-31 00:00:00',
        VT_NO_SEQNO=7003627165,
        VT_NO_DV_CD=''
        ) {
        sql.execute("""insert into TB_SB_VT_NO 
            (ENTR_NO,VT_NO_SEQNO,VT_NO,VT_NO_DV_CD,VALD_STRT_DT,VALD_END_DT,IMSI) values 
            ($ENTR_NO,$VT_NO_SEQNO,$VT_NO,$VT_NO_DV_CD,$VALD_STRT_DT,$VALD_END_DT,$IMSI)""")
    }

    @Override
    public void update(
        ENTR_NO='',
        IMSI='',
        VT_NO='',
        VALD_STRT_DT='2011-05-09 00:00:00',
        VALD_END_DT='9999-12-31 00:00:00',
        VT_NO_SEQNO=7003627165,
        VT_NO_DV_CD=''
        ) {
        sql.execute("""update TB_SB_VT_NO set
        IMSI=$IMSI, 
        VT_NO=$VT_NO, 
        VALD_STRT_DT=$VALD_STRT_DT, 
        VALD_END_DT=$VALD_END_DT,
        VT_NO_SEQNO=$VT_NO_SEQNO,
        VT_NO_DV_CD=$VT_NO_DV_CD
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from TB_SB_VT_NO where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from TB_SB_VT_NO where ENTR_NO=$ENTR_NO") {
            println """TB_SB_LTE_ROAM_IMSI_HIST:
                ENTRO_NO is $it.ENTR_NO, 
                IMSI is $it.IMSI, 
                VT_NO is $it.VT_NO, 
                VALD_STRT_DT is $it.VALD_STRT_DT, 
                VALD_END_DT is $it.VALD_END_DT,
                VT_NO_SEQNO is $it.VT_NO_SEQNO,
                VT_NO_DV_CD is $it.VT_NO_DV_CD"""}
    }

    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from TB_SB_VT_NO") {
            println """TB_SB_LTE_ROAM_IMSI_HIST:
                ENTRO_NO is $it.ENTR_NO, 
                IMSI is $it.IMSI, 
                VT_NO is $it.VT_NO, 
                VALD_STRT_DT is $it.VALD_STRT_DT, 
                VALD_END_DT is $it.VALD_END_DT,
                VT_NO_SEQNO is $it.VT_NO_SEQNO,
                VT_NO_DV_CD is $it.VT_NO_DV_CD"""}
    }

    static main(args) {
        def vtNo = new VtNo()
        vtNo.delete('500011186399')
        vtNo.queryAll();
        vtNo.add('500011186399', '450061089381788', '010055525455');
        vtNo.query('500011186399');
        vtNo.update('500011186399', '450061089381789', '010055525456', '2011-05-10 00:00:00', '2014-08-31 23:59:59');
        vtNo.queryAll();
    }

}
