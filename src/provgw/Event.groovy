package provgw

class Event extends LegacyTable {

    public Event(Object name) {
        super('tb_cdh_sub_intfc');
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
    public void query(
        ENTR_NO='', 
        EVENT_CODE=''
        ) {
        sql.eachRow("select * from tb_cdh_sub_intfc where ENTR_NO=$ENTR_NO and EVENT_CODE=$EVENT_CODE") {
            println """tb_cdh_sub_intfc:
                ENTRO_NO is $it.ENTR_NO, 
                EVENT_CODE is $it.EVENT_CODE, 
                EVENTSTATUS is $it.EVENTSTATUS"""}
    }

    public getStatus(
        ENTR_NO='',
        EVENT_CODE=''
        ) {
        return sql.firstRow("select EVENTSTATUS from tb_cdh_sub_intfc where ENTR_NO=$ENTR_NO and EVENT_CODE=$EVENT_CODE order by EVENT_TIME desc limit 1").EVENTSTATUS
    }
    
        
    @Override
    public void queryAll(Object args) {
        sql.eachRow("select * from tb_cdh_sub_intfc") {
            println """tb_cdh_sub_intfc:
                ENTRO_NO is $it.ENTR_NO, 
                EVENT_CODE is $it.EVENT_CODE, 
                EVENTSTATUS is $it.EVENTSTATUS"""}
    }

    static main(args) {
        def event = new Event()
        //event.clear()
        //event.queryAll(this)
        println event.getStatus('663011186399', 'ADDDEV')
    }

}
