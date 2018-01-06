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
package mx.infotec.dads.kukulkan.generator.angularjs.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import mx.infotec.dads.kukulkan.metamodel.foundation.ArchetypeType;


/**
 * A Project.
 */

@Document(collection = "project")
public class Project implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    private String id;

    /** The project id. */
    @NotNull
    @Size(min = 3)
    @Field("project_id")
    private String projectId;

    /** The app name. */
    @NotNull
    @Size(min = 3)
    @Field("app_name")
    private String appName;

    /** The author. */
    @NotNull
    @Size(min = 3)
    @Field("author")
    private String author;

    /** The version. */
    @NotNull
    @Size(min = 3)
    @Field("version")
    private String version;

    /** The year. */
    @NotNull
    @Size(min = 3)
    @Pattern(regexp = "^[0-9]+")
    @Field("year")
    private String year;

    /** The group id. */
    @NotNull
    @Field("group_id")
    private String groupId;

    /** The packaging. */
    @NotNull
    @Field("packaging")
    private String packaging;

    /** The data store. */
    @NotNull
    @Field("data_store")
    @DBRef
    private DataStore dataStore;

    /** The dao layer name. */
    @NotNull
    @Size(min = 3)
    @Field("dao_layer_name")
    private String daoLayerName;

    /** The domain layer name. */
    @NotNull
    @Size(min = 3)
    @Field("domain_layer_name")
    private String domainLayerName;

    /** The service layer name. */
    @NotNull
    @Size(min = 3)
    @Field("service_layer_name")
    private String serviceLayerName;

    /** The exception layer name. */
    @NotNull
    @Size(min = 3)
    @Field("exception_layer_name")
    private String exceptionLayerName;

    /** The web layer name. */
    @NotNull
    @Field("web_layer_name")
    private String webLayerName;

    /** The file. */
    @Field("file")
    private byte[] file;

    /** The file content type. */
    @Field("content_type")
    private String fileContentType;

    /** The archetype. */
    @NotNull
    @Field("archetype")
    private ArchetypeType archetype;

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
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the project id.
     *
     * @return the project id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Project id.
     *
     * @param projectId the project id
     * @return the project
     */
    public Project projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    /**
     * Sets the project id.
     *
     * @param projectId the new project id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * Gets the app name.
     *
     * @return the app name
     */
    public String getAppName() {
        return appName;
    }

    /**
     * App name.
     *
     * @param appName the app name
     * @return the project
     */
    public Project appName(String appName) {
        this.appName = appName;
        return this;
    }

    /**
     * Sets the app name.
     *
     * @param appName the new app name
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Author.
     *
     * @param author the author
     * @return the project
     */
    public Project author(String author) {
        this.author = author;
        return this;
    }

    /**
     * Sets the author.
     *
     * @param author the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Version.
     *
     * @param version the version
     * @return the project
     */
    public Project version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * Year.
     *
     * @param year the year
     * @return the project
     */
    public Project year(String year) {
        this.year = year;
        return this;
    }

    /**
     * Sets the year.
     *
     * @param year the new year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Gets the group id.
     *
     * @return the group id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Group id.
     *
     * @param groupId the group id
     * @return the project
     */
    public Project groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    /**
     * Sets the group id.
     *
     * @param groupId the new group id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * Gets the packaging.
     *
     * @return the packaging
     */
    public String getPackaging() {
        return packaging;
    }

    /**
     * Packaging.
     *
     * @param packaging the packaging
     * @return the project
     */
    public Project packaging(String packaging) {
        this.packaging = packaging;
        return this;
    }

    /**
     * Sets the packaging.
     *
     * @param packaging the new packaging
     */
    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    /**
     * Gets the data store.
     *
     * @return the data store
     */
    public DataStore getDataStore() {
        return dataStore;
    }

    /**
     * Data store.
     *
     * @param dataStore the data store
     * @return the project
     */
    public Project dataStore(DataStore dataStore) {
        this.dataStore = dataStore;
        return this;
    }

    /**
     * Sets the data stor.
     *
     * @param dataStore the new data stor
     */
    public void setDataStor(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    /**
     * Gets the dao layer name.
     *
     * @return the dao layer name
     */
    public String getDaoLayerName() {
        return daoLayerName;
    }

    /**
     * Dao layer name.
     *
     * @param daoLayerName the dao layer name
     * @return the project
     */
    public Project daoLayerName(String daoLayerName) {
        this.daoLayerName = daoLayerName;
        return this;
    }

    /**
     * Sets the dao layer name.
     *
     * @param daoLayerName the new dao layer name
     */
    public void setDaoLayerName(String daoLayerName) {
        this.daoLayerName = daoLayerName;
    }

    /**
     * Gets the domain layer name.
     *
     * @return the domain layer name
     */
    public String getDomainLayerName() {
        return domainLayerName;
    }

    /**
     * Domain layer name.
     *
     * @param domainLayerName the domain layer name
     * @return the project
     */
    public Project domainLayerName(String domainLayerName) {
        this.domainLayerName = domainLayerName;
        return this;
    }

    /**
     * Sets the domain layer name.
     *
     * @param domainLayerName the new domain layer name
     */
    public void setDomainLayerName(String domainLayerName) {
        this.domainLayerName = domainLayerName;
    }

    /**
     * Gets the service layer name.
     *
     * @return the service layer name
     */
    public String getServiceLayerName() {
        return serviceLayerName;
    }

    /**
     * Service layer name.
     *
     * @param serviceLayerName the service layer name
     * @return the project
     */
    public Project serviceLayerName(String serviceLayerName) {
        this.serviceLayerName = serviceLayerName;
        return this;
    }

    /**
     * Sets the service layer name.
     *
     * @param serviceLayerName the new service layer name
     */
    public void setServiceLayerName(String serviceLayerName) {
        this.serviceLayerName = serviceLayerName;
    }

    /**
     * Gets the exception layer name.
     *
     * @return the exception layer name
     */
    public String getExceptionLayerName() {
        return exceptionLayerName;
    }

    /**
     * Exception layer name.
     *
     * @param exceptionLayerName the exception layer name
     * @return the project
     */
    public Project exceptionLayerName(String exceptionLayerName) {
        this.exceptionLayerName = exceptionLayerName;
        return this;
    }

    /**
     * Sets the exception layer name.
     *
     * @param exceptionLayerName the new exception layer name
     */
    public void setExceptionLayerName(String exceptionLayerName) {
        this.exceptionLayerName = exceptionLayerName;
    }

    /**
     * Gets the web layer name.
     *
     * @return the web layer name
     */
    public String getWebLayerName() {
        return webLayerName;
    }

    /**
     * Web layer name.
     *
     * @param webLayerName the web layer name
     * @return the project
     */
    public Project webLayerName(String webLayerName) {
        this.webLayerName = webLayerName;
        return this;
    }

    /**
     * Sets the web layer name.
     *
     * @param webLayerName the new web layer name
     */
    public void setWebLayerName(String webLayerName) {
        this.webLayerName = webLayerName;
    }

    /**
     * Gets the archetype.
     *
     * @return the archetype
     */
    public ArchetypeType getArchetype() {
        return archetype;
    }

    /**
     * Archetype type.
     *
     * @param archetype the archetype
     * @return the project
     */
    public Project archetypeType(ArchetypeType archetype) {
        this.archetype = archetype;
        return this;
    }

    /**
     * Sets the archetype type.
     *
     * @param archetype the new archetype type
     */
    public void setArchetypeType(ArchetypeType archetype) {
        this.archetype = archetype;
    }

    /* (non-Javadoc)
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
        Project project = (Project) o;
        if (project.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), project.getId());
    }

    /**
     * Gets the file.
     *
     * @return the file
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * Sets the file.
     *
     * @param file the new file
     */
    public void setFile(byte[] file) {
        this.file = file;
    }

    /**
     * Gets the file content type.
     *
     * @return the file content type
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * Sets the file content type.
     *
     * @param fileContentType the new file content type
     */
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Project{" + "id=" + getId() + ", projectId='" + getProjectId() + "'" + ", appName='" + getAppName()
                + "'" + ", author='" + getAuthor() + "'" + ", version='" + getVersion() + "'" + ", year='" + getYear()
                + "'" + ", groupId='" + getGroupId() + "'" + ", packaging='" + getPackaging() + "'" + ", dataStor='"
                + getDataStore() + "'" + ", daoLayerName='" + getDaoLayerName() + "'" + ", domainLayerName='"
                + getDomainLayerName() + "'" + ", serviceLayerName='" + getServiceLayerName() + "'"
                + ", exceptionLayerName='" + getExceptionLayerName() + "'" + ", webLayerName='" + getWebLayerName()
                + "'" + ", archetype='" + getArchetype() + "'" + "}";
    }
}
