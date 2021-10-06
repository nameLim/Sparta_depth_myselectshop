package com.sparta_depth.fclass.repository;

import com.sparta_depth.fclass.model.Folder;
import com.sparta_depth.fclass.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUser(User user);
}