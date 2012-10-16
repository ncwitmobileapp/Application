package com.ncwitmobileapp.server;

import com.google.web.bindery.requestfactory.shared.Locator;

public class AwardLocator extends Locator<Award, Void> {

		@Override
		public Award create(Class<? extends Award> clazz) {
			return new Award();
		}

		@Override
		public Award find(Class<? extends Award> clazz, Void id) {
			return create(clazz);
		}

		@Override
		public Class<Award> getDomainType() {
			return Award.class;
		}

		@Override
		public Void getId(Award domainObject) {
			return null;
		}

		@Override
		public Class<Void> getIdType() {
			return Void.class;
		}
		
		@Override
		public Object getVersion(Award domainObject) {
			return null;
		}
}
