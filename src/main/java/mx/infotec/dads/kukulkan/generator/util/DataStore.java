/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2016 Daniel Cortes Pichardo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.kukulkan.generator.util;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import mx.infotec.dads.kukulkan.metamodel.foundation.TableTypes;

/**
 * The Connection Class is used for hold the connection credentials to a
 * datasource.
 *
 * @author Daniel Cortes Pichardo
 */

public class DataStore implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private String id;

    /** The data store type. */
    private DataStoreType dataStoreType;

    /** The name. */
    private String name;

    // @Pattern(regexp =
    /** The url. */
    // "(?i)^(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))\\.?)(?::\\d{2,5})?(?:[/?#]\\S*)?$")
    private String url;

    /** The schema. */
    private String schema;

    /** The driver class. */
    @NotNull
    // @Pattern(regexp = ".*\"[[a-z]*\\.]+[A-Z][a-z]*\".*")
    private String driverClass;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /** The table types. */
    private TableTypes tableTypes;

    /** The script. */
    private String script;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Name.
     *
     * @param name
     *            the name
     * @return the data store
     */
    public DataStore name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Url.
     *
     * @param url
     *            the url
     * @return the data store
     */
    public DataStore url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Sets the url.
     *
     * @param url
     *            the new url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the driver class.
     *
     * @return the driver class
     */
    public String getDriverClass() {
        return driverClass;
    }

    /**
     * Driver class.
     *
     * @param driverClass
     *            the driver class
     * @return the data store
     */
    public DataStore driverClass(String driverClass) {
        this.driverClass = driverClass;
        return this;
    }

    /**
     * Sets the driver class.
     *
     * @param driverClass
     *            the new driver class
     */
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Username.
     *
     * @param username
     *            the username
     * @return the data store
     */
    public DataStore username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Sets the username.
     *
     * @param username
     *            the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Password.
     *
     * @param password
     *            the password
     * @return the data store
     */
    public DataStore password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the table types.
     *
     * @return the table types
     */
    public TableTypes getTableTypes() {
        return tableTypes;
    }

    /**
     * Table types.
     *
     * @param tableTypes
     *            the table types
     * @return the data store
     */
    public DataStore tableTypes(TableTypes tableTypes) {
        this.tableTypes = tableTypes;
        return this;
    }

    /**
     * Sets the table types.
     *
     * @param tableTypes
     *            the new table types
     */
    public void setTableTypes(TableTypes tableTypes) {
        this.tableTypes = tableTypes;
    }

    /**
     * Gets the data store type.
     *
     * @return the data store type
     */
    public DataStoreType getDataStoreType() {
        return dataStoreType;
    }

    /**
     * Sets the data store type.
     *
     * @param dataStoreType
     *            the new data store type
     */
    public void setDataStoreType(DataStoreType dataStoreType) {
        this.dataStoreType = dataStoreType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataStore dataStore = (DataStore) o;
        if (dataStore.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dataStore.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DataStore{" + "id=" + getId() + ", name='" + getName() + "'" + ", url='" + getUrl() + "'"
                + ", driverClass='" + getDriverClass() + "'" + ", username='" + getUsername() + "'" + ", tableTypes='"
                + getTableTypes() + "'" + "}";
    }

    /**
     * Gets the script.
     *
     * @return the script
     */
    public String getScript() {
        return script;
    }

    /**
     * Sets the script.
     *
     * @param script
     *            the new script
     */
    public void setScript(String script) {
        this.script = script;
    }

    /**
     * Gets the schema.
     *
     * @return the schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Sets the schema.
     *
     * @param schema
     *            the new schema
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }
}
