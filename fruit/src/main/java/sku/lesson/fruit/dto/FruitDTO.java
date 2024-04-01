package sku.lesson.fruit.dto;

public class FruitDTO {
    private Integer fruitId;
    private String fruitName;
    private Integer fruitPrice;
    private Integer fruitStock;

    public FruitDTO() {}

    public FruitDTO(Integer fruitId, String fruitName, Integer fruitPrice, Integer fruitStock) {
        super();
        this.fruitId=fruitId;
        this.fruitName=fruitName;
        this.fruitPrice=fruitPrice;
        this.fruitStock=fruitStock;
    }
    public Integer getFruitId() {
        return fruitId;
    }
    public void setFruitId(Integer fruitId) {
        this.fruitId = fruitId;
    }
    public String getFruitName() {
        return fruitName;
    }
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
    public Integer getFruitPrice() {
        return fruitPrice;
    }
    public void setFruitPrice(Integer fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
    public Integer getFruitStock() {
        return fruitStock;
    }
    public void setFruitStock(Integer fruitStock) {
        this.fruitStock = fruitStock;
    }

    public String toString() {
        return "FruitDTO [fruitId=" + getFruitId() + ", fruitName=" + getFruitName() + ", fruitPrice=" + getFruitPrice() + ", fruitStock=" + getFruitStock() + "]";
    }
}
