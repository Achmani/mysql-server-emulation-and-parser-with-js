package id.mit.chrono.server.factory;

import id.mit.chrono.server.database.dao.cell.CellDaoImpl;
import id.mit.chrono.server.database.dao.cellclass.CellClassDaoImpl;
import id.mit.chrono.server.database.dao.cellclassgroup.CellClassGroupDaoImpl;
import id.mit.chrono.server.database.dao.cellnodeid.CellNodeIdDaoImpl;
import id.mit.chrono.server.database.dao.cellpattern.CellPatternDaoImpl;
import id.mit.chrono.server.database.dao.cellstatus.CellStatusDaoImpl;
import id.mit.chrono.server.database.dao.collectortask.CollectorTaskDaoImpl;
import id.mit.chrono.server.database.dao.collectortaskfiles.CollectorTaskFilesDaoImpl;
import id.mit.chrono.server.database.dao.columnset.ColumnsetDaoImpl;
import id.mit.chrono.server.database.dao.datagroup.DataGroupDaoImpl;
import id.mit.chrono.server.database.dao.mapentity.MapEntityDaoImpl;
import id.mit.chrono.server.database.dao.mapfield.MapFieldDaoImpl;
import id.mit.chrono.server.database.dao.mapnptq.MapNPTQDaoImpl;
import id.mit.chrono.server.database.dao.mapparser.MapParserDaoImpl;
import id.mit.chrono.server.database.dao.node.NodeDaoImpl;
import id.mit.chrono.server.database.dao.nodecategory.NodeCategoryDaoImpl;
import id.mit.chrono.server.database.dao.nodemaps.NodeMapsDaoImpl;
import id.mit.chrono.server.database.dao.nodepattern.NodePatternDaoImpl;
import id.mit.chrono.server.database.dao.nodestatus.NodeStatusDaoImpl;
import id.mit.chrono.server.database.dao.nptq.NPTQDaoImpl;
import id.mit.chrono.server.database.dao.processortaskfiles.ProcessorTaskFilesDaoImpl;
import id.mit.chrono.server.database.dao.queryset.QuerysetDaoImpl;
import id.mit.chrono.server.database.dao.workflow.WorkflowDaoImpl;
import id.mit.chrono.server.database.dao.settings.SettingsDaoImpl;
import id.mit.chrono.server.database.dao.site.SiteDaoImpl;
import id.mit.chrono.server.database.dao.timecatalog.TimeCatalogDaoImpl;

public class DaoFactory {

    public static CellDaoImpl createCellDao() {
        return new CellDaoImpl();
    }

    public static CellClassDaoImpl createCellClassDao() {
        return new CellClassDaoImpl();
    }

    public static CellClassGroupDaoImpl createCellClassGroupDao() {
        return new CellClassGroupDaoImpl();
    }

    public static CellNodeIdDaoImpl createCellNodeIdDaoImpl() {
        return new CellNodeIdDaoImpl();
    }

    public static CellPatternDaoImpl createCellPatternDaoImpl() {
        return new CellPatternDaoImpl();
    }

    public static CellStatusDaoImpl createCellStatusDaoImpl() {
        return new CellStatusDaoImpl();
    }

    public static CollectorTaskDaoImpl createCollectorTaskDaoImpl() {
        return new CollectorTaskDaoImpl();
    }

    public static DataGroupDaoImpl createDataGroupDaoImpl() {
        return new DataGroupDaoImpl();
    }

    public static MapParserDaoImpl createMapParserDaoImpl() {
        return new MapParserDaoImpl();
    }

    public static NodeDaoImpl createNodeDaoImpl() {
        return new NodeDaoImpl();
    }

    public static NodeCategoryDaoImpl createNodeCategoryDaoImpl() {
        return new NodeCategoryDaoImpl();
    }

    public static NodeMapsDaoImpl createNodeMapsDaoImpl() {
        return new NodeMapsDaoImpl();
    }

    public static NodePatternDaoImpl createNodePatternDaoImpl() {
        return new NodePatternDaoImpl();
    }

    public static NodeStatusDaoImpl createNodeStatusDaoImpl() {
        return new NodeStatusDaoImpl();
    }

    public static SettingsDaoImpl createSettingsDaoImpl() {
        return new SettingsDaoImpl();
    }
    
    public static TimeCatalogDaoImpl createTimeCatalogDaoImpl() {
        return new TimeCatalogDaoImpl();
    }

    public static MapEntityDaoImpl createMapEntityDaoImpl() {
        return new MapEntityDaoImpl();
    }

    public static MapFieldDaoImpl createMapFieldDaoImpl() {
        return new MapFieldDaoImpl();
    }

    public static CollectorTaskFilesDaoImpl createCollectorTaskFilesDaoImpl() {
        return new CollectorTaskFilesDaoImpl();
    }

    public static ProcessorTaskFilesDaoImpl createProcessorTaskFilesDaoImpl() {
        return new ProcessorTaskFilesDaoImpl();
    }

    public static SiteDaoImpl createSiteDaoImpl() {
        return new SiteDaoImpl();
    }

    public static ColumnsetDaoImpl createColumnDaoImpl() {
        return new ColumnsetDaoImpl();
    }

    public static WorkflowDaoImpl getWorkflowDaoImpl() {
        return new WorkflowDaoImpl();
    }

    public static NPTQDaoImpl getNPTQDaoImpl() {
        return new NPTQDaoImpl();
    }

    public static MapNPTQDaoImpl getMapNPTQDaoImpl() {
        return new MapNPTQDaoImpl();
    }

    public static QuerysetDaoImpl getQuerysetDaoImpl() {
        return new QuerysetDaoImpl();
    }
}
