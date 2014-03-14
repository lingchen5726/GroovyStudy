package provgw

class RoamImsi extends LegacyTable {

    public RoamImsi(Object name) {
        super('TB_SB_LTE_ROAM_IMSI_HIST');
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        LTE_ROAM_IMSI='204043890462637',
        USE_STRT_DTTM='2012-07-09 18:47:24',
        USE_END_DTTM='9999-12-31 00:00:00',
        LTE_ROAM_IMSI_SEQNO=7905917,
        IMSI_STS_CD='AI',
        REAR_IMSI='RIM'
        ) {
        sql.execute("""insert into TB_SB_LTE_ROAM_IMSI_HIST
            (ENTR_NO, LTE_ROAM_IMSI, USE_STRT_DTTM, USE_END_DTTM, LTE_ROAM_IMSI_SEQNO, IMSI_STS_CD, REAR_IMSI) 
                        values 
            ($ENTR_NO, $LTE_ROAM_IMSI, $USE_STRT_DTTM, $USE_END_DTTM, $LTE_ROAM_IMSI_SEQNO, $IMSI_STS_CD, $REAR_IMSI)""")
    }

    @Override
    public void update(
        ENTR_NO='',
        LTE_ROAM_IMSI='',
        USE_STRT_DTTM='',
        USE_END_DTTM='',
        LTE_ROAM_IMSI_SEQNO=7905917,
        IMSI_STS_CD='AI',
        REAR_IMSI='RIM'
        ) {
        sql.execute("""update TB_SB_LTE_ROAM_IMSI_HIST set
        LTE_ROAM_IMSI=$LTE_ROAM_IMSI, 
        USE_STRT_DTTM=$USE_STRT_DTTM, 
        USE_END_DTTM=$USE_END_DTTM, 
        LTE_ROAM_IMSI_SEQNO=$LTE_ROAM_IMSI_SEQNO,
        IMSI_STS_CD=$IMSI_STS_CD,
        REAR_IMSI=$REAR_IMSI
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from TB_SB_LTE_ROAM_IMSI_HIST where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from TB_SB_LTE_ROAM_IMSI_HIST where ENTR_NO=$ENTR_NO") {
            println """TB_SB_LTE_ROAM_IMSI_HIST:
                ENTRO_NO is $it.ENTR_NO, 
                LTE_ROAM_IMSI is $it.LTE_ROAM_IMSI, 
                USE_STRT_DTTM is $it.USE_STRT_DTTM, 
                USE_END_DTTM is $it.USE_END_DTTM, 
                LTE_ROAM_IMSI_SEQNO is $it.LTE_ROAM_IMSI_SEQNO,
                IMSI_STS_CD is $it.IMSI_STS_CD,
                REAR_IMSI is $it.REAR_IMSI"""}
    }

    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from TB_SB_LTE_ROAM_IMSI_HIST") {
            println """TB_SB_LTE_ROAM_IMSI_HIST:
                ENTRO_NO is $it.ENTR_NO, 
                LTE_ROAM_IMSI is $it.LTE_ROAM_IMSI, 
                USE_STRT_DTTM is $it.USE_STRT_DTTM, 
                USE_END_DTTM is $it.USE_END_DTTM, 
                LTE_ROAM_IMSI_SEQNO is $it.LTE_ROAM_IMSI_SEQNO,
                IMSI_STS_CD is $it.IMSI_STS_CD,
                REAR_IMSI is $it.REAR_IMSI"""}
    }

    static main(args) {
        def roamImsi = new RoamImsi()
        roamImsi.delete('500011186399')
        roamImsi.queryAll();
        roamImsi.add('500011186399', '204043890462637');
        roamImsi.query('500011186399');
        roamImsi.update('500011186399', '204043890462638', '2012-07-09 18:47:24', '2014-08-31 23:59:59');
        roamImsi.queryAll();
    }

}
