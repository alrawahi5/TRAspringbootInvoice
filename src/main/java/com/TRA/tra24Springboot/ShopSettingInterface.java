package com.TRA.tra24Springboot;

public interface ShopSettingInterface {

    String getShopName();

    void setShopName(String shopName);

    String getInvoiceHeader();

    void setInvoiceHeader(String invoiceHeader);

    @Override
    String toString();


}
