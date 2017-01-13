package Model.PO;

import java.sql.Timestamp;

public class SaleOrder {
    private String id;

    private Timestamp date;

    private String customerId;

    public SaleOrder(String id, Timestamp date, String customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }
}