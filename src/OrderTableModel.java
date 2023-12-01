import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class OrderTableModel extends AbstractTableModel {

    private List<Order> orderList = new ArrayList<Order>();
    private String[] columnNames = {"OrderDate", "Region", "Rep1", "Rep2", "Item", "Units", "Unit Cost", "Total Cost"};

    public OrderTableModel() {}

    public OrderTableModel(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public int getRowCount() {
        return orderList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object orderAttribute = null;
        Order order = orderList.get(row);
        switch(column) {
            case 0: orderAttribute = order.getOrderDate(); break;
            case 1: orderAttribute = order.getRegion(); break;
            case 2: orderAttribute = order.getRep1(); break;
            case 3: orderAttribute = order.getRep2(); break;
            case 4: orderAttribute = order.getItem(); break;
            case 5: orderAttribute = order.getUnits(); break;
            case 6: orderAttribute = order.getUnitCost(); break;
            case 7: orderAttribute = order.getTotalCost(); break;
            default: break;
        }
        return orderAttribute;
    }
    public void addOrder(Order order) {
        orderList.add(order);
        fireTableDataChanged();
    }
}