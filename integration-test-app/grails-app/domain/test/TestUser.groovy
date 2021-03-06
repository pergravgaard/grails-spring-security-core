/* Copyright 2006-2015 SpringSource.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class TestUser implements Serializable {

	private static final long serialVersionUID = 1

	String loginName
	String passwrrd
	boolean enabld
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	TestUser(String loginName, String passwrrd) {
		this()
		this.loginName = loginName
		this.passwrrd = passwrrd
	}

	@Override
	int hashCode() {
		loginName?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof TestUser && other.loginName == loginName)
	}

	@Override
	String toString() {
		loginName
	}

	Set<TestRole> getRoles() { TestUserRole.findAllByUser(this)*.role }
	Set<TestRoleGroup> getGroups() { TestUserRoleGroup.findAllByUser(this)*.roleGroup }
	Collection<String> getRoleNames() { roles*.auth }

	static constraints = {
		loginName blank: false, unique: true
		passwrrd blank: false
	}
}
