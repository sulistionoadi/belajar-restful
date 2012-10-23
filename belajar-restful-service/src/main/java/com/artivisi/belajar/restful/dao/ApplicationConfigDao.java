/**
 * Copyright (C) 2011 ArtiVisi Intermedia <info@artivisi.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.artivisi.belajar.restful.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.artivisi.belajar.restful.domain.ApplicationConfig;


public interface ApplicationConfigDao extends PagingAndSortingRepository<ApplicationConfig, String> {
    @Query("select count(a) from ApplicationConfig a")
	Long countAll();
    
    @Query("select ac from ApplicationConfig ac " +
			"where lower(ac.name) like lower(:search) " +
			"or lower(ac.label) like lower(:search) " +
			"or lower(ac.value) like lower(:search) " +
			"order by ac.name")
    List<ApplicationConfig> search(@Param("search") String search, Pageable page);
    
    @Query("select count(ac) from ApplicationConfig ac " +
			"where lower(ac.name) like lower(:search) " +
			"or lower(ac.label) like lower(:search) " +
			"or lower(ac.value) like lower(:search)")
    Long count(@Param("search") String search);
}