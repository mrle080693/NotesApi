package com.prostosasha.notesapi.database.queries;

public interface Queries {
    String FIND_USER = "select e from User e where e.username = :username and e.password = :password";
    String FIND_USER_BY_PASSWORD = "select e from User e where e.password = :password";
    String GET_ALL_NOTES_BY_USER_ID = "select e from Note e where e.userId = :userId";
}
