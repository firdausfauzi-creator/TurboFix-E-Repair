
package Class;

public class Sparepart 
{
    private int sparepart_id, repair_id, sparepartprice;
    private String sparepartname;

    public Sparepart(int sparepart_id, int repair_id, int sparepartprice, String sparepartname) {
        this.sparepart_id = sparepart_id;
        this.repair_id = repair_id;
        this.sparepartprice = sparepartprice;
        this.sparepartname = sparepartname;
    }

    public Sparepart() {
    }

    public int getSparepart_id() {
        return sparepart_id;
    }

    public int getRepair_id() {
        return repair_id;
    }

    public int getSparepartprice() {
        return sparepartprice;
    }

    public String getSparepartname() {
        return sparepartname;
    }

    public void setSparepart_id(int sparepart_id) {
        this.sparepart_id = sparepart_id;
    }

    public void setRepair_id(int repair_id) {
        this.repair_id = repair_id;
    }

    public void setSparepartprice(int sparepartprice) {
        this.sparepartprice = sparepartprice;
    }

    public void setSparepartname(String sparepartname) {
        this.sparepartname = sparepartname;
    }
    
    
}
