import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy {
    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {
       return warehouseList.getFirst();
    }
}
