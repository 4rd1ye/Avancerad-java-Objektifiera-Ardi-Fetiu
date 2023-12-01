public class Order {

    String A;
    String B;
    String C;
    String D;
    String E;
    String F;
    String G;
    String H;

    public Order(String orderDate, String region, String rep1, String rep2, String item, String units, String unitCost, String totalCost) {
        this.A = orderDate;
        this.B = region;
        this.C = rep1;
        this.D = rep2;
        this.E = item;
        this.F = units;
        this.G = unitCost;
        this.H = totalCost;
    }

    public String getOrderDate() {
        return A;
    }

    public void setOrderDate(String orderDate) {
        this.A = orderDate;
    }

    public String getRegion() {
        return B;
    }

    public void setRegion(String region) {
        this.B = region;
    }

    public String getRep1() {
        return C;
    }

    public void setRep1(String rep1) {
        this.C = rep1;
    }

    public String getRep2() {
        return D;
    }

    public void setRep2(String rep2) {
        this.D = rep2;
    }

    public String getItem() {
        return E;
    }

    public void setItem(String item) {
        this.E = item;
    }

    public String getUnits() {
        return F;
    }

    public void setUnits(String units) {
        this.F = units;
    }

    public String getUnitCost() {
        return G;
    }

    public void setUnitCost(String unitCost) {
        this.G = unitCost;
    }

    public String getTotalCost() {
        return H;
    }

    public void setTotalCost(String totalCost) {
        this.H = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + A +
                ", region='" + B + '\'' +
                ", rep1='" + C + '\'' +
                ", rep2='" + D + '\'' +
                ", item='" + E + '\'' +
                ", units=" + F +
                ", unitCost=" + G +
                ", totalCost=" + H +
                '}';
    }
}