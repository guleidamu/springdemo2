package com.example.springdemo.businessSchool.constant.redis;

public abstract class BasePrefix implements KeyPrefix {


	private String prefix;

	public BasePrefix(){}

	public BasePrefix( String prefix) {
		this.prefix = prefix;
	}

	@Override
	public String getPrefix() {
		String className = getClass().getSimpleName();
		return className+":" + prefix;
	}


}
