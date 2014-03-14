package provgw

class Sub extends LegacyTable {

    public Sub(Object name) {
        super("TB_SB_SVC_BY_ENTR");
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        SVC_CD='LPZ0001204',
        ENTR_SVC_SEQNO=6609470009,
        SVC_END_DTTM='9999-12-31 23:59:59',
        SVC_FRST_STRT_DTTM='2013-11-04 16:13:53',
        SVC_STRT_DTTM='2013-11-04 16:13:53',
        RTNG_STRT_DTTM='2013-11-04 16:13:53',
        SVC_KD_CD='P',
        SVC_STTS_CD='A'
        ) {
        Date date = new Date()
        def seqNo = date.getTime()/100
        sql.execute("""insert into TB_SB_SVC_BY_ENTR
            (ENTR_NO, ENTR_SVC_SEQNO, SVC_CD, SVC_KD_CD, SVC_STTS_CD, SVC_FRST_STRT_DTTM, SVC_STRT_DTTM, RTNG_STRT_DTTM, SVC_END_DTTM) 
                        values 
            ($ENTR_NO, $seqNo, $SVC_CD, $SVC_KD_CD, $SVC_STTS_CD, $SVC_FRST_STRT_DTTM, SVC_STRT_DTTM, $RTNG_STRT_DTTM, $SVC_END_DTTM)""")
    }

    @Override
    public void update(
        ENTR_NO='',
        SVC_END_DTTM=''
        ) {
        sql.execute("""update TB_SB_SVC_BY_ENTR set 
        SVC_END_DTTM=$SVC_END_DTTM 
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from TB_SB_SVC_BY_ENTR where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from TB_SB_SVC_BY_ENTR where ENTR_NO=$ENTR_NO") {println "ENTRO_NO is $it.ENTR_NO, SVC_CD is $it.SVC_CD, SVC_END_DTTM is $it.SVC_END_DTTM, SVC_FRST_STRT_DTTM is $it.SVC_FRST_STRT_DTTM, RTNG_STRT_DTTM is $it.RTNG_STRT_DTTM"}
    }

    @Override
    public void queryAll(args) {
        //println "select * from ${this.name}"
        sql.eachRow('select * from TB_SB_SVC_BY_ENTR') {println "ENTRO_NO is $it.ENTR_NO, SVC_CD is $it.SVC_CD, SVC_END_DTTM is $it.SVC_END_DTTM, SVC_FRST_STRT_DTTM is $it.SVC_FRST_STRT_DTTM, RTNG_STRT_DTTM is $it.RTNG_STRT_DTTM"}
        //sql.eachRow("select * from ${this.name}") {println "ENTRO_NO is $it.ENTR_NO, SVC_CD is $it.SVC_CD, SVC_FRST_STRT_DTTM is $it.SVC_FRST_STRT_DTTM, RTNG_STRT_DTTM is $it.RTNG_STRT_DTTM, SVC_END_DTTM is $it.SVC_END_DTTM"}
        
    }

    static main(args) {
        def sub = new Sub()
        sub.delete('500011186399')
        sub.queryAll();
        sub.add('500011186399', 'LPZ0001204');
        sub.query('500011186399');
        sub.update('500011186399', '2014-08-31 23:59:59');
        sub.queryAll();
    }

}
