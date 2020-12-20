package com.prostosasha.notesapi.database;

import com.prostosasha.notesapi.database.queries.Queries;
import com.prostosasha.notesapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Try without @Query
    //@Query(Queries.FIND_USER)
    User findUserByUsernameAndPassword(String username, String password);
}
