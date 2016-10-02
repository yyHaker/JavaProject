package com.atguigu.spring.beans.collection;

import java.util.Properties;

public class DataSource {
  private Properties properties;

public Properties getProperties() {
	return properties;
}

public void setProperties(Properties properties) {
	this.properties = properties;
}

public DataSource() {
	super();
	// TODO Auto-generated constructor stub
}

public DataSource(Properties properties) {
	super();
	this.properties = properties;
}

@Override
public String toString() {
	return "DataSource [properties=" + properties + "]";
}
  
}
