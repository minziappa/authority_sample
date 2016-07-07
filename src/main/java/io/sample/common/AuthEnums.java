package io.sample.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AuthEnums {

	public enum Auth {
	    NONE("none", 0),
	    USER("user", 1, NONE),
	    SEMI_ADMIN("semi_admin", 2, NONE, USER),
	    SUPER_ADMIN("super_admin", 3, NONE, USER, SEMI_ADMIN);

	    private String name;
	    private int level;
	    private List<Auth> authoritiesList = new LinkedList<>();

	    private Auth(String name,int level,Auth... authorities) {
	        this.name = name;
	        Collections.addAll(authoritiesList, authorities);
	        authoritiesList.add(this);
	    }

	    public String getName() {
	        return name;
	    }
	    public int getLevel() {
	        return level;
	    }
	    public List<Auth> getAuthoritiesList() {
	        return authoritiesList;
	    }
	}

}