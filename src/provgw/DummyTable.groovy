package provgw

class DummyTable extends LegacyTable {

    public DummyTable(Object name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public clear(ENTR_NO) {
        sql.execute("delete from tb_sb_entr_hist where ENTR_NO=${ENTR_NO}")
        sql.execute("delete from TB_SB_SVC_BY_ENTR where ENTR_NO=${ENTR_NO}")
        sql.execute("delete from TB_SB_LTE_ROAM_IMSI_HIST where ENTR_NO=${ENTR_NO}")
        sql.execute("delete from TB_SB_VT_NO where ENTR_NO=${ENTR_NO}")
        sql.execute("delete from TB_SB_RMND_FOC_SMS_DENY where ENTR_NO=${ENTR_NO}")
        sql.execute("delete from TB_SB_WLIT_ISOL_TRGT_CUST where ENTR_NO=${ENTR_NO}")
        sql.execute("delete from TB_SB_LTE_RMND_SMS_NOTC where ENTR_NO=${ENTR_NO}")
        sql.execute("delete from TB_SB_ENTR_AGNT where ENTR_NO=${ENTR_NO}")
        sql.execute("delete from TB_SB_ENTR_SVC_UNION where ENTR_NO=${ENTR_NO}")
        /*Delete all events*/
        sql.execute("delete from tb_cdh_sub_intfc where ENTR_NO=${ENTR_NO}")
    }

    @Override
    public void add(Object args) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Object args) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Object args) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void query(Object args) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void queryAll(Object args) {
        // TODO Auto-generated method stub
        
    }

    static main(args) {
        def dt = new DummyTable()
        dt.clear('660011186399');
    }

}
