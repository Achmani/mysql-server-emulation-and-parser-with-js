package id.mit.chrono.server.obj;

import org.jooq.Record;

public class FinalizerVendorData {

    public String vendorName;
    public int bscD;
    public int bscD1;
    public int rncD;
    public int rncD1;
    public int totalControllerD;
    public int totalControllerD1;
    public int btsD;
    public int btsD1;
    public int nodebD;
    public int nodebD1;
    public int enodebD;
    public int enodebD1;
    public int totalBtsD;
    public int totalBtsD1;
    public int cell2gD;
    public int cell2gD1;
    public int cell3gD;
    public int cell3gD1;
    public int cell4gD;
    public int cell4gD1;
    public int totalCellD;
    public int totalCellD1;

    public FinalizerVendorData(Record r) {

        this.vendorName = r.get("vendorName").toString();
        this.bscD = Integer.parseInt(r.get("bscD").toString());
        this.bscD1 = Integer.parseInt(r.get("bscD1").toString());
        this.rncD = Integer.parseInt(r.get("rncD").toString());
        this.rncD1 = Integer.parseInt(r.get("rncD1").toString());
        this.totalControllerD = Integer.parseInt(r.get("totalControllerD").toString());
        this.totalControllerD1 = Integer.parseInt(r.get("totalControllerD1").toString());
        this.btsD = Integer.parseInt(r.get("btsD").toString());
        this.btsD1 = Integer.parseInt(r.get("btsD1").toString());
        this.nodebD = Integer.parseInt(r.get("nodebD").toString());
        this.nodebD1 = Integer.parseInt(r.get("nodebD1").toString());
        this.enodebD = Integer.parseInt(r.get("enodebD").toString());
        this.enodebD1 = Integer.parseInt(r.get("enodebD1").toString());
        this.totalBtsD = Integer.parseInt(r.get("totalBtsD").toString());
        this.totalBtsD1 = Integer.parseInt(r.get("totalBtsD1").toString());
        this.cell2gD = Integer.parseInt(r.get("cell2gD").toString());
        this.cell2gD1 = Integer.parseInt(r.get("cell2gD1").toString());
        this.cell3gD = Integer.parseInt(r.get("cell3gD").toString());
        this.cell3gD1 = Integer.parseInt(r.get("cell3gD1").toString());
        this.cell4gD = Integer.parseInt(r.get("cell4gD").toString());
        this.cell4gD1 = Integer.parseInt(r.get("cell4gD1").toString());
        this.totalCellD = Integer.parseInt(r.get("totalCellD").toString());
        this.totalCellD1 = Integer.parseInt(r.get("totalCellD1").toString());
    }

    public String getVendorName() {
        return vendorName;
    }

    public int getBscD() {
        return bscD;
    }

    public int getBscD1() {
        return bscD1;
    }

    public int getRncD() {
        return rncD;
    }

    public int getRncD1() {
        return rncD1;
    }

    public int getTotalControllerD() {
        return totalControllerD;
    }

    public int getTotalControllerD1() {
        return totalControllerD1;
    }

    public int getBtsD() {
        return btsD;
    }

    public int getBtsD1() {
        return btsD1;
    }

    public int getNodebD() {
        return nodebD;
    }

    public int getNodebD1() {
        return nodebD1;
    }

    public int getEnodebD() {
        return enodebD;
    }

    public int getEnodebD1() {
        return enodebD1;
    }

    public int getTotalBtsD() {
        return totalBtsD;
    }

    public int getTotalBtsD1() {
        return totalBtsD1;
    }

    public int getCell2gD() {
        return cell2gD;
    }

    public int getCell2gD1() {
        return cell2gD1;
    }

    public int getCell3gD() {
        return cell3gD;
    }

    public int getCell3gD1() {
        return cell3gD1;
    }

    public int getCell4gD() {
        return cell4gD;
    }

    public int getCell4gD1() {
        return cell4gD1;
    }

    public int getTotalCellD() {
        return totalCellD;
    }

    public int getTotalCellD1() {
        return totalCellD1;
    }
}
