package pe.edu.upeu.sysrubricas.sql;

import pe.edu.upeu.sysrubricas.entity.Instrumento;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class SqlInstrumento extends Instrumento implements SQLData {
    public SqlInstrumento() throws SQLException {
    }

    public String getSQLTypeName() throws SQLException {
        return "INSTRUMENTO_TYPE";
    }

    public void readSQL(SQLInput sqlInput, String string) throws SQLException {


        setInstrumento_id(sqlInput.readInt());
        setSemestre_id(sqlInput.readInt());
        setCl_id(sqlInput.readInt());
        setEstado(sqlInput.readInt());
        setTitulo(sqlInput.readString());
        setDescripcion(sqlInput.readNString());
        setUtils_id(sqlInput.readInt());

    }

    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(getInstrumento_id());
        sqlOutput.writeInt(getSemestre_id());
        sqlOutput.writeInt(getCl_id());
        sqlOutput.writeInt(getEstado());
        sqlOutput.writeString(getTitulo());
        sqlOutput.writeNString(getDescripcion());
        sqlOutput.writeInt(getUtils_id());
    }

}
