/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.journal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.model.JournalStructureModel;
import com.liferay.portlet.journal.model.JournalStructureSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The base model implementation for the JournalStructure service. Represents a row in the &quot;JournalStructure&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.journal.model.JournalStructureModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalStructureImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalStructureImpl
 * @see com.liferay.portlet.journal.model.JournalStructure
 * @see com.liferay.portlet.journal.model.JournalStructureModel
 * @generated
 */
@JSON(strict = true)
public class JournalStructureModelImpl extends BaseModelImpl<JournalStructure>
	implements JournalStructureModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a journal structure model instance should use the {@link com.liferay.portlet.journal.model.JournalStructure} interface instead.
	 */
	public static final String TABLE_NAME = "JournalStructure";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id_", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "structureId", Types.VARCHAR },
			{ "parentStructureId", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "xsd", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table JournalStructure (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,structureId VARCHAR(75) null,parentStructureId VARCHAR(75) null,name STRING null,description STRING null,xsd TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table JournalStructure";
	public static final String ORDER_BY_JPQL = " ORDER BY journalStructure.structureId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JournalStructure.structureId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.journal.model.JournalStructure"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.journal.model.JournalStructure"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.journal.model.JournalStructure"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long PARENTSTRUCTUREID_COLUMN_BITMASK = 2L;
	public static long STRUCTUREID_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static JournalStructure toModel(JournalStructureSoap soapModel) {
		JournalStructure model = new JournalStructureImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStructureId(soapModel.getStructureId());
		model.setParentStructureId(soapModel.getParentStructureId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setXsd(soapModel.getXsd());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<JournalStructure> toModels(
		JournalStructureSoap[] soapModels) {
		List<JournalStructure> models = new ArrayList<JournalStructure>(soapModels.length);

		for (JournalStructureSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.journal.model.JournalStructure"));

	public JournalStructureModelImpl() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return JournalStructure.class;
	}

	public String getModelClassName() {
		return JournalStructure.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("structureId", getStructureId());
		attributes.put("parentStructureId", getParentStructureId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("xsd", getXsd());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String structureId = (String)attributes.get("structureId");

		if (structureId != null) {
			setStructureId(structureId);
		}

		String parentStructureId = (String)attributes.get("parentStructureId");

		if (parentStructureId != null) {
			setParentStructureId(parentStructureId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String xsd = (String)attributes.get("xsd");

		if (xsd != null) {
			setXsd(xsd);
		}
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getStructureId() {
		if (_structureId == null) {
			return StringPool.BLANK;
		}
		else {
			return _structureId;
		}
	}

	public void setStructureId(String structureId) {
		_columnBitmask = -1L;

		if (_originalStructureId == null) {
			_originalStructureId = _structureId;
		}

		_structureId = structureId;
	}

	public String getOriginalStructureId() {
		return GetterUtil.getString(_originalStructureId);
	}

	@JSON
	public String getParentStructureId() {
		if (_parentStructureId == null) {
			return StringPool.BLANK;
		}
		else {
			return _parentStructureId;
		}
	}

	public void setParentStructureId(String parentStructureId) {
		_columnBitmask |= PARENTSTRUCTUREID_COLUMN_BITMASK;

		if (_originalParentStructureId == null) {
			_originalParentStructureId = _parentStructureId;
		}

		_parentStructureId = parentStructureId;
	}

	public String getOriginalParentStructureId() {
		return GetterUtil.getString(_originalParentStructureId);
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	public void setName(String name) {
		_name = name;
	}

	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String name = nameMap.get(locale);

			setName(name, locale, defaultLocale);
		}
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String description = descriptionMap.get(locale);

			setDescription(description, locale, defaultLocale);
		}
	}

	@JSON
	public String getXsd() {
		if (_xsd == null) {
			return StringPool.BLANK;
		}
		else {
			return _xsd;
		}
	}

	public void setXsd(String xsd) {
		_xsd = xsd;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public JournalStructure toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (JournalStructure)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			JournalStructure.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		JournalStructureImpl journalStructureImpl = new JournalStructureImpl();

		journalStructureImpl.setUuid(getUuid());
		journalStructureImpl.setId(getId());
		journalStructureImpl.setGroupId(getGroupId());
		journalStructureImpl.setCompanyId(getCompanyId());
		journalStructureImpl.setUserId(getUserId());
		journalStructureImpl.setUserName(getUserName());
		journalStructureImpl.setCreateDate(getCreateDate());
		journalStructureImpl.setModifiedDate(getModifiedDate());
		journalStructureImpl.setStructureId(getStructureId());
		journalStructureImpl.setParentStructureId(getParentStructureId());
		journalStructureImpl.setName(getName());
		journalStructureImpl.setDescription(getDescription());
		journalStructureImpl.setXsd(getXsd());

		journalStructureImpl.resetOriginalValues();

		return journalStructureImpl;
	}

	public int compareTo(JournalStructure journalStructure) {
		int value = 0;

		value = getStructureId().compareTo(journalStructure.getStructureId());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		JournalStructure journalStructure = null;

		try {
			journalStructure = (JournalStructure)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = journalStructure.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		JournalStructureModelImpl journalStructureModelImpl = this;

		journalStructureModelImpl._originalUuid = journalStructureModelImpl._uuid;

		journalStructureModelImpl._originalGroupId = journalStructureModelImpl._groupId;

		journalStructureModelImpl._setOriginalGroupId = false;

		journalStructureModelImpl._originalStructureId = journalStructureModelImpl._structureId;

		journalStructureModelImpl._originalParentStructureId = journalStructureModelImpl._parentStructureId;

		journalStructureModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JournalStructure> toCacheModel() {
		JournalStructureCacheModel journalStructureCacheModel = new JournalStructureCacheModel();

		journalStructureCacheModel.uuid = getUuid();

		String uuid = journalStructureCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			journalStructureCacheModel.uuid = null;
		}

		journalStructureCacheModel.id = getId();

		journalStructureCacheModel.groupId = getGroupId();

		journalStructureCacheModel.companyId = getCompanyId();

		journalStructureCacheModel.userId = getUserId();

		journalStructureCacheModel.userName = getUserName();

		String userName = journalStructureCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			journalStructureCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			journalStructureCacheModel.createDate = createDate.getTime();
		}
		else {
			journalStructureCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			journalStructureCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			journalStructureCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		journalStructureCacheModel.structureId = getStructureId();

		String structureId = journalStructureCacheModel.structureId;

		if ((structureId != null) && (structureId.length() == 0)) {
			journalStructureCacheModel.structureId = null;
		}

		journalStructureCacheModel.parentStructureId = getParentStructureId();

		String parentStructureId = journalStructureCacheModel.parentStructureId;

		if ((parentStructureId != null) && (parentStructureId.length() == 0)) {
			journalStructureCacheModel.parentStructureId = null;
		}

		journalStructureCacheModel.name = getName();

		String name = journalStructureCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			journalStructureCacheModel.name = null;
		}

		journalStructureCacheModel.description = getDescription();

		String description = journalStructureCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			journalStructureCacheModel.description = null;
		}

		journalStructureCacheModel.xsd = getXsd();

		String xsd = journalStructureCacheModel.xsd;

		if ((xsd != null) && (xsd.length() == 0)) {
			journalStructureCacheModel.xsd = null;
		}

		return journalStructureCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", structureId=");
		sb.append(getStructureId());
		sb.append(", parentStructureId=");
		sb.append(getParentStructureId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", xsd=");
		sb.append(getXsd());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.journal.model.JournalStructure");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>structureId</column-name><column-value><![CDATA[");
		sb.append(getStructureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentStructureId</column-name><column-value><![CDATA[");
		sb.append(getParentStructureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xsd</column-name><column-value><![CDATA[");
		sb.append(getXsd());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = JournalStructure.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			JournalStructure.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _structureId;
	private String _originalStructureId;
	private String _parentStructureId;
	private String _originalParentStructureId;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _xsd;
	private long _columnBitmask;
	private JournalStructure _escapedModelProxy;
}