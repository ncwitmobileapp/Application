package com.ncwitmobileapp.server;

import com.google.web.bindery.requestfactory.shared.Locator;


public class TechicksmemberLocator extends Locator<Techicksmember, Void> {

	@Override
	public Techicksmember create(Class<? extends Techicksmember> clazz) {
		return new Techicksmember();
	}

	@Override
	public Techicksmember find(Class<? extends Techicksmember> clazz, Void id) {
		return create(clazz);
	}

	@Override
	public Class<Techicksmember> getDomainType() {
		return Techicksmember.class;
	}

	@Override
	public Void getId(Techicksmember domainObject) {
		return null;
	}

	@Override
	public Class<Void> getIdType() {
		return Void.class;
	}

	@Override
	public Object getVersion(Techicksmember domainObject) {
		return null;
	}

}
