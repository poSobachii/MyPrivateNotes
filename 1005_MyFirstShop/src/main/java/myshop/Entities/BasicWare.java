package myshop.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wares")
public class BasicWare {

    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "waretype")
    private String wareType;

    @Column(name = "warename")
    private String wareName;

    @Column(name = "imgcode")
    private String imgSource;

    @Column(name = "price")
    private Double warePrice;

    @Column(name = "qty")
    private int priceQuantity;

    @Column(name = "info")
    private String wareInfo;


    public BasicWare() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWareType() {
        return wareType;
    }

    public void setWareType(String wareType) {
        this.wareType = wareType;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public Double getWarePrice() {
        return warePrice;
    }

    public void setWarePrice(Double warePrice) {
        this.warePrice = warePrice;
    }

    public int getPriceQuantity() {
        return priceQuantity;
    }

    public void setPriceQuantity(int priceQuantity) {
        this.priceQuantity = priceQuantity;
    }

    public String getWareInfo() {
        return wareInfo;
    }

    public void setWareInfo(String wareInfo) {
        this.wareInfo = wareInfo;
    }
}