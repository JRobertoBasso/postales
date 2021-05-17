package com.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.entity.Postal;

@Repository("postalRepository")
public interface PostalReposotory extends JpaRepository<Postal, Serializable>{

	public abstract List<Postal> findByZipCode(int code);
}
