package org.pentaho.di.trans;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.trans.step.StepPartitioningMeta;

public abstract class BasePartitioner implements Partitioner {

	protected StepPartitioningMeta meta;
	protected int nrPartitions = -1;
	protected String id;
	protected String description;
	
	public BasePartitioner( ) {
	}
	
	public Partitioner clone() {
		Partitioner partitioner = getInstance();
		partitioner.setId( id );
		partitioner.setDescription(description);
		partitioner.setMeta(meta);
		return partitioner;
	}

	public int getNrPartitions() {
		return nrPartitions;
	}

	public void setNrPartitions(int nrPartitions) {
		this.nrPartitions = nrPartitions;
	}

	public void init(RowMetaInterface rowMeta ) throws KettleException
	{

        if( nrPartitions < 0 ) {
        	nrPartitions = meta.getPartitionSchema().getPartitionIDs().size();
        }

	}

	public StepPartitioningMeta getMeta() {
		return meta;
	}

	public void setMeta(StepPartitioningMeta meta) {
		this.meta = meta;
	}
	
	public abstract Partitioner getInstance();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
