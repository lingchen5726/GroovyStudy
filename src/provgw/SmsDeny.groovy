package provgw

class SmsDeny extends LegacyTable {

    public SmsDeny(Object name) {
        super('TB_SB_RMND_FOC_SMS_DENY');
    }

    @Override
    public void add(
        ENTR_NO='500011186399',
        VALD_STRT_DTTM='2011-05-09 00:00:00',
        VALD_END_DTTM='9999-12-31 00:00:00',
        DL_SERVICE_CODE='DL_SERVICE_CODE',
        DL_UPDATE_STAMP=1111
        ) {
        sql.execute("""insert into TB_SB_RMND_FOC_SMS_DENY
            (ENTR_NO, VALD_STRT_DTTM, VALD_END_DTTM, DL_SERVICE_CODE, DL_UPDATE_STAMP) 
                        values 
            ($ENTR_NO, $VALD_STRT_DTTM, $VALD_END_DTTM, $DL_SERVICE_CODE, $DL_UPDATE_STAMP)""")
    }

    @Override
    public void update(
        ENTR_NO='500011186399',
        VALD_STRT_DTTM='2011-05-09 00:00:00',
        VALD_END_DTTM='9999-12-31 00:00:00',
        DL_SERVICE_CODE='DL_SERVICE_CODE',
        DL_UPDATE_STAMP=1111
        ) {
        sql.execute("""update TB_SB_RMND_FOC_SMS_DENY set
        VALD_STRT_DTTM=$VALD_STRT_DTTM, 
        VALD_END_DTTM=$VALD_END_DTTM, 
        DL_SERVICE_CODE=$DL_SERVICE_CODE, 
        DL_UPDATE_STAMP=$DL_UPDATE_STAMP
        where ENTR_NO=$ENTR_NO""")
    }

    @Override
    public void delete(ENTR_NO) {
        sql.execute("delete from TB_SB_RMND_FOC_SMS_DENY where ENTR_NO=$ENTR_NO")
    }

    @Override
    public void query(ENTR_NO) {
        sql.eachRow("select * from TB_SB_RMND_FOC_SMS_DENY where ENTR_NO=$ENTR_NO") {
            println """TB_SB_RMND_FOC_SMS_DENY:
                ENTRO_NO is $it.ENTR_NO, 
                VALD_STRT_DTTM is $it.VALD_STRT_DTTM, 
                VALD_END_DTTM is $it.VALD_END_DTTM, 
                DL_SERVICE_CODE is $it.DL_SERVICE_CODE, 
                DL_UPDATE_STAMP is $it.DL_UPDATE_STAMP"""}
    }

    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from TB_SB_RMND_FOC_SMS_DENY") {
            println """TB_SB_RMND_FOC_SMS_DENY:
                ENTRO_NO is $it.ENTR_NO, 
                VALD_STRT_DTTM is $it.VALD_STRT_DTTM, 
                VALD_END_DTTM is $it.VALD_END_DTTM, 
                DL_SERVICE_CODE is $it.DL_SERVICE_CODE, 
                DL_UPDATE_STAMP is $it.DL_UPDATE_STAMP"""}
    }

    static main(args) {
        def smsdeny = new SmsDeny()
        smsdeny.delete('500011186399')
        smsdeny.queryAll();
        smsdeny.add('500011186399');
        smsdeny.query('500011186399');
        smsdeny.update('500011186399', '2011-05-09 00:00:00', '2014-08-31 23:59:59');
        smsdeny.queryAll();

    }

}
