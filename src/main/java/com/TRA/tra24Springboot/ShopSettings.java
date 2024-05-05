package com.TRA.tra24Springboot;

public class ShopSettings implements ShopSettingInterface {
    public String shopName;
    private String invoiceHeader;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    @Override
    public String toString() {
        return "ShopSettings{" +
                "shopName='" + shopName + '\'' +
                ", invoiceHeader='" + invoiceHeader + '\'' +
                '}';
    }
}
 