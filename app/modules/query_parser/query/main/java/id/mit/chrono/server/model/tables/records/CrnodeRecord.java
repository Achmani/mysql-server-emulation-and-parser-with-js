/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crnode;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CrnodeRecord extends UpdatableRecordImpl<CrnodeRecord> implements Record11<Integer, String, Integer, Integer, Integer, Integer, Integer, Integer, Date, Integer, Integer> {

    private static final long serialVersionUID = 1318564053;

    /**
     * Setter for <code>chrono.crnode.node_id</code>.
     */
    public void setNodeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_id</code>.
     */
    public Integer getNodeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crnode.node_code</code>.
     */
    public void setNodeCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_code</code>.
     */
    public String getNodeCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crnode.node_site</code>.
     */
    public void setNodeSite(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_site</code>.
     */
    public Integer getNodeSite() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crnode.node_nodecategory</code>.
     */
    public void setNodeNodecategory(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_nodecategory</code>.
     */
    public Integer getNodeNodecategory() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.crnode.node_nodetype</code>.
     */
    public void setNodeNodetype(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_nodetype</code>.
     */
    public Integer getNodeNodetype() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.crnode.node_revenueclass</code>.
     */
    public void setNodeRevenueclass(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_revenueclass</code>.
     */
    public Integer getNodeRevenueclass() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.crnode.node_nodeplace</code>.
     */
    public void setNodeNodeplace(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_nodeplace</code>.
     */
    public Integer getNodeNodeplace() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.crnode.node_timezone</code>.
     */
    public void setNodeTimezone(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_timezone</code>.
     */
    public Integer getNodeTimezone() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.crnode.node_builddate</code>.
     */
    public void setNodeBuilddate(Date value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_builddate</code>.
     */
    public Date getNodeBuilddate() {
        return (Date) get(8);
    }

    /**
     * Setter for <code>chrono.crnode.node_nodestate</code>.
     */
    public void setNodeNodestate(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_nodestate</code>.
     */
    public Integer getNodeNodestate() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.crnode.node_lastupdate</code>.
     */
    public void setNodeLastupdate(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.crnode.node_lastupdate</code>.
     */
    public Integer getNodeLastupdate() {
        return (Integer) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Integer, String, Integer, Integer, Integer, Integer, Integer, Integer, Date, Integer, Integer> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Integer, String, Integer, Integer, Integer, Integer, Integer, Integer, Date, Integer, Integer> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crnode.CRNODE.NODE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crnode.CRNODE.NODE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crnode.CRNODE.NODE_SITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Crnode.CRNODE.NODE_NODECATEGORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Crnode.CRNODE.NODE_NODETYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Crnode.CRNODE.NODE_REVENUECLASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Crnode.CRNODE.NODE_NODEPLACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Crnode.CRNODE.NODE_TIMEZONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field9() {
        return Crnode.CRNODE.NODE_BUILDDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return Crnode.CRNODE.NODE_NODESTATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return Crnode.CRNODE.NODE_LASTUPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getNodeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getNodeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getNodeSite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getNodeNodecategory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getNodeNodetype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getNodeRevenueclass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getNodeNodeplace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getNodeTimezone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component9() {
        return getNodeBuilddate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component10() {
        return getNodeNodestate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getNodeLastupdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getNodeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNodeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getNodeSite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getNodeNodecategory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getNodeNodetype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getNodeRevenueclass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getNodeNodeplace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getNodeTimezone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value9() {
        return getNodeBuilddate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getNodeNodestate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getNodeLastupdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value1(Integer value) {
        setNodeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value2(String value) {
        setNodeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value3(Integer value) {
        setNodeSite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value4(Integer value) {
        setNodeNodecategory(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value5(Integer value) {
        setNodeNodetype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value6(Integer value) {
        setNodeRevenueclass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value7(Integer value) {
        setNodeNodeplace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value8(Integer value) {
        setNodeTimezone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value9(Date value) {
        setNodeBuilddate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value10(Integer value) {
        setNodeNodestate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord value11(Integer value) {
        setNodeLastupdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodeRecord values(Integer value1, String value2, Integer value3, Integer value4, Integer value5, Integer value6, Integer value7, Integer value8, Date value9, Integer value10, Integer value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrnodeRecord
     */
    public CrnodeRecord() {
        super(Crnode.CRNODE);
    }

    /**
     * Create a detached, initialised CrnodeRecord
     */
    public CrnodeRecord(Integer nodeId, String nodeCode, Integer nodeSite, Integer nodeNodecategory, Integer nodeNodetype, Integer nodeRevenueclass, Integer nodeNodeplace, Integer nodeTimezone, Date nodeBuilddate, Integer nodeNodestate, Integer nodeLastupdate) {
        super(Crnode.CRNODE);

        set(0, nodeId);
        set(1, nodeCode);
        set(2, nodeSite);
        set(3, nodeNodecategory);
        set(4, nodeNodetype);
        set(5, nodeRevenueclass);
        set(6, nodeNodeplace);
        set(7, nodeTimezone);
        set(8, nodeBuilddate);
        set(9, nodeNodestate);
        set(10, nodeLastupdate);
    }
}
