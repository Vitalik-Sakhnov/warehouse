package simbirsoft.internship.warehouse.entities;

public enum Permission {
    PRODUCT_GROUP_READ("productGroup:read"),
    PRODUCT_GROUP_WRITE("productGroup:write"),
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),
    CONSUMPTION_READ("consumption:read"),
    CONSUMPTION_WRITE("consumption:write"),
    STORE_READ("store:read"),
    STORE_WRITE("store:write"),
    SUPPLY_READ("supply:read"),
    SUPPLY_WRITE("supply:write"),
    WAREHOUSE_READ("warehouse:read"),
    WAREHOUSE_WRITE("warehouse:write"),
    WRITE_OFF_READ("writeOff:read"),
    WRITE_OFF_WRITE("writeOff:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
