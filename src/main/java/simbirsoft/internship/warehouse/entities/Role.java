package simbirsoft.internship.warehouse.entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(
            Permission.PRODUCT_GROUP_READ,
            Permission.CONSUMPTION_READ,
            Permission.ORDER_READ,
            Permission.STORE_READ,
            Permission.SUPPLY_READ,
            Permission.WAREHOUSE_READ,
            Permission.WRITE_OFF_READ,
            Permission.PRODUCT_READ
    )),
    ADMIN(Set.of(
            Permission.PRODUCT_GROUP_READ, Permission.PRODUCT_GROUP_WRITE,
            Permission.CONSUMPTION_READ, Permission.CONSUMPTION_WRITE,
            Permission.ORDER_READ, Permission.ORDER_WRITE,
            Permission.STORE_READ, Permission.STORE_WRITE,
            Permission.SUPPLY_READ, Permission.SUPPLY_WRITE,
            Permission.WAREHOUSE_READ, Permission.WAREHOUSE_WRITE,
            Permission.WRITE_OFF_READ, Permission.WRITE_OFF_WRITE,
            Permission.PRODUCT_READ, Permission.PRODUCT_WRITE
    ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
