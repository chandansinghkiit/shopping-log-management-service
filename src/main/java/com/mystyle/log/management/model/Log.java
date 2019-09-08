/**
 * 
 */
package com.mystyle.log.management.model;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;

import lombok.Data;

/**
 * @author chandan
 *
 */



@Data
@Table("log")
public class Log implements IModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @Column("ip")
    private String ip;

    @Column("product_id")
    private Long productId;

    @Column("log_date")
    private LocalDateTime logDate;
}