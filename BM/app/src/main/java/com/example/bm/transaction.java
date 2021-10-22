package com.example.bm;

public class transaction {
    private String id;
    private String description;
    private String price;
    private String category;


    public transaction() {
    }

    public transaction(String id, String description, String price, String category) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public boolean validatePrice(String price)
    {
        try {
            double p = Double.parseDouble(price);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    public boolean checkNull()
    {
        if(this.id ==null || this.category==null || this.description==null || this.price==null)
            return true;
        else
            return false;
    }
}

