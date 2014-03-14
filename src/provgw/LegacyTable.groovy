package provgw;

public abstract class LegacyTable {
    protected String name
    protected static sql
    
    LegacyTable(name) {
        this.name = name
        this.sql = ProvGWMySQL.getSql()
    }
    
    public String getName() {
        return this.name
    }
    
    abstract void add(args)
    abstract void update(args)
    abstract void delete(args)
    abstract void query(args)
    abstract void queryAll(args)

}
