package com.example.ktw_project_eatery.Repository;

import com.example.ktw_project_eatery.Entity.Eatery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// crud 제공
public interface EateryRepository extends JpaRepository<Eatery, Long> {

}
