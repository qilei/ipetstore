package com.example.ipetstore.persistence.typehandler;

import com.example.ipetstore.domain.product.Attachment;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class AttachmentTypeHandler extends BaseTypeHandler<Attachment> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Attachment attachment,
      JdbcType jdbcType) throws SQLException {
    ps.setString(i, attachment.getFileName());
  }

  @Override
  public Attachment getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return new Attachment(rs.getString(columnName));
  }

  @Override
  public Attachment getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return new Attachment(rs.getString(columnIndex));
  }

  @Override
  public Attachment getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return new Attachment(cs.getString(columnIndex));
  }
}
