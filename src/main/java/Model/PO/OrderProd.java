package Model.PO;

public class OrderProd {
    private String id;

    private String orderId;

    private String prodId;

    private Integer amount;

    public OrderProd(String id, String orderId, String prodId, Integer amount) {
        this.id = id;
        this.orderId = orderId;
        this.prodId = prodId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}